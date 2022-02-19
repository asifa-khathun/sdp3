package com.klu.demo;

import javax.persistence.*;

import com.sun.istack.NotNull;

@Entity
@Table(name="superadmin")
public class Superadmin 
{
	@Id
	@Column(name="email", columnDefinition = "varchar(250) default 'example@gmail.com'")
	@NotNull
	private String email;
	@Column(name="password", columnDefinition = "varchar(20) default '12345'", unique=true)
	@NotNull
	private String password;
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String toString() 
	{
        return "LoginForm(Email Id: " + this.email + ", Password: " + this.password + ")";
    }
}
