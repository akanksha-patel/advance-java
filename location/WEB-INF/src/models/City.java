package models;

import java.sql.*;
import java.util.*;

public class City{
	private Integer cityId;
	private String cityName;
	private State state;

	public void setCityId(Integer cityId){
		this.cityId =cityId;
	}

	public Integer getCityId(){
		return cityId;
	}

	public void setCityName(String cityName){
		this.cityName = cityName;
	}

	public String getCityName(){
		return cityName;
	}

	public void setState(State state){
		this.state = state;
	}

	public State getState(){
		return state;
	}
}