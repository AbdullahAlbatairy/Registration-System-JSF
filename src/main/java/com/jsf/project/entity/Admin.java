package com.jsf.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name = "admin")

public class Admin extends User{
	@Column(name = "privilage_level")
	private int privilageLevel;

	public int getPrivilageLevel() {
		return privilageLevel;
	}

	public void setPrivilageLevel(int privilageLevel) {
		this.privilageLevel = privilageLevel;
	}

	
	
	

}
