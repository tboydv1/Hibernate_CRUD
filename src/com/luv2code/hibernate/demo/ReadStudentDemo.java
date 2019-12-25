package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent = new Student("Micheal", "Todd","micheal@luv2code.com");

			//start a transaction
			session.beginTransaction();
			//save the student objects
			System.out.println("Saving a student object");
			session.save(tempStudent);
			System.out.println(tempStudent);
			//commit transaction
			session.getTransaction().commit();
			
			//Reading student
			
			//find out students id: primary key
			System.out.println("saved student Generated id: "+ tempStudent.getId());
			
			
			//now we get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			//retrieve student based on primary key
			System.out.println("\nGetting student with id: "+ tempStudent.getId());
		
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get operation complete: " + myStudent);
			System.out.println("Transaction done!!");
			
			//commit the transaction
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
		
	}

}
