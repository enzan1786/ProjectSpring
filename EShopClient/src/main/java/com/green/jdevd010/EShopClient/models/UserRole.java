package com.green.jdevd010.EShopClient.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="manage_roles")
public class UserRole {
	@Id
	@Column(name ="User_ID")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer User_ID;
	

	@Column(name ="Role_ID")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer Role_ID;

	public Integer getUser_id() {
		return User_ID;
	}

	public void setUser_id(Integer user_id) {
		User_ID = user_id;
	}

	public Integer getRole_ID() {
		return Role_ID;
	}

	public void setRole_ID(Integer role_ID) {
		Role_ID = role_ID;
	}
	
	
}
