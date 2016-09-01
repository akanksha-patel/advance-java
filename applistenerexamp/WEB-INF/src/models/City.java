package models;

import java.sql.*;
import java.util.*;

public class City{
	private Integer cityId;
	private String city;

	public City(Integer cityId,String city){
		this.cityId = cityId;
		this.city = city;
	}

	public static ArrayList collectAllCities(){
		
		ArrayList lst = new ArrayList();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?user=root&password=krishna");

			String q1 = "select city_id,city from cities";
			
			PreparedStatement pst = con.prepareStatement(q1);
	
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				City st = new City(rst.getInt(1),rst.getString(2));
				lst.add(st);
			}

			System.out.println("~~~~~~~~~12");
		
			con.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();	
		}catch(SQLException e){
			e.printStackTrace();
		}

		return lst;
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
