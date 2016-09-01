package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.util.*;
import models.*;

import org.json.*;

public class CityServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		int stateId = Integer.parseInt(request.getParameter("stateid"));

		ArrayList cities = City.collectCities(stateId);

		JSONArray ctArr = new JSONArray();

		for(int i=0;i<cities.size();i++){
			City city = (City)cities.get(i);

			JSONObject jsobj = new JSONObject();

			try{
				jsobj.put("cityid", city.getCityId());	
				jsobj.put("citynm", city.getCityName());

				ctArr.put(i, jsobj);
			}catch(JSONException e){
				e.printStackTrace();
			}
		}

		response.getWriter().write(ctArr.toString());
	}
}