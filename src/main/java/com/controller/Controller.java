package com.controller;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hibernate_bean_config.HibernateConfig;
import com.jdbc_dao.StudentDao;
import com.jdbc_entities.Student;
import com.spring_dao.StudentSpringDao;
import com.utility.ConnectionClass;
import com.utility.Crud_Option_Template;
import com.utility.Utility;

public class Controller {
	public static void main(String[] args) {
		Connection con = ConnectionClass.getConnection();
		StudentDao dao = new StudentDao(con);
		StudentSpringDao spring_dao = new StudentSpringDao();
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/spring_bean_config/connection_bean_spring_config.xml");
		Student student = context.getBean("student", Student.class)
		System.out.println("hii");
		Main: do {
			System.out.println("Use CRUD Operation By JDBC Enter-1\n" + "Use CRUD Operation By SPRING-CORE Enter-2\n"
					+ "Use CRUD Operation By HIBERNATE Enter-3\n" + "Exit Enter-4");
			Scanner sc = new Scanner(System.in);
			int no = sc.nextInt();
			Jdbc: switch (no) {
			case 1:
				do {
					int no1 = Crud_Option_Template.crud_option_template(sc);
					switch (no1) {
					case 1:
						student = Utility.insertStudentTableTemplate(no1);
						dao.insertStudent(student);
						break;
					case 2:
						dao = new StudentDao(con);
						dao.showStudentData();
						break;
					case 3:
						student = Utility.insertStudentTableTemplate(no1);
						dao = new StudentDao(con);
						dao.updateStudent(student.getStudent_id());
						break;
					case 4:
						student = Utility.insertStudentTableTemplate(no1);
						dao = new StudentDao(con);
						dao.deleteStudent(student.getStudent_id());
						break;
					case 5:
						System.out.println("-------JDBC-Programme End----------");
						break Jdbc;
					default:
						System.out.println("!Error!--Pls Enter Valid Entry---");
					}
				} while (true);
			case 2:
				do {
					int no1 = Crud_Option_Template.crud_option_template(sc);
					switch (no1) {
					case 1:
						student = Utility.insertStudentTableTemplateSpring(no1);
						spring_dao.insertStudent(student);
						break;
					case 2:
						student = Utility.insertStudentTableTemplateSpring(no1);
						System.out.println(spring_dao.showStudent(student));
						break;
					case 3:
						student = Utility.insertStudentTableTemplateSpring(no1);
						spring_dao.updateStudent(student);
						break;
					case 4:
						student = Utility.insertStudentTableTemplateSpring(no1);
						spring_dao.deleteStudent(student);
						break;
					case 5:
						List<Student> st = spring_dao.showAllStudent(student.getJdbcTemplate());
						for (Student s : st) {
							System.out.println(s);
						}
						break;
					case 6:
						System.out.println("-------JDBC-Programme End----------");
						break Jdbc;
					default:
						System.out.println("!Error!--Pls Enter Valid Entry---");
					}
				} while (true);
			case 3:
				do {
					int no1 = Crud_Option_Template.crud_option_template(sc);
					switch (no1) {
					case 1:
						//HibernateController.insertStudent(no1);
						HibernateConfig.getHibernate(no1);
						break;
					case 2:
						HibernateController.insertStudent(no1);
						break;
					case 3:
						HibernateController.insertStudent(no1);
						break;
					case 4:
						HibernateController.insertStudent(no1);
						break;
					case 5:
						List<Student> st = spring_dao.showAllStudent(student.getJdbcTemplate());
						for (Student s : st) {
							System.out.println(s);
						}
						break;
					case 6:
						System.out.println("-------JDBC-Programme End----------");
						break Jdbc;
					default:
						System.out.println("!Error!--Pls Enter Valid Entry---");
					}
				} while (true);
			case 4:
				System.out.println("-------MAIN-Programme End----------");
				break Main;

			}

		} while (true);

	}
}
