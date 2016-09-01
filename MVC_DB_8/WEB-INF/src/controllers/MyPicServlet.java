package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import models.*;

public class MyPicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
	
		if(user!=null){
			OutputStream os = response.getOutputStream();

			InputStream is = getServletContext().getResourceAsStream("/WEB-INF/uploads/"+user.getEmail()+"/"+user.getPicPath());
			
			if(is==null){
				is = getServletContext().getResourceAsStream("/images/avatar.jpg");
			}

			byte[] arr = new byte[1024];
			int count = 0;
			while((count=is.read(arr))!=-1){
				os.write(arr);
			}

			os.flush();
			os.close();
		}	
	}
}




























