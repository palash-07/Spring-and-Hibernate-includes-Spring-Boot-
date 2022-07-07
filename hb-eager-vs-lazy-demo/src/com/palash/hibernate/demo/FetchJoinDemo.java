package com.palash.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.palash.hibernate.demo.entity.Course;
import com.palash.hibernate.demo.entity.Instructor;
import com.palash.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			
			// option 2: hibernate query with hql
			Query<Instructor> query = session.createQuery("select i from Instructor i " + 
														  "JOIN FETCH i.courses " +
														  "where i.id=:theInstructorId",
															Instructor.class);
			query.setParameter("theInstructorId", theId);
			
			// execute query and get the instructor
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("Demo: Instructor: " + tempInstructor);

			// commit the transaction
			session.getTransaction().commit();
			
			// close the session 
			session.close();
			
			System.out.println("Demo: Instructor Courses: " + tempInstructor.getCourses());

			System.out.println("Demo: Done!");

		} finally {
			// add clean up code
			session.close();
			factory.close();
		}
	}

}
