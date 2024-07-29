package com.spring_bean_config;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.jdbc_entities.School;
import com.jdbc_entities.Student;

@Configuration
@ComponentScan(basePackages = {"com/jdbc_entities"})
public class Java_Connection_Bean_Spring_Config {
	@Bean(name="dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource() ;
		return ds;
	}
	@Bean(name="jdbcTemplate")
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}
	@Bean(name="student")
	public Student getStudent() {
		Student student=new Student(getSchool());
		return student;
	}
	@Bean(name="school")
	public School getSchool() {
		School school=new School();
		return school;
	}

}
