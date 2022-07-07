package com.palash.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.palash.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create the session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create the session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save java object
			// create three student object
			System.out.println("creating a new student object...");
			Student tempStudent1 = new Student("John", "Doe", "johnl@gmail.com");
			Student tempStudent2 = new Student("Liz", "Olsen", "olsen@gmail.com");
			Student tempStudent3 = new Student("Scar", "Johnson", "scar@gmail.com");

			
			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
