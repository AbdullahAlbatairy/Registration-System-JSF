package com.jsf.project.service;

import java.util.List;

import com.jsf.project.dao.InstructorDAOImpl;
import com.jsf.project.entity.Course;
import com.jsf.project.entity.Student;

public class InstructorServiceImpl {

	public static List<Course> retreiveCourses(int instructorId) {
		return InstructorDAOImpl.retreiveCourses(instructorId);
	}

	public static List<Student> retreiveStudents(int courseId) {
		return InstructorServiceImpl.retreiveStudents(courseId);
	}

}
