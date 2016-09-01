package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

import java.util.ArrayList;
import models.City;

public class AppListener implements ServletContextListener{
	public void contextInitialized(ServletContextEvent ev){
		ServletContext  cont = ev.getServletContext();

		ArrayList<City> cities = City.collectCities();
		cont.setAttribute("cities", cities);

		System.out.println("++++++");
	}

	public void contextDestroyed(ServletContextEvent ev){
		
	}
}