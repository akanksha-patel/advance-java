package models;

import java.sql.*;

public class User{
	private Integer userId;
	private String userName;
	private String email;
	private String password;
	
	public User(){
		super();
	}

	public User(String email, String password){
		this.email = email;
		this.password = password;
	}

	public boolean loginUser(){
		
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newexamp?user=root&password=krishna");
			
			String query = "select user_id,user_name from users where email=? and password=?";

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				userId = resultSet.getInt(1);
				userName = resultSet.getString(2);

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


	public boolean registerUser(){
		
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newexamp?user=root&password=krishna");
			
			String query = "insert into users (user_name,email,password) value (?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, password);

			if(preparedStatement.executeUpdate()==1){
				flag = true;

				ResultSet resultSet = preparedStatement.getGeneratedKeys();
				if(resultSet.next()){
					userId = resultSet.getInt(1);
				}
			}

			connection.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return flag;
	}



	

	public void setUserId(Integer userId){
		this.userId = userId;
	}

	public Integer getUserId(){
		return userId;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}
}