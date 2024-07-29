package com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jdbc_entities.Student;
import com.utility.Utility;

public class HibernateController {
	public static void  insertStudent(int no) {
		Configuration cfg=new Configuration().configure("com/hibernate_bean_config/hibarnate_config.xml");
		SessionFactory factory= cfg.buildSessionFactory();
		Session s= factory.openSession();
		Transaction tx= s.beginTransaction();
		if(no==1) {
			Student student=Utility.insertStudentTableTemplate(no);
			s.save(student);
		}
		if(no==2) {
			Student student=Utility.insertStudentTableTemplate(no);
			Student stu=s.get(Student.class, student.getStudent_id());
			System.out.println(stu);
		}
		if(no==3) {
			Student student=Utility.insertStudentTableTemplate(no);
			s.update(student);
		}
		if(no==4) {
			Student student=Utility.insertStudentTableTemplate(no);
			s.delete(student);
		}
		tx.commit();
		s.close();
		factory.close();
	}

}
