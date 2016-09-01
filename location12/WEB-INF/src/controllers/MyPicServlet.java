package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import models.*;

public class MyPicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");
		
		//+++++++++++++++++++++++++

		if(user!=null){
			response.setContentType("image/jpeg");

			OutputStream os = response.getOutputStream();
			
			InputStream is = getServletContext().getResourceAsStream("WEB-INF/uploads/"+user.getEmail()+"/"+user.getPicPath());
			
			int readCount = 0;
			byte[] arr = new byte[1024];
			while((readCount=is.read(arr))!=-1){
				os.write(arr);
			}		

			os.flush();
			os.close();
		
		}
	}
}