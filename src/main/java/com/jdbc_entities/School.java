package com.jdbc_entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component("school")
@Entity
@Table(name="school")
public class School {
	@Id
	@Column(name="schoolId",length=3)
	private int school_id;
	@Column(name="schoolName",length=25)
	private String school_name;
	@Column(name="schoolAddress",length=50)
	private String school_address;

	public School() {
		super();
		// TODO Auto-generated constructor stub
	}

	public School(int school_id, String school_name, String school_address) {
		super();
		this.school_id = school_id;
		this.school_name = school_name;
		this.school_address = school_address;
	}

	public int getSchool_id() {
		return school_id;
	}

	public void setSchool_id(int school_id) {
		this.school_id = school_id;
	}

	public String getSchool_name() {
		return school_name;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}

	public String getSchool_address() {
		return school_address;
	}

	public void setSchool_address(String school_address) {
		this.school_address = school_address;
	}

	@Override
	public String toString() {
		return "School [school_id=" + school_id + ", school_name=" + school_name + ", school_address=" + school_address
				+ "]";
	}

}
