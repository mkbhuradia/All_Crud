package com.jdbc_entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("student")
@Entity
@Table(name="student1")
public class Student {
	@Id
	@Column(name="id",length=3)
	private int student_id;
	@Column(name="name",length=25)
	private String student_name;
	@Column(name="address",length=25)
	private String student_address;
	//@Column(name="school")
	@Transient
	private School school;
	@Autowired
	@Transient
	JdbcTemplate jdbcTemplate;
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int student_id, String student_name, String student_address, School school) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_address = student_address;
		this.school = school;
	}
	
	public Student(int student_id, String student_name, String student_address) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_address = student_address;
		
	}
	public Student(School school) {
		super();
		this.school = school;
	}
	public int getStudent_id() {
		return student_id;
	}

	public Student(int student_id) {
		super();
		this.student_id = student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_address() {
		return student_address;
	}

	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", student_address="
				+ student_address + ", school=" + school + "]";
	}

}
