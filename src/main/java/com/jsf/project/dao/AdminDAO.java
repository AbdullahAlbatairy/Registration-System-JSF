package com.jsf.project.dao;

import java.util.List;

import com.jsf.project.entity.Course;
import com.jsf.project.entity.Instructor;
import com.jsf.project.entity.Student;

public interface AdminDAO {
	
	public static List<Course> retreiveCourses() {
		return null;
	}

	public static List<Student> retreiveStudents() {
		return null;
	}

	public static List<Instructor> retreiveInstructors() {
		return null;
	}

	public static void saveCourse(Course course) {
	}

	public static void saveStudent(Student student) {
	}

	public static void saveInstructor(Instructor instructor) {
	}

	public static void deleteCourse(Course course) {
	}

	public static void deleteStudent(Student student) {
	}

	public static void deleteInstructor(Instructor instructor) {
	}

}
