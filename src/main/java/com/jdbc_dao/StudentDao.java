package com.jdbc_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc_entities.Student;
import com.utility.Utility;


public class StudentDao {
	Connection con;

	public StudentDao(Connection con) {
		super();
		this.con = con;
	}

	public void insertStudent(Student student) {
		String query = "insert into student(student_id,student_name,student_address) values(?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, student.getStudent_id());
			ps.setString(2, student.getStudent_name());
			ps.setString(3, student.getStudent_address());
			int r = ps.executeUpdate();
			if (r > 0)
				System.out.println("Insertion Successfully");
			else
				System.out.println("Insertion fail");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void showStudentData() {
		String query="select * from student";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("Id:- "+rs.getInt("student_id")+", Name:- "+rs.getString("student_name")+", Address:- "+rs.getString("student_address"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void updateStudent(int id) {
		String query = "update student set student_name=?,student_address=? where student_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			Student student=Utility.insertStudentTableTemplate(id);
			ps.setString(1, student.getStudent_name());
			ps.setString(2, student.getStudent_address());
			ps.setInt(3, id);
			int r = ps.executeUpdate();
			if (r > 0)
				System.out.println("update Successfully");
			else
				System.out.println("update fail");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteStudent(int id) {
		String query="delete from student where student_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			int r = ps.executeUpdate();
			if (r > 0)
				System.out.println("Delete Successfully");
			else
				System.out.println("Delete fail");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
