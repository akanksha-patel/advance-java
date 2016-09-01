package models;

import java.sql.*;
import java.util.*;

public class City{
	//Variables/////////////////////////////////////////////
	private Integer cityId;
	private String city;

	//Constructors/////////////////////////////////////////
	public City(){
	
	}

	public City(Integer cityId, String city){
		this.cityId = cityId;
		this.city = city;
	}

	public City(Integer cityId){
		this.cityId = cityId;
	}



	//Other Mothods///////////////////////////////////////
	public static ArrayList collectCities(){
		ArrayList cities = new ArrayList();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?user=root&password=krishna");
		
			String query = "select city_id,city from cities";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				City city = new City(rs.getInt(1), rs.getString(2));

				cities.add(city);
			}

			System.out.println("City list collected.....");


			connection.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();	
		}

		return cities;
	}


	
	//Getter-Setters////////////////////////////////////////
	public void setCityId(Integer cityId){
		this.cityId = cityId;
	}

	public Integer getCityId(){
		return cityId;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}	
}