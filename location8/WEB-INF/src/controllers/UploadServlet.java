package controllers;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.util.*;

import models.*;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

public class UploadServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = request.getSession();
		
		String nextPage = "login.jsp";
		User user = (User)session.getAttribute("user");
			
		if(user!=null){			
			boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
			
				System.out.println("+++++++@@@"+isMultiPart);
			if(isMultiPart){
				System.out.println("+++++++###");
				DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
				ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
				
				try{
					List<FileItem> fileItems = servletFileUpload.parseRequest(request);
					
					System.out.println("+++++++&&&"+fileItems);
					for(FileItem fileItem : fileItems){
						if(!fileItem.isFormField()){
							String fileName = fileItem.getName();
							String contextPath = getServletContext().getRealPath("/WEB-INF/uploads");
							File file = new File(contextPath, fileName);
							System.out.println("+++++++"+file);
							fileItem.write(file);
						}
					}
				}catch(FileUploadException e){
					e.printStackTrace();
				}catch(Exception e){
					e.printStackTrace();
				}
				
				nextPage = "upload_success.jsp";
			}else{
				nextPage = "upload.jsp";
			}		
		}		
		
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}




























