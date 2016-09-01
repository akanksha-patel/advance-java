package models;

import java.sql.*;
import java.util.*;

public class City{
	private Integer cityId;
	private String city;

	public City(){
		super();
	}

	//-----------------------
	public static ArrayList collectCities(){
		
		ArrayList cities = new ArrayList(); 

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newexamp?user=root&password=krishna");
			
			String query = "select city_id,city from cities";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				cities.add(new City(resultSet.getInt(1), resultSet.getString(2)));			
			}

			connection.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return cities;
	}




	//----------------------
	public City(Integer cityId){
		this.cityId = cityId;		
	}

	public City(Integer cityId, String city){
		this.cityId = cityId;
		this.city = city;
	}

	public void setCity(String city){
		this.city = city;	
	}

	public String getCity(){
		return city;
	}

	public void setCityId(Integer cityId){
		this.cityId = cityId;	
	}

	public Integer getCityId(){
		return cityId;
	}
}