package model;

public class Employee extends Person {
	private Integer empId;

	public Employee(){
	
	}

	public Employee(Integer empId){
		this.empId = empId;
	}

	public void setEmpId(Integer empId){
		this.empId = empId;
	}

	public Integer getEmpId(){
		return empId;
	}
}
