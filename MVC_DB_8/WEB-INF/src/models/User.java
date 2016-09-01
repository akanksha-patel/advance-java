package models;

import java.sql.*;
import org.jasypt.util.password.StrongPasswordEncryptor;

public class User{
	private Integer userId;
	private String userName;
	private String email;
	private String password;
	private Gender gender;
	private City city;
	private UserType userType;
	private String activationCode;
	private Boolean activationStatus;
	private String picPath;
	
	public User(){
	
	}

	public User(String email, String password){
		super();
		this.email = email;
		this.password = password;
	}



	//Other Methods
	public boolean registerUser(){
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?user=root&password=krishna");

			String query = "insert into users (user_name,email,password,gender_id,city_id,activation_code) value (?,?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,userName);
			ps.setString(2,email);

			StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
			String encPass = spe.encryptPassword(password);
			ps.setString(3,encPass);
			
			ps.setInt(4, gender.getGenderId());
			ps.setInt(5, city.getCityId());
			ps.setString(6, activationCode);

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
						
			String q1 = "select u.password,u.user_id,u.user_name,u.gender_id,g.gender,";
			String q2 = "u.city_id,c.city,u.user_type_id,t.user_type,u.activation_status,pic_path from ";
			String q3 = "users as u inner join cities as c inner join genders as g inner join ";
			String q4 = "user_types as t where u.city_id=c.city_id and u.gender_id=g.gender_id ";
			String q5 = "and u.user_type_id=t.user_type_id and email=?";
			
			PreparedStatement ps = connection.prepareStatement(q1+q2+q3+q4+q5);

			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();
			
			StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
			if(rs.next()&&spe.checkPassword(password, rs.getString(1))){
				userId = rs.getInt(2);
				userName = rs.getString(3);
				gender = new Gender(rs.getInt(4),rs.getString(5));
				city = new City(rs.getInt(6), rs.getString(7));
				userType = new UserType(rs.getInt(8), rs.getString(9));
				activationStatus = rs.getBoolean(10);
				picPath = rs.getString(11);

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


	public static boolean checkAccountStatus(String email, String activationCode){
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?user=root&password=krishna");
			
			String query = "select user_id from users where email=? and activation_code=?";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, email);
			ps.setString(2, activationCode);
			
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


	public static void activateAccount(String email){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?user=root&password=krishna");
			
			String query = "update users set activation_status=1 where email=?";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, email);
			
			ps.executeUpdate();

			connection.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}	
	}


	public void updateMyPic(String picFileName){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?user=root&password=krishna");
			
			String query = "update users set pic_path=? where email=?";
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, picFileName);
			ps.setString(2, email);
			
			ps.executeUpdate();

			connection.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}


	//getter - setters
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

	public void setActivationCode(String activationCode){
		this.activationCode = activationCode;
	}

	public String getActivationCode(){
		return activationCode;
	}

	public void setPicPath(String picPath){
		this.picPath = picPath;
	}

	public String getPicPath(){
		return picPath;
	}
}