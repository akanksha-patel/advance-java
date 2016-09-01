package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import models.*;
import java.util.*;

import org.json.*;

public class CollectCitiesServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		

		Integer stateId = Integer.parseInt(request.getParameter("stateid"));
		ArrayList cities = City.collectCities(stateId);

		JSONArray ja = new JSONArray();
		
		for(int i=0;i<cities.size();i++){
			City city = (City)cities.get(i);
			JSONObject jo = new JSONObject();

			try{
				jo.put("cityid", city.getCityId());
				jo.put("city", city.getCity());

				ja.put(i, jo);
			}catch(JSONException e){
				e.printStackTrace();
			}
		}

		response.getWriter().write(ja.toString());
	}
}




























