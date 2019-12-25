package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			//query students
			System.out.println("Querying students from the database: ");
			List<Student> theStudents = session.createQuery("from Student").list();
			
			//display student
			displayStudents(theStudents);
			
			//quering student with the last name doe
			System.out.println("Querying student with lastname wall");
			theStudents = session.createQuery("from Student s where s.lastName='Wall'").list();
			
			//display student
			System.out.println("\n\nStudents who have last name of Wall");
			displayStudents(theStudents);
			
			
			//query
			System.out.println("Querying student with the lastname of Wall or firstnam of mary");
			theStudents = session.createQuery("from Student s where s.lastName='Wall' OR "
					+ "s.firstName='Mary'").list();
			
			//display student
			System.out.println("\n\nStudents who have last name of Wall or firstName of Mary");
			displayStudents(theStudents);
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Transaction done!!");
			
		}
		finally {
			factory.close();
		}
		
	}

	public static void displayStudents(List<Student> theStudents) {
		
		System.out.println("Displaying the students: ");
		for(Student student: theStudents) {
			System.out.println(student);
		}
	}

}
