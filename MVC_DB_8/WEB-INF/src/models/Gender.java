package models;

public class Gender{
	private Integer genderId;
	private String gender;

	public static final int FEMALE = 1;
	public static final int MALE = 2;

	public Gender(){
		super();
	}

	public Gender(Integer genderId){
		this.genderId = genderId;
	}

	public Gender(Integer genderId, String gender){
		this.genderId = genderId;
		this.gender = gender;
	}

	public void setGenderId(Integer genderId){
		this.genderId = genderId;
	}

	public Integer getGenderId(){
		return genderId;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}
}