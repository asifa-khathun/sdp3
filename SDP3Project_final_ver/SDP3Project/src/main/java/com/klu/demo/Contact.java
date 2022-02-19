package com.klu.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import com.sun.istack.NotNull;

@Entity
@Table(name="contactus")
public class Contact 
{
	@Id
	@Column(name="id", columnDefinition="int auto_increment", nullable=false)
    private int id;

	@Column(name="name", columnDefinition = "varchar(100) default 'name'", nullable=false)
	private String name;
	
	@Column(name="email", columnDefinition = "varchar(100) default 'email'", nullable=false)
	private String email;
	
	@Column(name="state", columnDefinition = "varchar(100) default 'state'", nullable=false)
	private String state;
	
	@Column(name="message", columnDefinition = "varchar(500) default 'message'", nullable=false)
	private String message;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
