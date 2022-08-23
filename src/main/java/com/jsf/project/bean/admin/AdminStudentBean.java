package com.jsf.project.bean.admin;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import com.jsf.project.Interface.Navigation;
import com.jsf.project.entity.Student;
import com.jsf.project.service.AdminServiceImpl;

@ManagedBean(name = "adminStudent")
@SessionScoped
public class AdminStudentBean implements Navigation {

	private List<Student> students;
	private Student selectedStudent;
	
	

	public List<Student> getStudents() {
		students = AdminServiceImpl.retreiveStudents();

		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Student getSelectedStudent() {
		return selectedStudent;
	}

	public void setSelectedStudent(Student selectedStudent) {
		this.selectedStudent = selectedStudent;
	}

	public void saveStudent() {

		if (this.selectedStudent.getId() == 0) {
			AdminServiceImpl.saveStudent(this.selectedStudent);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Student Added"));

		} else {
			AdminServiceImpl.saveStudent(this.selectedStudent);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Student Updated"));

		}

		PrimeFaces.current().executeScript("PF('manageStudentDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:dt-students");
	}

	public void deleteStudent() {
		System.out.println(selectedStudent);

		AdminServiceImpl.deleteStudent(this.selectedStudent);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Student Deleted"));

		PrimeFaces.current().ajax().update("form:messages", "form:dt-students");
	}

	public void openNew() {
		this.selectedStudent = new Student();
	}

	
	

	@Override
	public String getToCourses() {
		return "admin-student-course";
	}

	@Override
	public String getToStudents() {
		return "admin-student-student";

	}

	@Override
	public String getToInstructors() {
		return "admin-student-instructor";
	}

}
