package com.palash.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.palash.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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

//			// delete the Student
//			System.out.println("Deleting the student: " + myStudent);
//			session.delete(myStudent);
			
			// delete the Student id = 2 (alternative approach)
			System.out.println("Delete the student id = 2");
			session.createQuery("delete from Student where id=2").executeUpdate();

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Delete object Done!");

		} finally {
			factory.close();
		}
	}

}
