package com.utility;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbc_entities.Student;

public class Utility {
	public static Student insertStudentTableTemplate(int no) {
		Student student = null;
		int id = 0;
		Scanner sc = new Scanner(System.in);
		if (no == 1 || no == 2 || no == 3 || no == 4) {
			System.out.print("Pls Enter Id:-");
			id = sc.nextInt();
			student = new Student(id);
			student.setStudent_id(id);
			sc.nextLine();
			if (no == 2 || no == 4) {
				return student;
			}
		}
		if (no == 1 || no == 3) {
			System.out.print("Pls Enter Name:-");
			String name = sc.nextLine();
			System.out.print("Pls Enter Address:-");
			String address = sc.nextLine();
			student = new Student(id, name, address);
			return student;
		}
		return student;

	}
	public static Student insertStudentTableTemplateSpring(int no) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/utility/connection_bean_spring_config.xml");
		Student student = context.getBean("student", Student.class);
		int id = 0;
		Scanner sc = new Scanner(System.in);
		if (no == 1 || no == 2 || no == 3 || no == 4) {
			System.out.print("Pls Enter Id:-");
			id = sc.nextInt();
			student.setStudent_id(id);
			sc.nextLine();
			if (no == 2 || no == 4) {
				return student;
			}
		}
		if (no == 1 || no == 3) {
			System.out.print("Pls Enter Name:-");
			String name = sc.nextLine();
			System.out.print("Pls Enter Address:-");
			String address = sc.nextLine();
			student.setStudent_id(id);
			student.setStudent_name(name);
			student.setStudent_address(address);
			return student;
		}
		return student;

	}

}
