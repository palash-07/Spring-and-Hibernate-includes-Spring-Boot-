package com.palash.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.palash.hibernate.demo.entity.Instructor;
import com.palash.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		// create the session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create the session
		Session session = factory.getCurrentSession();

		try {
			// create the objects
//			Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@gmail.com");
//
//			InstructorDetail tempInstructorDetail = new InstructorDetail("http://luv2code.com", "Luv 2 Code !!");
			
			Instructor tempInstructor = new Instructor("Example", "Surname", "example@gmail.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("http://example.com", "giving examples");

			
			// associate the objects together
			tempInstructor.setInstructorDetail(tempInstructorDetail);

			// start a transaction
			session.beginTransaction();

			// save the instructor
			// Note: this will also save the instructorDetail object too
			// because of the CascadeType.ALL
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
