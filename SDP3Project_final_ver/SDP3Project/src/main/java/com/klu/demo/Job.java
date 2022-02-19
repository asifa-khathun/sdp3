package com.klu.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="job")
public class Job 
{
	@Id
	@Column(name="job_id", columnDefinition = "int auto_increment")
	private int id;
	
	@Column(name="job_role", columnDefinition = "varchar(50) default 'job role'")
	@NotNull
	private String role;
	
	@Column(name="job_companyname", columnDefinition = "varchar(100) default 'companyname'")
	@NotNull
	private String companyname;
	
	@Column(name="job_location", columnDefinition = "varchar(100) default 'location'")
	@NotNull
	private String location;
	
	@Column(name="job_type", columnDefinition = "varchar(250) default 'job type'")
	@NotNull
	private String type;
	
	@Column(name="job_deadline", columnDefinition = "varchar(100) default 'Jan 01,2022'")
	@NotNull
	private String deadline;
	
	@Column(name="job_descr", columnDefinition = "varchar(255) default 'description'")
	@NotNull
	private String descr;
	
	@Column(name="job_cgpa", columnDefinition = "varchar(250) default 'Required CGPA'")
	@NotNull
	private String cgpa;
	
	@Column(name="job_branch", columnDefinition = "varchar(250) default 'Applicable Branches'")
	@NotNull
	private String branch;
	
	@Column(name="job_backlog", columnDefinition = "varchar(250) default 'Max Backlogs allowed'")
	@NotNull
	private String backlog;
	
	@Column(name="job_refid", columnDefinition = "varchar(10) default 'PADWAY101' unique")
	@NotNull
	private String refid;
	
	@Column(name="job_recname", columnDefinition = "varchar(50) default 'recruiter'")
	@NotNull
	private String recname;
	
	@Column(name = "job_image", columnDefinition = "varchar(100) default 'demo.jpg'")
    @NotNull
    private String image;
  
    @Column(name = "job_applicants", columnDefinition = "int default 0", nullable=false)
    @NotNull
    private int applicants;
  
    @Column(name = "job_aptround", columnDefinition = "int default 0", nullable=false)
    @NotNull
    private int aptround;
  
    @Column(name = "job_hrtrround", columnDefinition = "int default 0", nullable=false)
    @NotNull
    private int hrtrround;
  
    @Column(name = "job_interview", columnDefinition = "int default 0", nullable=false)
    @NotNull
    private int interview;
  
    @Column(name = "job_selected", columnDefinition = "int default 0", nullable=false)
    @NotNull
    private int selected;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getCgpa() {
		return cgpa;
	}

	public void setCgpa(String cgpa) {
		this.cgpa = cgpa;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getBacklog() {
		return backlog;
	}

	public void setBacklog(String backlog) {
		this.backlog = backlog;
	}

	public String getRefid() {
		return refid;
	}

	public void setRefid(String refid) {
		this.refid = refid;
	}

	public String getRecname() {
		return recname;
	}

	public void setRecname(String recname) {
		this.recname = recname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getApplicants() {
		return applicants;
	}

	public void setApplicants(int applicants) {
		this.applicants = applicants;
	}

	public int getAptround() {
		return aptround;
	}

	public void setAptround(int aptround) {
		this.aptround = aptround;
	}

	public int getHrtrround() {
		return hrtrround;
	}

	public void setHrtrround(int hrtrround) {
		this.hrtrround = hrtrround;
	}

	public int getInterview() {
		return interview;
	}

	public void setInterview(int interview) {
		this.interview = interview;
	}

	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		this.selected = selected;
	}

    
}
