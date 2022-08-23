package com.jsf.project.bean.instructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.jsf.project.Interface.Navigation;
import com.jsf.project.dao.InstructorDAOImpl;
import com.jsf.project.entity.Course;
import com.jsf.project.entity.Instructor;
import com.jsf.project.entity.Student;
import com.jsf.project.service.InstructorServiceImpl;

@ManagedBean(name = "instructorHome")
@SessionScoped
public class InstructorhomeBean implements Navigation {
	private List<Course> courses;
	private Course selectedCourse;
	private Set<Student> students;
	private Instructor instructor;

	public List<Course> getCourses() {
		courses = InstructorServiceImpl.retreiveCourses(41);
		return courses;
	}

	public Set<Student> getStudents() {
		students = new HashSet<>();
		return students;
	}

	public void setStudents(Set<Student> studnets) {
		students = InstructorDAOImpl.retreiveStudents(selectedCourse.getId());
		this.students = studnets;
	}

	public Course getSelectedCourse() {
		return selectedCourse;
	}

	public void setSelectedCourse(Course selectedCourse) {
		this.selectedCourse = selectedCourse;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String getToCourses() {
		return "instructor-course-course";
	}

	@Override
	public String getToStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getToInstructors() {
		// TODO Auto-generated method stub
		return null;
	}

}
