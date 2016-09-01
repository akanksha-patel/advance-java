package models;

import java.sql.*;

public class User{
	private Integer userId;
	private String userName;
	private String email;
	private String password;
	
	//Constructors
	public User(){
		super();
	}

	public User(String userName, String email, String password){
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	public User(String email, String password){
		this.email = email;
		this.password = password;
	}
	
	
	//methods
	public boolean registerUser(){
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?user=root&password=krishna");
			
			String query = "insert into users (user_name,email,password) value (?,?,?)";
			PreparedStatement ps =connection.prepareStatement(query);
			
			ps.setString(1, userName);
			ps.setString(2, email);
			ps.setString(3, password);

			//System.out.println(ps);

			//System.out.println("Rows Affected: "+ps.executeUpdate());

			int result = ps.executeUpdate();
			if(result==1){
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



	public boolean loginUser(){
		boolean flag = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?user=root&password=krishna");
			
			String query = "select user_id,user_name from users where email=? and password=?";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				userId = rs.getInt(1);
				userName = rs.getString(2);
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








	//getter setters
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