package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		
		//create a session factory
		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			//create student objects
			System.out.println("creating a new student object");
			
			Student tmpStudent1 = new Student("Cherish", "Wall", "cherish@luv2code.com");
			Student tmpStudent2 = new Student("Mary", "Victor", "mary@luv2code.com");
			Student tmpStudent3 = new Student("Bonita", "Johnson", "bonita@luv2code.com");
			
			
			//start a transaction
			session.beginTransaction();
			//save a student
			System.out.println("saving the students...");
			session.save(tmpStudent1);
			session.save(tmpStudent2);
			session.save(tmpStudent3);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
			
		}
		finally {
			factory.close();
		}
		
	}

}
