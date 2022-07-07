package com.palash.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.palash.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create the session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create the session
		Session session = factory.getCurrentSession();

		try {
			int studentId = 1;

			// now get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the id
			System.out.println("\nGetting student with id: " + studentId);
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("Get student complete: " + myStudent);

			// update the student we retrieved
			System.out.println("Updating student");
			myStudent.setFirstName("Scooby");

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Updating one object Done!");

			// NEW CODE STARTS HERE

			session = factory.getCurrentSession();
			session.beginTransaction();

			// update email for all students
			System.out.println("Update email for all students");
			session.createQuery("update Student set email='foo@gmail.com'")
					.executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}
