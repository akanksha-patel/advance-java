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

	public City(Integer cityId, String cityName, State state){
		this.cityId = cityId;
		this.cityName= cityName;
		this.state = state;
	}

	//Other Methods
	public static ArrayList collectCities(String cityInit){
		ArrayList cities = new ArrayList();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/location?user=root&password=krishna");
			
			String q1 = "select c.city_id,c.city_name,s.state_name ";
			String q2 = "from cities as c inner join states as s ";
			String q3 = "on c.state_id=s.state_id and city_name like '"+cityInit+"%'";

			PreparedStatement ps = connection.prepareStatement(q1+q2+q3);
			
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				cities.add(new City(rs.getInt(1), rs.getString(2), new State(rs.getString(3))));
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