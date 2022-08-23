package com.jsf.project.bean.admin;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import com.jsf.project.Interface.Navigation;
import com.jsf.project.entity.Course;
import com.jsf.project.service.AdminServiceImpl;

@ManagedBean(name = "home")
@SessionScoped
public class homeBean implements Navigation {
	private List<Course> courses;
	private Course selectedCourse;

	public List<Course> getCourses() {
		courses = AdminServiceImpl.retreiveCourses();
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Course getSelectedCourse() {
		return selectedCourse;
	}

	public void setSelectedCourse(Course selectedCourse) {
		this.selectedCourse = selectedCourse;
	}

	public void saveCourse() {

		if (this.selectedCourse.getId() == 0) {
			AdminServiceImpl.saveCourse(this.selectedCourse);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Course Added"));

		} else {
			AdminServiceImpl.saveCourse(this.selectedCourse);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Course Updated"));

		}

		PrimeFaces.current().executeScript("PF('manageCourseDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:dt-courses");
	}

	public void deleteCourse() {
		System.out.println(selectedCourse);

		AdminServiceImpl.deleteCourse(this.selectedCourse);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Course Deleted"));

		PrimeFaces.current().ajax().update("form:messages", "form:dt-courses");
	}

	public void openNew() {
		this.selectedCourse = new Course();
	}

	@Override
	public String getToCourses() {
		return "admin-course-course";

	}

	@Override
	public String getToStudents() {
		return "admin-course-student";

	}

	@Override
	public String getToInstructors() {
		return "admin-course-instructor";

	}

}
