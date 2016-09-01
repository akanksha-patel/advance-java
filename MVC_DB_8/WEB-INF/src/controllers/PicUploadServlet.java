package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import models.User;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.fileupload.disk.*;

public class PicUploadServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
	
		if(user!=null){
			if(ServletFileUpload.isMultipartContent(request)){
				DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
				ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
				
				try{
					List<FileItem> fileItems = servletFileUpload.parseRequest(request);

					for(FileItem fileItem : fileItems){
						if(!fileItem.isFormField()){
							String picFileName = fileItem.getName();
							String realPath = getServletContext().getRealPath("/WEB-INF/uploads/"+user.getEmail());

							File file = new File(realPath, picFileName);

							fileItem.write(file);

							user.updateMyPic(picFileName);
							user.setPicPath(picFileName);
						}
					}
				}catch(FileUploadException e){
					e.printStackTrace();
				}catch(Exception e){
					e.printStackTrace();
				}

			}
		}		
		
		request.getRequestDispatcher("pic_upload.jsp").forward(request,response);
	}
}




























