package com.jsf.project.service;

import java.util.List;

import com.jsf.project.dao.AdminDAOImpl;
import com.jsf.project.entity.Course;
import com.jsf.project.entity.Instructor;
import com.jsf.project.entity.Student;

public class AdminServiceImpl implements AdminService {

	
	public static List<Course> retreiveCourses() {
		return AdminDAOImpl.retreiveCourses();
	}

	
	public static List<Student> retreiveStudents() {
		return AdminDAOImpl.retreiveStudents();

	}

	
	public static List<Instructor> retreiveInstructors() {
		return AdminDAOImpl.retreiveInstructors();

	}

	
	public static void saveCourse(Course course) {
		AdminDAOImpl.saveCourse(course);
	}

	
	public static void saveStudent(Student student) {
		AdminDAOImpl.saveStudent(student);
	}

	
	public static void saveInstructor(Instructor instructor) {
		AdminDAOImpl.saveInstructor(instructor);
	}

	
	public static void deleteCourse(Course course) {
		AdminDAOImpl.deleteCourse(course);
	}

	
	public static void deleteStudent(Student student) {
		AdminDAOImpl.deleteStudent(student);
	}

	
	public static void deleteInstructor(Instructor instructor) {
		AdminDAOImpl.deleteInstructor(instructor);
	}

}
