package com.spring_dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.jdbc_entities.Student;

public class StudentSpringDao {

	public void insertStudent(Student student) {

		String query = "insert into student(student_id,student_name,student_address) values(?,?,?)";
		int r = student.getJdbcTemplate().update(query, student.getStudent_id(), student.getStudent_name(),
				student.getStudent_address());
		if (r > 0)
			System.out.println("Insertion Successfully");
		else
			System.out.println("Insertion fail");
	}

	public Student showStudent(Student student) {

		String query = "select * from student where student_id=?";
		RowMapper<Student> rowMapper=new RowMapperImpl();
		Student student1= student.getJdbcTemplate().queryForObject(query, rowMapper,student.getStudent_id());
		return student1;
	}
	public void updateStudent(Student student) {

		String query = "update student set student_name=?,student_address=? where student_id=?";
		int r = student.getJdbcTemplate().update(query,student.getStudent_name(),
				student.getStudent_address(),student.getStudent_id());
		if (r > 0)
			System.out.println("Update Successfully");
		else
			System.out.println("Update fail");
	}
	public void deleteStudent(Student student) {
		String query = "delete from student where student_id=?";
		int r= student.getJdbcTemplate().update(query,student.getStudent_id());
		if (r > 0)
			System.out.println("Delete Successfully");
		else
			System.out.println("Delete fail");
	}
	public List<Student> showAllStudent(JdbcTemplate jdbcTemplate) {

		String query = "select * from student ";
		RowMapper<Student> rowMapper=new RowMapperImpl();
		List<Student> list= jdbcTemplate.query(query, new RowMapperImpl());
		return list;
	}

}
