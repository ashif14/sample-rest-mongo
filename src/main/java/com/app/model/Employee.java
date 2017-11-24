package com.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
public class Employee{

	@Id
	private  String id;
	private String name;
	private String stream;
	private Double experience;
	private Double salary;
	
	public Employee(){
	}
	public Employee(String name, String stream, Double experience, Double salary){
		this.name = name;
		this.stream = stream;
		this.experience = experience;
		this.salary = salary;
	}
	
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return this.id;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	public void setStream(String stream){
		this.stream = stream;
	}
	public String getStream(){
		return this.stream;
	}
	
	public void setExperience(Double experience){
		this.experience = experience;
	}
	public Double getExperience(){
		return this.experience;
	}
	public void setSalary(Double salary){
		this.salary = salary;
	}
	public Double getSalary(){
		return this.salary;
	}
	@Override
	public String toString(){
		return String.format("Customer[id= %s, Name= %s, Stream= %s, Experience= %s, Salary= %s]",id, name, stream, experience, salary);
	}
}

