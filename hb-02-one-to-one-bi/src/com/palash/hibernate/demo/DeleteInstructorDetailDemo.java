package com.palash.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.palash.hibernate.demo.entity.Instructor;
import com.palash.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// create the session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create the session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// get the instructor Detail object
			int theId = 3;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

			// print the Instructor Detail
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);

			// print the associated instructor
			System.out.println("the associated Instructor: " + tempInstructorDetail.getInstructor());

			// now lets delete the instructor detail (delete instructor detail only)
			// break the bidirectional link
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			System.out.println("Deleting tempInstructorDetail: " + tempInstructorDetail);
			session.delete(tempInstructorDetail);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			// handle the connection leak issue
			session.close();

			factory.close();
		}
	}

}
