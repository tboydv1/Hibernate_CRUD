package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			//create 3 student objects
			System.out.println("Creating 3 student object");
			Student tempStudent = new Student("Paul", "Wall","paul@luv2code.com");

			//start a transaction
			session.beginTransaction();
			//save the student objects
			System.out.println("Saving a student object");
			session.save(tempStudent);
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Transaction done!!");
			
		}
		finally {
			factory.close();
		}
		
	}

}
