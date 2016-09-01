package controllers;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.Date;

import models.UserInfo;

public class SaveCityServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		UserInfo userInfo = (UserInfo)session.getAttribute("user_info");
		
		String cityId = request.getParameter("cityid");
		String msg = null;
		if(!cityId.equals("0")){
			Integer ctId = Integer.parseInt(cityId);
			if(userInfo.updateCity(ctId)){
				msg = "done";
				userInfo.getCity().setCityId(ctId);
			}else{
				msg = "failed";				
			}
		}else{
			msg = "empty";			
		}

		response.getWriter().write(msg);
	}
}