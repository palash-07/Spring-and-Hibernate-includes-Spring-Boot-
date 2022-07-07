package com.palash.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.palash.hibernate.demo.entity.Course;
import com.palash.hibernate.demo.entity.Instructor;
import com.palash.hibernate.demo.entity.InstructorDetail;
import com.palash.hibernate.demo.entity.Review;
import com.palash.hibernate.demo.entity.Student;

public class CreateCoursesForJimDemo {

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

			// get the student jim from database
			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);
			System.out.println("Loaded Student: " + tempStudent);
			System.out.println("Courses: " + tempStudent.getCourses());

			// create more courses
			Course tempCourse1 = new Course("Rubik's cube - how to speed cube");
			Course tempCourse2 = new Course("Game devlopment");

			// add student to courses
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);

			// save the courses
			System.out.println("Saving the courses");

			session.save(tempCourse1);
			session.save(tempCourse2);

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
