package com.spring_dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jdbc_entities.Student;

public class RowMapperImpl implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student=new Student();
		student.setStudent_id(rs.getInt(1));
		student.setStudent_name(rs.getString(2));
		student.setStudent_address(rs.getString(3));
		return student;
	}
	

}
