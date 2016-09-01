package models;

import java.sql.*;
import java.util.*;

public class State{
	private Integer stateId;
	private String stateName;
	private Country country;

	public State(Integer stateId, String stateName){
		this.stateId = stateId;
		this.stateName = stateName;
	}
	
	public static ArrayList<State> collectStates(int countryId){
		ArrayList<State> states = new ArrayList<State>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/location?user=root&password=krishna");
			
			String query = "select state_id,state_name from states where country_id=?";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, countryId);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				states.add(new State(rs.getInt(1), rs.getString(2)));
			}

			connection.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return states;
	}




	public void setStateId(Integer stateId){
		this.stateId =stateId;
	}

	public Integer getStateId(){
		return stateId;
	}

	public void setStateName(String stateName){
		this.stateName = stateName;
	}

	public String getStateName(){
		return stateName;
	}

	public void setCountry(Country country){
		this.country = country;
	}

	public Country getCountry(){
		return country;
	}
}