package com.klu.demo;

import javax.persistence.*;
import com.sun.istack.NotNull;

@Entity
@Table(name="jobseeker")
public class JobSeeker 
{
	@Id
	@Column(name="js_email", columnDefinition = "varchar(250) default 'example@gmail.com'")
	@NotNull
	String email;
	
	@Column(name="js_full_name", columnDefinition = "varchar(100) default 'sample'")
	@NotNull
	String fullName;
	
	@Column(name="js_gender", columnDefinition = "varchar(50) default 'male'")
	@NotNull
	String gender;
	
	@Column(name="js_age", columnDefinition = "varchar(50) default '0'")
	@NotNull
	String age;
	
	@Column(name="js_work_status", columnDefinition = "varchar(50) default 'No'")
	@NotNull
	String workStatus;
	
	@Column(name="js_company_name", columnDefinition = "varchar(100) default 'company'")
	@NotNull
	String companyName;
	
	@Column(name="js_uniname", columnDefinition = "varchar(100) default 'university name'")
	@NotNull
	String uniname;
	
	@Column(name="js_branch", columnDefinition = "varchar(100) default 'branch'")
	@NotNull
	String branch;
	
	@Column(name="js_experience", columnDefinition = "varchar(50) default '0'")
	@NotNull
	String exp;
	
	@Column(name="js_address", columnDefinition = "varchar(100) default 'address'")
	@NotNull
	String address;
	
	@Column(name="js_mobile", columnDefinition = "varchar(15) default '0000000000'")
	@NotNull
	String mobile;
	
	@Column(name="js_password", columnDefinition = "varchar(20) default '12345'", unique=true)
	@NotNull
	String password;
	
	@Column(name="js_tenth_pass_yr", columnDefinition = "varchar(15) default '2000'")
	String tenthpassyr;
	
	@Column(name="js_tenth_pass_per", columnDefinition = "varchar(15) default '70%'")
	String tenthpassper;
	
	@Column(name="js_twelfth_pass_yr", columnDefinition = "varchar(15) default '2000'")
	String twelfthpassyr;
	
	@Column(name="js_twelfth_pass_per", columnDefinition = "varchar(15) default '70%'")
	String twelfthpassper;
	
	@Column(name="js_grad_pass_yr", columnDefinition = "varchar(15) default '70%'")
	String gradpassyr;
	
	@Column(name="js_grad_pass_per", columnDefinition = "varchar(15) default '2000'")
	String gradpassper;
	
	@Column(name="js_backlogs", columnDefinition = "varchar(10) default '0'")
	String backlogs;
	
	@Column(name="js_dob", columnDefinition = "varchar(15) default 'dd/mm/yyy'")
	String dob;
	
	@Column(name="js_skills", columnDefinition = "varchar(200) default 'skills'")
	String skills;
	
	@Column(name="js_projects", columnDefinition = "varchar(200) default 'projects'")
	String projects;
	
	@Column(name="js_glob_certi", columnDefinition = "varchar(200) default 'global certifications'")
	String glob_certi;
	
	@Column(name="js_moocs", columnDefinition = "varchar(200) default 'moocs'")
	String moocs;
	
	@Column(name="js_extn_activities", columnDefinition = "varchar(200) default 'extension activities'")
	String extn_activities;
	
	@Column(name="js_git_link", columnDefinition = "varchar(100) default 'github.com/username'")
	String gitlink;
	
	@Column(name="js_linkedin", columnDefinition = "varchar(100) default 'linkedin.com/username'")
	String linkedin;
	
	@Column(name="js_reference", columnDefinition = "varchar(150) default 'reference'")
	String reference;
	

	@Column(name="js_prevsalary", columnDefinition = "varchar(10) default '0'")
	String prevsalary;
  
	@Column(name="js_access", columnDefinition = "varchar(20) default 'Unblocked'")
	String access;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getUniname() {
		return uniname;
	}

	public void setUniname(String uniname) {
		this.uniname = uniname;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTenthpassyr() {
		return tenthpassyr;
	}

	public void setTenthpassyr(String tenthpassyr) {
		this.tenthpassyr = tenthpassyr;
	}

	public String getTenthpassper() {
		return tenthpassper;
	}

	public void setTenthpassper(String tenthpassper) {
		this.tenthpassper = tenthpassper;
	}

	public String getTwelfthpassyr() {
		return twelfthpassyr;
	}

	public void setTwelfthpassyr(String twelfthpassyr) {
		this.twelfthpassyr = twelfthpassyr;
	}

	public String getTwelfthpassper() {
		return twelfthpassper;
	}

	public void setTwelfthpassper(String twelfthpassper) {
		this.twelfthpassper = twelfthpassper;
	}

	public String getGradpassyr() {
		return gradpassyr;
	}

	public void setGradpassyr(String gradpassyr) {
		this.gradpassyr = gradpassyr;
	}

	public String getGradpassper() {
		return gradpassper;
	}

	public void setGradpassper(String gradpassper) {
		this.gradpassper = gradpassper;
	}

	public String getBacklogs() {
		return backlogs;
	}

	public void setBacklogs(String backlogs) {
		this.backlogs = backlogs;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getProjects() {
		return projects;
	}

	public void setProjects(String projects) {
		this.projects = projects;
	}

	public String getGlob_certi() {
		return glob_certi;
	}

	public void setGlob_certi(String glob_certi) {
		this.glob_certi = glob_certi;
	}

	public String getMoocs() {
		return moocs;
	}

	public void setMoocs(String moocs) {
		this.moocs = moocs;
	}

	public String getExtn_activities() {
		return extn_activities;
	}

	public void setExtn_activities(String extn_activities) {
		this.extn_activities = extn_activities;
	}

	public String getGitlink() {
		return gitlink;
	}

	public void setGitlink(String gitlink) {
		this.gitlink = gitlink;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getPrevsalary() {
		return prevsalary;
	}

	public void setPrevsalary(String prevsalary) {
		this.prevsalary = prevsalary;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	
	
}
