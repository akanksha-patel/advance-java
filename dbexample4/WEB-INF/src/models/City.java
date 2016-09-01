package models;

import java.sql.*;
import java.util.*;

public class City{
	private Integer cityId;
	private String city;

	public City(){
	
	}


	public static ArrayList<City> collectCities(){
		ArrayList<City> cities = new ArrayList<City>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?user=root&password=krishna");
			
			String query = "select city_id,city from cities";

			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				City city = new City();
				city.cityId = rs.getInt(1);
				city.city = rs.getString(2);

				cities.add(city);
			}

			connection.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return cities;
	}

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