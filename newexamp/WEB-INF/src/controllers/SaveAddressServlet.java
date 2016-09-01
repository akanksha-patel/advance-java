package controllers;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.Date;

import models.UserInfo;

public class SaveAddressServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		UserInfo userInfo = (UserInfo)session.getAttribute("user_info");
		
		String address = request.getParameter("address");
		String msg = null;
		if(!address.trim().equals("")){
			if(userInfo.updateAddress(address)){
				msg = "done";
				userInfo.setAddress(address);
			}else{
				msg = "failed";				
			}
		}else{
			msg = "empty";			
		}

		response.getWriter().write(msg);
	}
}