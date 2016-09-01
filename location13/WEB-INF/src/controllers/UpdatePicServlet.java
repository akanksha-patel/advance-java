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

public class UpdatePicServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		
		if(user!=null){
			boolean isMultiPart = ServletFileUpload.isMultipartContent(request);

			if(isMultiPart){
				System.out.println("++++ ~~~~");
				DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
				ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

				try{
					List<FileItem> fileItems = servletFileUpload.parseRequest(request);

					for(FileItem fileItem : fileItems){
						System.out.println("++++ ~~~~ +++");
						if(!fileItem.isFormField()){
							
							String fileName = fileItem.getName();
							System.out.println("++++ "+fileName);
							String storagePath = getServletContext().getRealPath("/WEB-INF/uploads/"+user.getEmail());
							File file = new File(storagePath, fileName);
							fileItem.write(file);

							user.updatePicPath(fileName);
						}
					}
				}catch(FileUploadException e){
					e.printStackTrace();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		request.getRequestDispatcher("fileupload.jsp").forward(request,response);
	}
}




























