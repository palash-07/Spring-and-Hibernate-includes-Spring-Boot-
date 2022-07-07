package com.palash.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.palash.hibernate.demo.entity.Course;
import com.palash.hibernate.demo.entity.Instructor;
import com.palash.hibernate.demo.entity.InstructorDetail;
import com.palash.hibernate.demo.entity.Review;
import com.palash.hibernate.demo.entity.Student;

public class DeleteJimStudentDemo {

	public static void main(String[] args) {

		// create the session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// create the session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);

			// delete the student
			System.out.println("Deleting student: " + tempStudent);
			session.delete(tempStudent);
			
			

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			// add clean up code
			session.close();
			factory.close();
		}
	}

}
