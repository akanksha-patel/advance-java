package models;

import java.sql.*;
import java.util.*;

public class City{
	//Properties
	private Integer cityId;
	private String cityName;
	private State state;

	//Constructors
	public City(){
	
	}

	public City(Integer cityId, String cityName){
		this.cityId = cityId;
		this.cityName= cityName;
	}

	//Other Methods
	public static ArrayList collectCities(int stateId){
		ArrayList cities = new ArrayList();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/location?user=root&password=krishna");
			
			String query = "select city_id,city_name from cities where state_id=?";

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, stateId);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				cities.add(new City(rs.getInt(1), rs.getString(2)));
			}	

			connection.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return cities;
	}

	//Getter-Setters
	public void setCityId(Integer cityId){
		this.cityId =cityId;
	}

	public Integer getCityId(){
		return cityId;
	}

	public void setCityName(String cityName){
		this.cityName = cityName;
	}

	public String getCityName(){
		return cityName;
	}

	public void setState(State state){
		this.state = state;
	}

	public State getState(){
		return state;
	}
}