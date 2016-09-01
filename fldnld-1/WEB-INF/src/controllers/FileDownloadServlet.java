package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import models.User;

public class FileDownloadServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		response.setContentType("application/pdf");
		response.setHeader("content-disposition", "attachment; filename=abc.pdf");
		
		InputStream is = getServletContext().getResourceAsStream("/WEB-INF/uploads/dd.pdf");

		OutputStream os = response.getOutputStream();

		byte[] arr = new byte[1024];
		int count = 0;
		while((count=is.read(arr))!=-1){
			os.write(arr);
		}

		os.flush();
		os.close();
	}
}