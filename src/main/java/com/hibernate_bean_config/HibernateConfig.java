package com.hibernate_bean_config;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jdbc_entities.Student;
import com.utility.Utility;

public class HibernateConfig {
	public static void getHibernate(int no) {
	 Properties prop = new Properties();
     prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/AllCrud");
     prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
     prop.setProperty("hibernate.connection.username","root");
     prop.setProperty("hibernate.connection.password","mysql@1984");
     prop.setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
     prop.setProperty("hibernate.show_sql","true");
     prop.setProperty("hibernate.current_session_context_class","thread");

     SessionFactory sessionFactory = new Configuration().addProperties(prop).addAnnotatedClass(Student.class).buildSessionFactory();
     Session session = sessionFactory.getCurrentSession();
     Transaction tx= session.beginTransaction();
     try{
       Student student=Utility.insertStudentTableTemplate(no);
       session.save(student);
     }finally {
    	 tx.commit();
         session.close();
         sessionFactory.close();
     }
}
}
