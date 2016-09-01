package listeners;

import models.*;
import java.util.*;
import javax.servlet.*;

public class AppListener implements ServletContextListener{
	
	public void contextInitialized(ServletContextEvent event){
		ArrayList cities = City.collectCities();
		ArrayList states = State.collectStates();

		ServletContext context = event.getServletContext();

		context.setAttribute("cities", cities);
		context.setAttribute("states", states);
	}

	public void contextDestroyed(ServletContextEvent event){
	
	}
	
}