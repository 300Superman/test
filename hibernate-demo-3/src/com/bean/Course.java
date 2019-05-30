package com.bean;

import java.io.Serializable;
import java.util.Set;

public class Course implements Serializable {
	
	private Integer id;
	private String name;
	
	private Set<Student> students;
 	
	public Course() {
	}

	public Course(Integer id) {
		this.id = id;
	}

	public Course(String name) {
		this.name = name;
	}

	public Course(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
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

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}
