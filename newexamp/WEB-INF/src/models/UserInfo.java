package models;

import java.sql.*;

import models.User;

public class UserInfo{
	private Integer userInfoId;
	private User user;
	private Date dob;
	private String address;
	private City city;

	public UserInfo(User user){
		this.user = user;
	}


	public boolean updateCity(Integer cityId){

		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newexamp?user=root&password=krishna");
			
			String query = "update user_info set city_id=? where user_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, cityId);
			preparedStatement.setInt(2, user.getUserId());
			
			if(preparedStatement.executeUpdate()==1){
				flag = true;
			}

			connection.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return flag;
	}


	public boolean updateAddress(String address){

		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newexamp?user=root&password=krishna");
			
			String query = "update user_info set address=? where user_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, address);
			preparedStatement.setInt(2, user.getUserId());
			
			if(preparedStatement.executeUpdate()==1){
				flag = true;
			}

			connection.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return flag;
	}

	public boolean updateDob(Date dob){

		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newexamp?user=root&password=krishna");
			
			String query = "update user_info set dob=? where user_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setDate(1, dob);
			preparedStatement.setInt(2, user.getUserId());
			
			if(preparedStatement.executeUpdate()==1){
				flag = true;
			}

			connection.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return flag;
	}

	public void collectUserDetails(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newexamp?user=root&password=krishna");
			
			String query = "select user_info_id,dob,address,city_id from user_info where user_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, user.getUserId());

			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				userInfoId = resultSet.getInt(1);
				dob = resultSet.getDate(2);
				address = resultSet.getString(3);
				city = new City(resultSet.getInt(4)); 
			}

			connection.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}


	public void registerUserInfo(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newexamp?user=root&password=krishna");
			
			String query = "insert into user_info (user_id) value (?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, user.getUserId());

			preparedStatement.executeUpdate();
			
			connection.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}





	public void setUserInfoId(Integer userInfoId){
		this.userInfoId = userInfoId;
	}

	public Integer getUserInfoId(){
		return userInfoId;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	public void setDob(Date dob){
		this.dob = dob;
	}

	public Date getDob(){
		return dob;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setCity(City city){
		this.city = city;	
	}

	public City getCity(){
		return city;
	}
}