package models;

import java.sql.*;

public class User{
	private Integer userId;
	private String userName;
	private String email;
	private String password;
	private Gender gender;
	private City city;
	private UserType userType;
	
	public User(){
	
	}

	public User(String email, String password){
		super();
		this.email = email;
		this.password = password;
	}



	//Other Methods
	public static boolean checkEmail(String email){
		boolean flag = false;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?user=root&password=krishna");

			String query = "select user_id from users where email=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
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
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?user=root&password=krishna");

			String query = "insert into users (user_name,email,password,gender_id,city_id) value (?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,userName);
			ps.setString(2,email);
			ps.setString(3,password);
			ps.setInt(4, gender.getGenderId());
			ps.setInt(5, city.getCityId());

			int rowCount = ps.executeUpdate();

			if(rowCount==1){
				flag = true;
			}
			
			connection.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}	

		return flag;
	}//Register method ends


	public boolean loginUser(){
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?user=root&password=krishna");
			
			String query = "select user_id,user_name,gender_id,city_id,user_type_id from users where email=? and password=?";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				userId = rs.getInt(1);
				userName = rs.getString(2);
				gender = new Gender(rs.getInt(3));
				city = new City(rs.getInt(4));
				userType = new UserType(rs.getInt(5));

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

	public void setGender(Gender gender){
		this.gender = gender;
	}

	public Gender getGender(){
		return gender;
	}

	public void setCity(City city){
		this.city = city;
	}

	public City getCity(){
		return city;
	}
	
	public void setUserType(UserType userType){
		this.userType = userType;
	}

	public UserType getUserType(){
		return userType;
	}
}