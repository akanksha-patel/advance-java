package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class DownloadServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		
		response.setContentType("application/pdf");
		response.setHeader("content-disposition", "attachment; filename=statement.pdf");

		OutputStream os = response.getOutputStream();
		
		InputStream is = getServletContext().getResourceAsStream("WEB-INF/abc3.pdf");
		
		int readCount = 0;
		byte[] arr = new byte[1024];
		while((readCount=is.read(arr))!=-1){
			os.write(arr);
		}		

		os.flush();
		os.close();
	}
}