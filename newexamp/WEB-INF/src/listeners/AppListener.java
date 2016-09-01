package listeners;

import javax.servlet.*;
import models.*;

public class AppListener implements ServletContextListener{
	public void contextInitialized(ServletContextEvent e){
		ServletContext context = e.getServletContext();

		context.setAttribute("cities", City.collectCities());
	}

	public void contextDestroyed(ServletContextEvent e){
			
	}
}