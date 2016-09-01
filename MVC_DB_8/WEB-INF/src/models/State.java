package models;

import java.sql.*;
import java.util.*;

public class State{
	//Variables/////////////////////////////////////////////
	private Integer stateId;
	private String state;

	//Constructors/////////////////////////////////////////
	public State(){
	
	}

	public State(Integer stateId, String state){
		this.stateId = stateId;
		this.state = state;
	}

	public State(Integer stateId){
		this.stateId = stateId;
	}



	//Other Mothods///////////////////////////////////////
	public static ArrayList collectStates(){
		ArrayList states = new ArrayList();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/location?user=root&password=krishna");
		
			String query = "select state_id,state_name from states";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				State state = new State(rs.getInt(1), rs.getString(2));

				states.add(state);
			}

			//System.out.println("City list collected.....");


			connection.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();	
		}

		return states;
	}


	
	//Getter-Setters////////////////////////////////////////
	public void setStateId(Integer stateId){
		this.stateId = stateId;
	}

	public Integer getStateId(){
		return stateId;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}	
}