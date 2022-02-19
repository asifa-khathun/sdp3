package com.klu.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.*;

import com.sun.istack.NotNull;

@Entity
@Table(name="recruiter")
@DynamicInsert
public class Recruiter 
{
  @Id
  @Column(name="recru_email", columnDefinition = "varchar(250) default 'example@gmail.com'")
  @NotNull
  private String email;
  
  @Column(name="recru_fullname", columnDefinition = "varchar(100) default 'fullname'")
  @NotNull
  private String fullName;
  
  @Column(name="recru_empid", columnDefinition = "varchar(100) default 'EX111'")
  @NotNull
  private String empid;
  
  @Column(name="recru_gender", columnDefinition = "varchar(100) default 'male'")
  @NotNull
  private String gender;
  
  @Column(name="recru_age", columnDefinition = "varchar(50) default '0'")
  @NotNull
  private String age;
  
  @Column(name="recru_mobile", columnDefinition = "varchar(15) default '0000000000'")
  @NotNull
  private String mobile;
  
  @Column(name="recru_company_name", columnDefinition = "varchar(100) default 'comapny name'", unique=true)
  @NotNull
  private String companyName;
  
  @Column(name="recru_company_loc", columnDefinition = "varchar(100) default 'company loc'")
  @NotNull
  private String companyLoc;
  
  @Column(name="recru_password", columnDefinition = "varchar(20) default '12345'")
  @NotNull
  private String password;

  
  @Column(name="recru_status", columnDefinition = "varchar(20) default 'Pending'")
  @NotNull
  private String status;
  
  @Column(name = "recru_proof", columnDefinition = "varchar(100) default 'proof.jpg'")
  @NotNull
  private String proof;
  
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  public String getEmail() 
  {
    return email;
  }
  public void setEmail(String email) 
  {
    this.email = email;
  }
  public String getFullName() 
  {
    return fullName;
  }
  public void setFullName(String fullName) 
  {
    this.fullName = fullName;
  }
  public String getGender() 
  {
    return gender;
  }
  public void setGender(String gender) 
  {
    this.gender = gender;
  }
  public String getAge() 
  {
    return age;
  }
  public void setAge(String age) 
  {
    this.age = age;
  }
  public String getPassword() 
  {
    return password;
  }
  public void setPassword(String password) 
  {
    this.password = password;
  }
  public String getMobile() 
  {
    return mobile;
  }
  public void setMobile(String mobile)
  {
    this.mobile = mobile;
  }
  public String getCompanyName() 
  {
    return companyName;
  }
  public void setCompanyName(String companyName) 
  {
    this.companyName = companyName;
  }
  public String getCompanyLoc()
  {
    return companyLoc;
  }
  public void setCompanyLoc(String companyLoc) 
  {
    this.companyLoc = companyLoc;
  }
  public String getEmpid() 
  {
    return empid;
  }
  public void setEmpid(String empid) 
  {
    this.empid = empid;
  }
public String getProof() {
	return proof;
}
public void setProof(String proof) {
	this.proof = proof;
}
  
  
}