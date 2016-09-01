package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import model.*;

public class StandardActionServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
							throws IOException, ServletException{
		
		//Case 1:
		/*
		String name = request.getParameter("nm");
		String age = request.getParameter("ag");
		String empId = request.getParameter("empid");
		
		Employee emp = new Employee();
		emp.setName(name);
		emp.setAge(Integer.parseInt(age));
		emp.setEmpId(Integer.parseInt(empId));

		request.setAttribute("prsn", emp);
		*/
				

		RequestDispatcher vw = request.getRequestDispatcher("nxpg.jsp");
		vw.forward(request,response);
	}
}