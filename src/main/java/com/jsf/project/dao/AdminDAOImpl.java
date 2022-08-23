package com.jsf.project.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jsf.project.entity.Course;
import com.jsf.project.entity.Instructor;
import com.jsf.project.entity.Student;

public class AdminDAOImpl implements AdminDAO {

	static private SessionFactory sessionFactory;

	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public static List<Course> retreiveCourses() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		TypedQuery<Course> query = session.createQuery("from Course", Course.class);
		session.getTransaction().commit();
		List<Course> courses = query.getResultList();
		session.close();
		return courses;

	}

	public static List<Instructor> retreiveInstructors() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		TypedQuery<Instructor> query = session.createQuery("from Instructor", Instructor.class);
		session.getTransaction().commit();
		List<Instructor> instructors = query.getResultList();
		session.close();
		return instructors;

	}

	public static List<Student> retreiveStudents() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		TypedQuery<Student> query = session.createQuery("from Student", Student.class);
		session.getTransaction().commit();
		List<Student> student = query.getResultList();
		session.close();
		return student;

	}

	public static void saveCourse(Course course) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(course);
		session.getTransaction().commit();
		session.close();

	}

	public static void saveInstructor(Instructor instructor) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(instructor);
		session.getTransaction().commit();
		session.close();

	}

	public static void saveStudent(Student student) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(student);
		session.getTransaction().commit();
		session.close();

	}

	public static void deleteCourse(Course course) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(course);
		session.getTransaction().commit();
		session.close();

	}

	public static void deleteInstructor(Instructor instructor) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(instructor);
		session.getTransaction().commit();
		session.close();

	}

	public static void deleteStudent(Student student) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(student);
		session.getTransaction().commit();
		session.close();

	}

//	public static List<Instructor> retreiveInstructors(int courseId) {
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		
//		
//		
//		Query<Course> query = session.createQuery("from Course where id =:courseId");
//		query.setParameter("courseId", courseId);
//		Course course = query.getSingleResult();
//		
//		
//		
//		Query<Instructor> query2 = session.createQuery("from Instructor");
//		List<Instructor> instructors = query2.getResultList();
//		
//		instructors.removeAll(course.getInstrcutors());
//		
//		session.getTransaction().commit();
//		session.close();
//		
//		
//		return instructors;
//
//	}

//	public List<Instructor> retreiveInstructorForAssigning() {
//		Session session = sessionFactory.openSession();
//		Query query1 = session.getNamedQuery("viewInstructors");
//		List<Instructor> instructors = query1.list();
//		return instructors;
//
//	}
//
//	public List<Course> retreiveCoursesForInstructorToView() {
//		Session session = sessionFactory.openSession();
//		Query query1 = session.getNamedQuery("viewMyCourses");
//		List<Course> courses = query1.list();
//		return courses;
//
//	}
//
//	public Student retreiveStudentObj() {
//		Session session = sessionFactory.openSession();
//		Query query1 = session.getNamedQuery("studentObj");
//		Student student = (Student) query1.uniqueResult();
//		return student;
//
//	}
//
//	public User retreiveUserObj(String userName, String userPassword) {
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
////		System.out.println(userPassword);
////		System.out.println(userName);
//
//		Query<User> query1 = session.getNamedQuery("userLogin");
//		query1.setParameter("P_USERNAME", userName);
//		query1.setParameter("P_PASSWORD", userPassword);
//		List<User> list = query1.list();
//
//		System.out.println(list.size());
//
//		User user = query1.uniqueResult();
//		session.getTransaction().commit();
//		session.close();
//		System.out.println(user.getUserName());
//		System.out.println(user.getUserId());
//		return user;
//
//	}

}
