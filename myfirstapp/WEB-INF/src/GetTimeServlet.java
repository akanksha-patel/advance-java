import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class GetTimeServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		pw.write("<h1>"+new Date()+"</h1>");

		pw.write("<h1>Request Object: "+request+"</h1>");
		pw.write("<h1>Response Object: "+response+"</h1>");

		pw.flush();
		pw.close();
	}
}