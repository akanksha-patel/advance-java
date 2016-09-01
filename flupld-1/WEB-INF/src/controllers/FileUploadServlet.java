package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import  org.apache.commons.fileupload.FileUploadException;
import  org.apache.commons.fileupload.FileItem;

public class FileUploadServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		//---------

		if(ServletFileUpload.isMultipartContent(request)){
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

			ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

			try{
				List<FileItem> fileItems = servletFileUpload.parseRequest(request);

				for(FileItem fileItem : fileItems){
					if(!fileItem.isFormField()){
						String uploadedFileName = fileItem.getName();

						String realPath = getServletContext().getRealPath("/WEB-INF/uploads");
						System.out.println("Real Path: "+realPath);

						File f = new File(realPath, uploadedFileName);

						fileItem.write(f);
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