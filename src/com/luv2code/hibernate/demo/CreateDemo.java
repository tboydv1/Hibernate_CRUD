package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			//create object
			/*Instructor tempInstructor =
					new Instructor("Chad", "Darby", "darby@luv2code.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail("http//www.luv2code.com/youtube", "Luv 2 code!!!");
			
			*/
			//associate objects 
			
			//create object
			Instructor tempInstructor =
					new Instructor("Rock", "Sam", "sam@luv2code.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail("http//www.rocksam.com/youtube", "Guitar!!!");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
		
			
			//start a transaction
			session.beginTransaction();
			
			//persist an instructor
			//Note: This will also save the details object of the instructor
			//because of cascase type.all
			
			System.out.println("Saving Instructor: "+ tempInstructor);
			session.save(tempInstructor);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
		}
		finally {
			factory.close();
		}
		
	}

}
