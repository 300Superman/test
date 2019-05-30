package com.bean;

import java.io.Serializable;

public class StudentAndCourse implements Serializable {

	private Integer id;
	private Integer studentId;
	private Integer courseId;
	
	public StudentAndCourse() {
	}

	public StudentAndCourse(Integer id) {
		this.id = id;
	}

	public StudentAndCourse(Integer studentId, Integer courseId) {
		this.studentId = studentId;
		this.courseId = courseId;
	}

	public StudentAndCourse(Integer id, Integer studentId, Integer courseId) {
		this.id = id;
		this.studentId = studentId;
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "StudentAndCourse [id=" + id + ", studentId=" + studentId + ", courseId=" + courseId + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
}
