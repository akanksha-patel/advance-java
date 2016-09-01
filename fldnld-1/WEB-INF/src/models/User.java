package models;

import java.sql.*;

public class User{
	private Integer userId;
	private String name;
	private String email;
	private String password;

	public User(String name,String email,String password){
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public boolean registerUser(){
		boolean flag = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fldnld?user=root&password=krishna");
			
			String qr  = "insert into users (user_nm,user_em,user_pw) value (?,?,?)";
			PreparedStatement ps = connection.prepareStatement(qr);
			ps.setString(1, name);	
			ps.setString(2, email);
			ps.setString(3, password);

			flag = ps.executeUpdate()==1;

			connection.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return flag;
	}	


	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
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