package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import util.MailSender;

public class SendEmailServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		String email = request.getParameter("email");
		String msg = request.getParameter("msg");


		MailSender.sendMail(email, msg);


	}
}