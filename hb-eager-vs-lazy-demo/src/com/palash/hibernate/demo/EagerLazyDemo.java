package com.palash.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.palash.hibernate.demo.entity.Course;
import com.palash.hibernate.demo.entity.Instructor;
import com.palash.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create the session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create the session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("EagerLazyDemo: Instructor: " + tempInstructor);
			
			// get course for the instructor
			System.out.println("EagerLazyDemo: Courses: " + tempInstructor.getCourses());

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("EagerLazyDemo: Done!");

		} finally {
			// add clean up code
			session.close();
			factory.close();
		}
	}

}
