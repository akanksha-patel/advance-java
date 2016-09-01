package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import models.*;

import org.json.*;

public class StateServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
							throws IOException,ServletException{
		int countryId = Integer.parseInt(request.getParameter("countryid"));	

		ArrayList states = State.collectStates(countryId);

		JSONArray jsArr = new JSONArray();

		for(int i=0;i<states.size();i++){
			State state = (State)states.get(i);
			JSONObject jsobj = new JSONObject();

			try{
				jsobj.put("stateid", state.getStateId());
				jsobj.put("statenm", state.getStateName());

				jsArr.put(i, jsobj);
			}catch(JSONException e){
				e.printStackTrace();
			}			
		}

		response.getWriter().write(jsArr.toString());

		//request.setAttribute("states", states);

		//request.getRequestDispatcher("index.jsp").forward(request,response);
	}
}