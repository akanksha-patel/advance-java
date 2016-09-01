package controllers;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.Date;

import models.UserInfo;

public class SaveDobServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		UserInfo userInfo = (UserInfo)session.getAttribute("user_info");
		
		String dob = request.getParameter("dob");
		String msg = null;		
		if(!dob.trim().equals("")){
			try{
				Date date = Date.valueOf(dob);
				if(userInfo.updateDob(date)){
					userInfo.setDob(date);
					msg = "done";
				}else{
					//if updation failed
					msg = "failed";
				}
			}catch(IllegalArgumentException e){
				msg = "format_error";
				e.printStackTrace();
			}
		}else{
			//If not passed
			msg = "empty";
		}

		response.getWriter().write(msg);
	}
}