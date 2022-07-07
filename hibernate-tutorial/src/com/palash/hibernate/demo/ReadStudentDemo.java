package com.palash.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.palash.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create the session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create the session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save java object
			// create a student object
			System.out.println("creating a new student object...");
			Student tempStudent = new Student("Daffy", "Duck", "duck@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student...");
			System.out.println(tempStudent);
			session.save(tempStudent);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Created object successfully!");

			// NEW CODE STARTS HERE

			// find out the student's id: primary key
			System.out.println("Saved student. generated id: " + tempStudent.getId());

			// now get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the id
			System.out.println("\nGetting student with id: " + tempStudent.getId());

			Student myStudent = session.get(Student.class, tempStudent.getId());

			System.out.println("Get student complete: " + myStudent);

			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Reading objects Done!");
		} finally {
			factory.close();
		}
	}

}
