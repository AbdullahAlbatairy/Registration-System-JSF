package com.jsf.project.bean.admin;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import com.jsf.project.Interface.Navigation;
import com.jsf.project.entity.Instructor;
import com.jsf.project.service.AdminServiceImpl;

@ManagedBean(name = "adminInstructor")
@SessionScoped
public class AdminInstructorBean implements Navigation {

	private List<Instructor> instructors;
	private Instructor selectedInstructor;

	public List<Instructor> getInstructors() {
		instructors = AdminServiceImpl.retreiveInstructors();
		return instructors;
	}

	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
	}

	public Instructor getSelectedInstructor() {
		return selectedInstructor;
	}

	public void setSelectedInstructor(Instructor selectedInstructor) {
		this.selectedInstructor = selectedInstructor;
	}

	public void saveInstructor() {

		if (this.selectedInstructor.getId() == 0) {
			AdminServiceImpl.saveInstructor(this.selectedInstructor);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Instructor Added"));

		} else {
			AdminServiceImpl.saveInstructor(this.selectedInstructor);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Instructor Updated"));

		}

		PrimeFaces.current().executeScript("PF('manageInstructorDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:dt-instructors");
	}

	public void deleteInstructor() {

		AdminServiceImpl.deleteInstructor(this.selectedInstructor);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Instructor Deleted"));

		PrimeFaces.current().ajax().update("form:messages", "form:dt-instructors");
	}

	public void openNew() {
		this.selectedInstructor = new Instructor();
	}

	@Override
	public String getToCourses() {
		return "admin-instructor-course";
	}

	@Override
	public String getToStudents() {
		return "admin-instructor-student";

	}

	@Override
	public String getToInstructors() {
		return "admin-instructor-instructor";
	}

}
