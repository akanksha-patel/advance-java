package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import models.*;
import utils.*;

import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.*;



public class RegisterServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		//1. Create Session
		HttpSession session = request.getSession();

		//2. Forward Page
		String nextPage = "login.jsp";

		String userName = null;
		String email = null;
		String password = null;
		String confirmPassword = null;
		String genderId = null;
		String cityId = null;
		String picPath = null;

		//Get Parameters
		if(ServletFileUpload.isMultipartContent(request)){
			try{
				List<FileItem> fileItems = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				for(FileItem fileItem : fileItems){
					if(fileItem.isFormField()){
						String fieldName = fileItem.getFieldName();
						if(fieldName.equals("username")){
							userName = fileItem.getString();
						}else if(fieldName.equals("email")){
							email = fileItem.getString();
						}else if(fieldName.equals("password")){
							password = fileItem.getString();
						}else if(fieldName.equals("confirm_password")){
							confirmPassword = fileItem.getString();
						}else if(fieldName.equals("gender")){
							genderId = fileItem.getString();
						}else if(fieldName.equals("city")){
							cityId = fileItem.getString();
						}
					}else{
						String fileName = fileItem.getName();
						picPath = fileName;
						String storagePath = getServletContext().getRealPath("/uploads");
						File userPath = new File(storagePath, email);
						userPath.mkdir();
						File file = new File(userPath, fileName);
						fileItem.write(file);
					}
				}
			}catch(FileUploadException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}


			//Validate Parameter information
			boolean flag = true;
			String msg = "";

			if(userName.trim().equals("")){
				flag = false;
				msg = msg + "User name required. <br />";
			}

			if(email.trim().equals("")){
				flag = false;
				msg = msg + "Email is required. <br />";
			}

			if(password.trim().equals("")){
				flag = false;
				msg = msg + "Password is mandatory. <br />";
			}

			if(password.trim().length()<6||password.trim().length()>10){
				flag = false;
				msg = msg + "Password must be greater than 5 character and less than 16 characters. <br />";
			}

			if(!password.trim().equals(confirmPassword.trim())){
				flag = false;
				msg = msg + "Password and Confirm Password must match. <br />";
			}

			if(genderId==null){
				flag = false;
				msg = msg + "Gender is mandatory. <br />";
			}

			if(cityId.equals("0")){
				flag = false;
				msg = msg + "City is required. <br />";
			}

			//If All OK - Register User
			if(flag){
				User user = new User();
				user.setUserName(userName);
				user.setEmail(email);
				user.setPassword(password);
				user.setGender(new Gender(Integer.parseInt(genderId)));
				user.setCity(new City(Integer.parseInt(cityId)));
				String activationCode = new Date().getTime()+session.getId();
				user.setActivationCode(activationCode);
				user.setPicPath(picPath);

				if(user.registerUser()){				
					//MailSend.sendAccountActivationMail(email, activationCode);
				}else{
					msg = msg + "Duplicate email record inserted<br />";
					request.setAttribute("msg", msg);
					nextPage = "register.jsp";
				}
			}
			//Else - Send Error
			else{
				nextPage = "register.jsp";
				request.setAttribute("msg", msg);
			}

			//Forward to another page
			request.getRequestDispatcher(nextPage).forward(request,response);
		}	
	}
}