package models;

import java.sql.*;
import java.util.*;

public class Country{
	private Integer countryId;
	private String countryName;

	public void setCountryId(Integer countryId){
		this.countryId =countryId;
	}

	public Integer getCountryId(){
		return countryId;
	}

	public void setCountryName(String countryName){
		this.countryName = countryName;
	}

	public String getCountryName(){
		return countryName;
	}
}