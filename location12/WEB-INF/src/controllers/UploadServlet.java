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
		User user = (User)session.getAttribute("user");
		if(user!=null){
			boolean isMultiPart = ServletFileUpload.isMultipartContent(request);

			if(isMultiPart){
				DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
				ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

				try{
					List<FileItem> fileItems = servletFileUpload.parseRequest(request);

					for(FileItem fileItem : fileItems){
						if(fileItem.isFormField()){
							String field = fileItem.getFieldName();
							if(field.equals("email")){
								System.out.println("Email: "+fileItem.getString());
							}else{
								System.out.println("Password: "+fileItem.getString());
							}
							//String email = request.getParameter("email");//-----x
						}else{
							String fileName = fileItem.getName();
							String storagePath = getServletContext().getRealPath("/WEB-INF/uploads");
							File file = new File(storagePath, fileName);
							fileItem.write(file);
						}
					}
				}catch(FileUploadException e){
					e.printStackTrace();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
}




























