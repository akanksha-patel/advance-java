package listeners;

import javax.servlet.*;
import java.util.*;
import models.*;

public class AppListener implements ServletContextListener{
	public void contextInitialized(ServletContextEvent e){
		ServletContext context = e.getServletContext();

		ArrayList cities = City.collectAllCities();
		context.setAttribute("cities", cities);
	}

	public void contextDestroyed(ServletContextEvent e){
		
	}
}