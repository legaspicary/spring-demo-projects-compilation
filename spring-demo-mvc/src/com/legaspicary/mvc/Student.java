package com.legaspicary.mvc;

import java.util.LinkedHashMap;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Student {
	
	private String firstName;

	@NotNull(message="must not be spaces or empty")
	@Size(min=1, message="lastname is required")
	private String lastName;
	
	private String address;
	private String programmingLanguage;
	
	@NotNull(message="must not be empty")
	@Min(value=1, message = "# of courses must be greater than or equal to 1")
	@Max(value=8, message = "# of courses must be less than or equal to 8")
	private String coursesCount;
	
	@NotNull(message="must not be empty")
	@Pattern(regexp = "^[A-Z]{2}-[1-4]$", message = "invalid, sample input is IT-4" )
	private String programAndYear;
	
	private LinkedHashMap<String, String> addressOptions;
	private String[] operatingSystems;
	
	
	//custom validation sample ---> https://gist.github.com/darbyluv2code/0275ddb6e70e085a10fd464e36a42739
	public Student() {
		this.addressOptions = new LinkedHashMap<>();
		addressOptions.put("dal", "Dalaguete");
		addressOptions.put("tub", "Tuba");
		addressOptions.put("osl", "Oslob");
		addressOptions.put("pob", "Poblacion");
	}
	
	
	
	public String getProgramAndYear() {
		return programAndYear;
	}



	public void setProgramAndYear(String programAndYear) {
		this.programAndYear = programAndYear;
	}



	public String getCoursesCount() {
		return coursesCount;
	}



	public void setCoursesCount(String coursesCount) {
		this.coursesCount = coursesCount;
	}



	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	public String getProgrammingLanguage() {
		return programmingLanguage;
	}

	public void setProgrammingLanguage(String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}

	public LinkedHashMap<String, String> getAddressOptions() {
		return addressOptions;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
