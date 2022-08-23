package com.jsf.project.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jsf.project.entity.Course;
import com.jsf.project.entity.Instructor;
import com.jsf.project.entity.Student;

public class InstructorDAOImpl {

	static private SessionFactory sessionFactory;

	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public static List<Course> retreiveCourses(int instructorId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		TypedQuery<Instructor> query = session.createQuery("from Instructor where id =:instructorId", Instructor.class);
		query.setParameter("instructorId", instructorId);

		Instructor instructor = query.getSingleResult();

		List<Course> courses = instructor.getCourses();
		session.getTransaction().commit();
		session.close();

		return courses;
	}

	public static Set<Student> retreiveStudents(int courseId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		TypedQuery<Course> query = session.createQuery("from Course where id =:courseId", Course.class);
		query.setParameter("courseId", courseId);

		Course course = query.getSingleResult();

		Set<Student> studnets = course.getStudents();

		session.getTransaction().commit();
		session.close();

		return studnets;

	}

}
