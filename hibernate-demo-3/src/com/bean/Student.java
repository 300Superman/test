package com.bean;

import java.io.Serializable;
import java.util.Set;

public class Student implements Serializable {
	
	private Integer id;
	private String name;
	
	private Set<Course> courses;
	
	public Student() {
	}

	public Student(Integer id) {
		this.id = id;
	}

	public Student(String name) {
		this.name = name;
	}

	public Student(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
