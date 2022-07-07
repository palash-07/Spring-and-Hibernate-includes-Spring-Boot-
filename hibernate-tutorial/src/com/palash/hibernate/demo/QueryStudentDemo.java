package com.palash.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.palash.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create the session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create the session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// query students
			List<Student> theStudents = session.createQuery("from Student").list();

			// display students
			displayStudents(theStudents);

			// query students: lastName = doe
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").list();

			// display the students
			System.out.println("Students who have the last name as Doe: ");
			displayStudents(theStudents);

			// query students: lastname is Doe or firstname is Daffy
			theStudents = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Daffy'").list();

			// display the students
			System.out.println("Students with last name Doe or first name Daffy");
			displayStudents(theStudents);

			// query students: email LIKE "%gmail.com"
			theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").list();

			// display the students
			System.out.println("Students whose email ends with gmail.com");
			displayStudents(theStudents);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
