package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

public class FileUpload2Servlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		
		if(ServletFileUpload.isMultipartContent(request)){
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			
			ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
			
			try{
				List<FileItem> fileItems = servletFileUpload.parseRequest(request);

				for(FileItem fileItem : fileItems){
					if(fileItem.isFormField()){
						String fieldName = fileItem.getFieldName();
						String fieldValue = fileItem.getString();
						
						System.out.println(fieldName+" : "+fieldValue);
					}else{
						String fileNameUploaded = fileItem.getName();

						String realPath = getServletContext().getRealPath("/");

						File file = new File(realPath, fileNameUploaded);

						fileItem.write(file);
					}
				}			
			}catch(FileUploadException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}	
		}


		request.getRequestDispatcher("index.html").forward(request,response);
	}
}