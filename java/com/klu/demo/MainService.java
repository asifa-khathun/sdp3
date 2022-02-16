package com.klu.demo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService 
{
	@Autowired
	JobSeekerRepository jobseekerrepository;
	@Autowired
	JobRepository jobrepository;
	@Autowired
	JobApplicantsRepository japrepository;
	@Autowired
	SuperadminRepository superadminrepos;
	@Autowired
	RecruiterRepository recrurepository;
	@Autowired
	ContactRepository contactrepository;
	
	public int getjobseekerCredentials(String email, String password, String access)
	  {
	    int val = 0;
	    String unblock = "Unblocked";
	    String block = "Blocked";
	    if(access.equalsIgnoreCase(unblock))
	    {
	      Configuration cfg = new Configuration();
	      cfg.configure("hibernate.cfg.xml");
	      SessionFactory sf = cfg.buildSessionFactory();
	      Session session = sf.openSession();
	      Query qry = session.createQuery("from JobSeeker js where js.email=?1 and js.password=?2 and js.access=?3");
	      qry.setString(1, email);
	      qry.setString(2, password);
	      qry.setString(3, access);
	      List<Recruiter> list1 = qry.list();
	      int len = list1.size();
	      Transaction txt = session.beginTransaction();
	      txt.commit();
	      session.close();
	        sf.close();
	      if(len!=0)
	      {
	        return val;
	      }
	      else
	      {
	        val=1;
	      }
	    }
	    if(access.equalsIgnoreCase(block))
	    {
	      val=2;
	    }
	    return val;
	  }
	
	public void submitjobseekerupdate(JobSeeker js)
	{
		jobseekerrepository.save(js);
	}
	
	public int jobseekerregistration(JobSeeker jobseeker,String email)
	  {
	    int flag=0;
	    Configuration cfg=new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf=cfg.buildSessionFactory();
	    Session session=sf.openSession();
	    Query qry1=session.createQuery("from JobSeeker where email=:v2");
	    qry1.setParameter("v2",email);
	    List<JobSeeker> list1=qry1.list();
	    System.out.println(list1.size());
	    if(list1.size()>=1)
	    {
	      System.out.println("Yes");
	      flag=1;
	    }
	    if(flag==0)
	    {
	    	jobseeker.setAccess("Unblocked");
	      jobseekerrepository.save(jobseeker);
	    }
	    Transaction txt=session.beginTransaction();
	    txt.commit();
	    session.close();
	    sf.close();
	    return flag;
	  }
	
	
	public List<JobSeeker> jobseekerprofilesubmit(JobSeeker jobseeker,String email)
	  {
	    int flag=0;
	    Configuration cfg=new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf=cfg.buildSessionFactory();
	    Session session=sf.openSession();
	    
	    Query qry = session.createQuery("select access from JobSeeker js where js.email=?1");
		String access = null;
		qry.setString(1, email);
		List list = qry.list();
		for(int i=0;i<list.size();i++)
		{
			access=(String) list.get(i);
		}
		
		Query qry1 = session.createQuery("select prevsalary from JobSeeker js where js.email=?1");
		String prevsalary = null;
		qry1.setString(1, email);
		List list1 = qry1.list();
		for(int i=0;i<list1.size();i++)
		{
			prevsalary=(String) list1.get(i);
		}
	    
		jobseeker.setAccess(access);
		jobseeker.setPrevsalary(prevsalary);
	    jobseekerrepository.save(jobseeker);
	    
	    Query qry3=session.createQuery("from JobSeeker js where js.email=?1");
		qry3.setString(1,email);
		List<JobSeeker> list3=qry3.list();
		return list3;
	    
	  }
	
	public boolean submitjobseekerchangepwdbefore(String email, String npassword)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction txt = session.beginTransaction();
		Query qry = session.createQuery("update JobSeeker js set js.password=?1 where js.email=?2");
		qry.setString(1, npassword);
		qry.setString(2, email);
		int n = qry.executeUpdate();
		txt.commit();
		session.close();
	    sf.close();
		if(n==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public String getAccess(String email, String password)
	  {
	    Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session session = sf.openSession();
	    Query qry = session.createQuery("select access from JobSeeker js where js.email=?1");
	    String access = null;
	    qry.setString(1, email);
	    List list = qry.list();
	    for(int i=0;i<list.size();i++)
	    {
	      access=(String) list.get(i);
	    }
	    Transaction txt = session.beginTransaction();
	    txt.commit();
	    return access;
	  }
	
	/*public boolean updatejobseeker(String password, String npassword)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction txt = session.beginTransaction();
		Query qry = session.createQuery("update JobSeeker js set js.password=?1 where js.password=?2");
		qry.setString(1, npassword);
		qry.setString(2, password);
		int n = qry.executeUpdate();
		txt.commit();
		session.close();
	    sf.close();
		if(n==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}*/
	public List<JobSeeker> getalljobseekers()
	{
		return (List<JobSeeker>)jobseekerrepository.findAll();
	}
	
	public void deletejobseeker(String email)
	  {
	    //jobseekerrepository.deleteById(email);
	    Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session session = sf.openSession();
	    Transaction txt = session.beginTransaction();
	    Query qry = session.createQuery("update JobSeeker js set js.access=?1 where js.email=?2");
	    qry.setString(1, "Blocked");
	    qry.setString(2, email);
	    int n = qry.executeUpdate();
	    txt.commit();
	    session.close();
	      sf.close();
	  }

	public void unblockjobseekeradmin(String email)
	  {
	    //jobseekerrepository.deleteById(email);
	    Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session session = sf.openSession();
	    Transaction txt = session.beginTransaction();
	    Query qry = session.createQuery("update JobSeeker js set js.access=?1 where js.email=?2");
	    qry.setString(1, "Unblocked");
	    qry.setString(2, email);
	    int n = qry.executeUpdate();
	    txt.commit();
	    session.close();
	      sf.close();
	  }

	
	public String getName(String email, String password)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Query qry = session.createQuery("select fullName from JobSeeker js where js.email=?1");
		String name = null;
		qry.setString(1, email);
		List list = qry.list();
		for(int i=0;i<list.size();i++)
		{
			name=(String) list.get(i);
		}
		Transaction txt = session.beginTransaction();
		txt.commit();
		return name;
	}

	public List<JobSeeker> jsjobseekerprofile(String jsemail) 
	{
		//return (List<JobSeeker>)jobseekerrepository.findAll();
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		
		Query qry=s.createQuery("from JobApplicants js where js.email=?1");
		qry.setString(1,jsemail);
		List<JobSeeker> list=qry.list();
		return list;
	}
	public List<JobSeeker> jobseekerprofile(String jsemail) 
	{
		//return (List<JobSeeker>)jobseekerrepository.findAll();
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		
		Query qry=s.createQuery("from JobSeeker js where js.email=?1");
		qry.setString(1,jsemail);
		List<JobSeeker> list=qry.list();
		return list;
	}
	
	public List<JobApplicants> jsjobprofile(int id) 
	{
		//return (List<JobSeeker>)jobseekerrepository.findAll();
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		
		Query qry=s.createQuery("from JobApplicants js where js.id=?1");
		qry.setInteger(1,id);
		List<JobApplicants> list=qry.list();
		return list;
	}
	
	public void updatejobseeker(JobSeeker js)
	{
		jobseekerrepository.save(js);
		
	}
	
	public boolean jobseekerchangepasswordsubmit(String email, String npassword)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction txt = session.beginTransaction();
		Query qry = session.createQuery("update JobSeeker js set js.password=?1 where js.email=?2");
		qry.setString(1, npassword);
		qry.setString(2, email);
		int n=0;
		n = qry.executeUpdate();
		txt.commit();
		session.close();
	    sf.close();
		if(n!=0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int jobseekerapplyjobcheck(String refid,String jsemail)
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
			    
		double jcgpa = 0,jscgpa = 0;
		int jbacklogs = 0,jsbacklogs = 0,applicants=0;
		String jbranch = null,jsbranch = null,cname=null,loc=null,type=null,deadline=null;
		String role=null;
		int n=0, jsage=0;
		String jsfullname = null,jsgender=null,jsworkstatus=null,jscompanyname=null,jsuniname=null,jsexperience=null;
		String jsaddress=null,jsmobile=null,jspassword=null,jstenthpassyr=null,jstenthpassper=null;
		String jstwelfthpassyr=null,jstwelfthpassper=null,jsgradpassyr=null,jsdob=null,jsskills=null;
		String jsprojects=null,jsglobcerti=null,jsmoocs=null,jsextnactivities=null,jsgitlink=null;
		String jslinkedin=null,jsreference=null,jsprevsalary=null;
			    
		    
		Query q1=s.createQuery("select cgpa from Job where refid=?1 ");
		q1.setString(1,refid);
		List<String> jlist1=q1.list();
		for(int i=0;i<jlist1.size();i++)
			jcgpa = Double.parseDouble(jlist1.get(i));
		
		Query q2=s.createQuery("select backlog from Job where refid=?1 ");
		q2.setString(1,refid);
		List<String> jlist2=q2.list();
		for(int i=0;i<jlist2.size();i++)
			jbacklogs= Integer.parseInt(jlist2.get(i));
			    
		Query q3=s.createQuery("select applicants from Job where refid=?1 ");
		q3.setString(1,refid);
		List<Integer> jlist3=q3.list();
		for(int i=0;i<jlist3.size();i++)
			applicants=jlist3.get(i);
			    
		Query q4=s.createQuery("select role from Job where refid=?1 ");
		q4.setString(1,refid);
		List<String> jlist4=q4.list();
		for(int i=0;i<jlist4.size();i++)
			role=jlist4.get(i);
		
		Query q5=s.createQuery("select companyname from Job where refid=?1 ");
		q5.setString(1,refid);
		List<String> jlist5=q5.list();
		for(int i=0;i<jlist5.size();i++)
			cname=jlist5.get(i);
		
		Query q6=s.createQuery("select location from Job where refid=?1 ");
		q6.setString(1,refid);
		List<String> jlist6=q6.list();
		for(int i=0;i<jlist6.size();i++)
			loc=jlist6.get(i);
		
		Query q7=s.createQuery("select type from Job where refid=?1 ");
		q7.setString(1,refid);
		List<String> jlist7=q7.list();
		for(int i=0;i<jlist7.size();i++)
			type=jlist7.get(i);
		
		Query q8=s.createQuery("select deadline from Job where refid=?1 ");
		q8.setString(1,refid);
		List<String> jlist8=q8.list();
		for(int i=0;i<jlist8.size();i++)
			deadline=jlist8.get(i);
		
		Query q9=s.createQuery("select branch from Job where refid=?1 ");
		q9.setString(1,refid);
		List<String> jlist9=q9.list();
		for(int i=0;i<jlist9.size();i++)
			jbranch=jlist9.get(i);
		
		Query q10=s.createQuery("select gradpassper from JobSeeker where email=?1 ");
		q10.setString(1,jsemail);
		List<String> jlist10=q10.list();
		for(int i=0;i<jlist10.size();i++)
			jscgpa=Double.parseDouble(jlist10.get(i));
		
		Query q11=s.createQuery("select backlogs from JobSeeker where email=?1 ");
		q11.setString(1,jsemail);
		List<String> jlist11=q11.list();
		for(int i=0;i<jlist11.size();i++)
			jsbacklogs=Integer.parseInt(jlist11.get(i));
		
		Query q12=s.createQuery("select branch from JobSeeker where email=?1 ");
		q12.setString(1,jsemail);
		List<String> jlist12=q12.list();
		for(int i=0;i<jlist12.size();i++)
			jsbranch=jlist12.get(i);
		
		Query q13=s.createQuery("select fullName from JobSeeker where email=?1 ");
		q13.setString(1,jsemail);
		List<String> jlist13=q13.list();
		for(int i=0;i<jlist13.size();i++)
			jsfullname=jlist13.get(i);
		
		Query q14=s.createQuery("select gender from JobSeeker where email=?1 ");
		q14.setString(1,jsemail);
		List<String> jlist14=q14.list();
		for(int i=0;i<jlist14.size();i++)
			jsgender=jlist14.get(i);
		
		Query q15=s.createQuery("select age from JobSeeker where email=?1 ");
		q15.setString(1,jsemail);
		List<String> jlist15=q15.list();
		for(int i=0;i<jlist15.size();i++)
			jsage=Integer.parseInt(jlist15.get(i));
		
		Query q16=s.createQuery("select workStatus from JobSeeker where email=?1 ");
		q16.setString(1,jsemail);
		List<String> jlist16=q16.list();
		for(int i=0;i<jlist16.size();i++)
			jsworkstatus=jlist16.get(i);
			   
		Query q17=s.createQuery("select companyName from JobSeeker where email=?1 ");
		q17.setString(1,jsemail);
		List<String> jlist17=q17.list();
		for(int i=0;i<jlist17.size();i++)
			jscompanyname=jlist17.get(i);
		
		Query q18=s.createQuery("select uniname from JobSeeker where email=?1 ");
		q18.setString(1,jsemail);
		List<String> jlist18=q18.list();
		for(int i=0;i<jlist18.size();i++)
			jsuniname=jlist18.get(i);
		
		Query q19=s.createQuery("select exp from JobSeeker where email=?1 ");
		q19.setString(1,jsemail);
		List<String> jlist19=q19.list();
		for(int i=0;i<jlist19.size();i++)
			jsexperience=jlist19.get(i);
		
		Query q20=s.createQuery("select address from JobSeeker where email=?1 ");
		q20.setString(1,jsemail);
		List<String> jlist20=q20.list();
		for(int i=0;i<jlist20.size();i++)
			jsaddress=jlist20.get(i);
		
		Query q21=s.createQuery("select mobile from JobSeeker where email=?1 ");
		q21.setString(1,jsemail);
		List<String> jlist21=q21.list();
		for(int i=0;i<jlist21.size();i++)
			jsmobile=jlist21.get(i);
		
		Query q22=s.createQuery("select password from JobSeeker where email=?1 ");
		q22.setString(1,jsemail);
		List<String> jlist22=q22.list();
		for(int i=0;i<jlist22.size();i++)
			jspassword=jlist22.get(i);
		
		Query q23=s.createQuery("select tenthpassyr from JobSeeker where email=?1 ");
		q23.setString(1,jsemail);
		List<String> jlist23=q23.list();
		for(int i=0;i<jlist23.size();i++)
			jstenthpassyr=jlist23.get(i);
		
		Query q24=s.createQuery("select tenthpassper from JobSeeker where email=?1 ");
		q24.setString(1,jsemail);
		List<String> jlist24=q24.list();
		for(int i=0;i<jlist24.size();i++)
			jstenthpassper=jlist24.get(i);
		
		Query q25=s.createQuery("select twelfthpassyr from JobSeeker where email=?1 ");
		q25.setString(1,jsemail);
		List<String> jlist25=q25.list();
		for(int i=0;i<jlist25.size();i++)
			jstwelfthpassyr=jlist25.get(i);
		
		Query q26=s.createQuery("select twelfthpassper from JobSeeker where email=?1 ");
		q26.setString(1,jsemail);
		List<String> jlist26=q26.list();
		for(int i=0;i<jlist26.size();i++)
			jstwelfthpassper=jlist26.get(i);
		
		Query q27=s.createQuery("select gradpassyr from JobSeeker where email=?1 ");
		q27.setString(1,jsemail);
		List<String> jlist27=q27.list();
		for(int i=0;i<jlist27.size();i++)
			jsgradpassyr=jlist27.get(i);
		
		Query q28=s.createQuery("select dob from JobSeeker where email=?1 ");
		q28.setString(1,jsemail);
		List<String> jlist28=q28.list();
		for(int i=0;i<jlist28.size();i++)
			jsdob=jlist28.get(i);
		
		Query q29=s.createQuery("select skills from JobSeeker where email=?1 ");
		q29.setString(1,jsemail);
		List<String> jlist29=q29.list();
		for(int i=0;i<jlist29.size();i++)
			jsskills=jlist29.get(i);
		
		Query q30=s.createQuery("select projects from JobSeeker where email=?1 ");
		q30.setString(1,jsemail);
		List<String> jlist30=q30.list();
		for(int i=0;i<jlist30.size();i++)
			jsprojects=jlist30.get(i);
		
		Query q31=s.createQuery("select glob_certi from JobSeeker where email=?1 ");
		q31.setString(1,jsemail);
		List<String> jlist31=q31.list();
		for(int i=0;i<jlist31.size();i++)
			jsglobcerti=jlist31.get(i);
		
		Query q32=s.createQuery("select glob_certi from JobSeeker where email=?1 ");
		q32.setString(1,jsemail);
		List<String> jlist32=q32.list();
		for(int i=0;i<jlist32.size();i++)
			jsglobcerti=jlist32.get(i);
		
		Query q33=s.createQuery("select moocs from JobSeeker where email=?1 ");
		q33.setString(1,jsemail);
		List<String> jlist33=q33.list();
		for(int i=0;i<jlist33.size();i++)
			jsmoocs=jlist33.get(i);
		
		Query q34=s.createQuery("select extn_activities from JobSeeker where email=?1 ");
		q34.setString(1,jsemail);
		List<String> jlist34=q34.list();
		for(int i=0;i<jlist34.size();i++)
			jsextnactivities=jlist34.get(i);
		
		Query q35=s.createQuery("select gitlink from JobSeeker where email=?1 ");
		q35.setString(1,jsemail);
		List<String> jlist35=q35.list();
		for(int i=0;i<jlist35.size();i++)
			jsgitlink=jlist35.get(i);
		
		Query q36=s.createQuery("select linkedin from JobSeeker where email=?1 ");
		q36.setString(1,jsemail);
		List<String> jlist36=q36.list();
		for(int i=0;i<jlist36.size();i++)
			jslinkedin=jlist36.get(i);
		
		Query q37=s.createQuery("select reference from JobSeeker where email=?1 ");
		q37.setString(1,jsemail);
		List<String> jlist37=q37.list();
		for(int i=0;i<jlist37.size();i++)
			jsreference=jlist37.get(i);
		
		Query q38=s.createQuery("select prevsalary from JobSeeker where email=?1 ");
		q38.setString(1,jsemail);
		List<String> jlist38=q38.list();
		for(int i=0;i<jlist38.size();i++)
			jsprevsalary=jlist38.get(i);
			    
		String jsage1 = String.valueOf(jsage);
		String jscgpa1 = String.valueOf(jscgpa);
		String jsbacklogs1 = String.valueOf(jsbacklogs);
		if(jscgpa>=jcgpa)
			n++;
		if(jsbacklogs<=jbacklogs)
		    n++;
		jsbranch.toUpperCase();
		if(jbranch.contains(jsbranch))
		    n++;
		if(n==3)
		{
		   JobApplicants jap=new JobApplicants();
		   jap.setRefid(refid);
		   jap.setRole(role);
		   jap.setCompanyname(cname);
		   jap.setLocation(loc);
		   jap.setType(type);
		   jap.setDeadline(deadline);
		   jap.setEmail(jsemail);
		   jap.setFullName(jsfullname);
		   jap.setGender(jsgender);
		   jap.setAge(jsage1);
		   jap.setWorkStatus(jsworkstatus);
		   jap.setCompanyName(jscompanyname);
		   jap.setUniname(jsuniname);
		   jap.setBranch(jsbranch);
		   jap.setExp(jsexperience);
		   jap.setAddress(jsaddress);
		   jap.setMobile(jsmobile);
		   jap.setTenthpassyr(jstenthpassyr);
		   jap.setTenthpassper(jstenthpassper);
		   jap.setTwelfthpassyr(jstwelfthpassyr);
		   jap.setTwelfthpassper(jstwelfthpassper);
		   jap.setGradpassper(jscgpa1);
		   jap.setGradpassyr(jsgradpassyr);
		   jap.setBacklogs(jsbacklogs1);
		   jap.setDob(jsdob);
		   jap.setSkills(jsskills);
		   jap.setProjects(jsprojects);
		   jap.setGlob_certi(jsglobcerti);
		   jap.setMoocs(jsmoocs);
		   jap.setExtn_activities(jsextnactivities);
		   jap.setGitlink(jsgitlink);
		   jap.setLinkedin(jslinkedin);
		   jap.setReference(jsreference);
		   jap.setPrevsalary(jsprevsalary);
		   jap.setProgress("Applied");
		   jap.setStatus("Active");
		   japrepository.save(jap);
		}
		System.out.println(jscgpa);
		System.out.println(jcgpa);
		System.out.println(jsbranch);
		System.out.println(jbranch);
		System.out.println(jsbacklogs);
		System.out.println(jbacklogs);
		System.out.println(applicants);
		System.out.println(n);
		   
		/*Query a4=s.createQuery("update Job set applicants=?1 where refid=?2 ");
		a4.setInteger(1,applicants+1);
		a4.setString(2,refid);
		int n1=a4.executeUpdate();
		Transaction transaction=s.beginTransaction();
		transaction.commit();*/
		   
		return n;
	}
	
	public List<JobApplicants> jobseekerjobstatus(String jsemail)
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		
		Query qry=s.createQuery("from JobApplicants where email=?1");
		qry.setString(1,jsemail);
		List<JobApplicants> list1=qry.list();
		return list1;
	}
	
	public boolean getsuperadminCredentials(String email, String password)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Query qry = session.createQuery("from Superadmin s where s.email=?1 and s.password=?2");
		qry.setString(1, email);
		qry.setString(2, password);
		List<Superadmin> list1 = qry.list();
		int len = list1.size();
		Transaction txt = session.beginTransaction();
		txt.commit();
		session.close();
	    sf.close();
		if(len!=0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean updateSuperadmin(String email, String npassword)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction txt = session.beginTransaction();
		Query qry = session.createQuery("update Superadmin s set s.password=?1 where s.email=?2");
		qry.setString(1, npassword);
		qry.setString(2, email);
		int n = qry.executeUpdate();
		txt.commit();
		session.close();
	    sf.close();
		if(n==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean submitsuperadminchangepwdbefore(String email, String npassword)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction txt = session.beginTransaction();
		Query qry = session.createQuery("update Superadmin s set s.password=?1 where s.email=?2");
		qry.setString(1, npassword);
		qry.setString(2, email);
		int n = qry.executeUpdate();
		txt.commit();
		session.close();
	    sf.close();
		if(n==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public List<JobApplicants> getallapplicants(String cname)
	  {
	    String progress = "Applied";
	    Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session s = sf.openSession();
	    Query qry = s.createQuery("from JobApplicants where progress=?1 and companyname=?2");
	    qry.setString(1, progress);
	    qry.setString(2, cname);
	    List<JobApplicants> list1 = qry.list();
	    return list1;
	  }
	
	public List<JobApplicants> getallapt(String companyname)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Query qry = s.createQuery("from JobApplicants where progress=?1");
		qry.setString(1, "Aptitude Round");
		List<JobApplicants> list1 = qry.list();
		return list1;
	}
	
	public void qualifyapt(int jobid, String email)
	{
	    Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session s = sf.openSession();
	    
	    Job jb = jobrepository.findById(jobid).get(); 
	    int a=jb.getAptround();
	    a=a+1;
	    jb.setAptround(a);
	    jobrepository.save(jb);
	}
	
	public void qualifyapt1(int id)
	{
	    Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session s = sf.openSession();
	    
	    JobApplicants jap= japrepository.findById(id).get(); 
	    jap.setProgress("Aptitude Round");
	    japrepository.save(jap);
	}
	
	public void disqualifyapt(int id)
	{
		  Configuration cfg = new Configuration();
		  cfg.configure("hibernate.cfg.xml");
		  SessionFactory sf = cfg.buildSessionFactory();
		  Session s = sf.openSession();
		    
		  JobApplicants jap= japrepository.findById(id).get(); 
		  jap.setProgress("Aptitude Failed");
		  jap.setStatus("Failed");
		  japrepository.save(jap);
	}
	
	public void qualifyhrtr(int jobid, String email)
	{
		Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session s = sf.openSession();
	    
	    Job jb = jobrepository.findById(jobid).get(); 
	    int a=jb.getHrtrround();
	    a=a+1;
	    jb.setHrtrround(a);;
	    jobrepository.save(jb);
	}
	
	public void qualifyhrtr1(int id)
	{
	    Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session s = sf.openSession();
	    
	    JobApplicants jap= japrepository.findById(id).get(); 
	    jap.setProgress("HR & TR Round");
	    japrepository.save(jap);
	}
	
	public void disqualifyhrtr(int id)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		   
		JobApplicants jap= japrepository.findById(id).get(); 
		jap.setProgress("HR & TR Failed");
		jap.setStatus("Failed");
		japrepository.save(jap);
	}
	
	public List<JobApplicants> getallhrtr(String companyname)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Query qry = s.createQuery("from JobApplicants where progress=?1");
		qry.setString(1, "HR & TR Round");
		List<JobApplicants> list1 = qry.list();
		return list1;
	}
	
	public void qualifyinterview(int jobid, String email)
	{
		Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session s = sf.openSession();
	    
	    Job jb = jobrepository.findById(jobid).get(); 
	    int a=jb.getInterview();
	    a=a+1;
	    jb.setInterview(a);
	    jobrepository.save(jb);
	}
	
	public void qualifyinterview1(int id)
	{
	    Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session s = sf.openSession();
	    
	    JobApplicants jap= japrepository.findById(id).get(); 
	    jap.setProgress("Interview Round");
	    japrepository.save(jap);
	}
	
	public void disqualifyinterview(int id)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		   
		JobApplicants jap= japrepository.findById(id).get(); 
		jap.setProgress("Interview Failed");
		jap.setStatus("Failed");
		japrepository.save(jap);
	}
	
	public List<JobApplicants> getallinterview(String companyname)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Query qry = s.createQuery("from JobApplicants where progress=?1");
		qry.setString(1, "Interview Round");
		List<JobApplicants> list1 = qry.list();
		return list1;
	}
	
	public void jobselected(int jobid, String email)
	{
		Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session s = sf.openSession();
	    
	    Job jb = jobrepository.findById(jobid).get(); 
	    int a=jb.getSelected();
	    a=a+1;
	    jb.setSelected(a);;
	    jobrepository.save(jb);
	}
	
	public void jobselected1(int id)
	{
	    Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session s = sf.openSession();
	    
	    JobApplicants jap= japrepository.findById(id).get(); 
	    jap.setProgress("Selected");
	    jap.setStatus("Congratualations on getting the job!");
	    japrepository.save(jap);
	}
	
	public void jobnotselected(int id)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		   
		JobApplicants jap= japrepository.findById(id).get(); 
		jap.setProgress("Not Selected");
		jap.setStatus("Failed");
		japrepository.save(jap);
	}
	
	public List<JobApplicants> getallselected(String companyname)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Query qry = s.createQuery("from JobApplicants where progress=?1");
		qry.setString(1, "Selected");
		List<JobApplicants> list1 = qry.list();
		return list1;
	}
	
	public List<JobApplicants> failed(String companyname)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Query qry = s.createQuery("from JobApplicants where status=?1");
		qry.setString(1, "Failed");
		List<JobApplicants> list1 = qry.list();
		return list1;
	}
	
	public int getCredentials(String email, String password)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Query qry = session.createQuery("from Recruiter r where r.email=?1 and r.status=?2");
		qry.setString(1, email);
		qry.setString(2,"Accepted");
		List<Recruiter> list = qry.list();
		int len = list.size();
		Transaction txt = session.beginTransaction();
		txt.commit();
		if(len!=0)
		{
			Query qry1= session.createQuery("from Recruiter r where r.email=?1 and r.password=?2 ");
			qry1.setString(1, email);
			qry1.setString(2, password);
			List<Recruiter> list1 = qry1.list();
			int len1 = list1.size();
			Transaction txt1 = session.beginTransaction();
			txt1.commit();
			if(len1!=0)
				return 1;
			else
				return 2;
		}
		else
		{
			Query qry1= session.createQuery("from Recruiter r where r.email=?1 and r.status=?2 ");
			qry1.setString(1, email);
			qry1.setString(2, "Pending");
			List<Recruiter> list1 = qry1.list();
			int len1 = list1.size();
			Transaction txt1 = session.beginTransaction();
			txt1.commit();
			if(len1!=0)
				return 3;
			else
				return 4;
			
		}
	}
	
	public boolean submitrecruiterchangepwdbefore(String email, String npassword)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction txt = session.beginTransaction();
		Query qry = session.createQuery("update Recruiter r set r.password=?1 where r.email=?2");
		qry.setString(1, npassword);
		qry.setString(2, email);
		int n = qry.executeUpdate();
		txt.commit();
		session.close();
	    sf.close();
		if(n==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int recruiterregistration(Recruiter recru, String email)
	  {
	    int flag=0;
	    Configuration cfg=new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf=cfg.buildSessionFactory();
	    Session session=sf.openSession();
	    Query qry1=session.createQuery("from Recruiter where email=:v2");
	    qry1.setParameter("v2",email);
	    System.out.println(email);
	    List<Recruiter> list1=qry1.list();
	    System.out.println(list1.size());
	    if(list1.size()>=1)
	    {
	      System.out.println("Yes");
	      flag=1;
	    }
	    if(flag==0)
	      recrurepository.save(recru);
	    Transaction txt=session.beginTransaction();
	    txt.commit();
	    session.close();
	    sf.close();
	    return flag;
	  }
	
	public void updaterecruiter(Recruiter recru)
	{
		String email,fname,empid,gender,mobno,cname,cloc,pwd,age;
		email=recru.getEmail();
		fname=recru.getFullName();
		empid=recru.getEmpid();
		gender=recru.getGender();
		mobno=recru.getMobile();
		cname=recru.getCompanyName();
		cloc=recru.getCompanyLoc();
		age=recru.getAge();
		Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session session = sf.openSession();
	    Transaction txt = session.beginTransaction();
	    Query qry1 = session.createQuery("update Recruiter r set r.fullName=?1,r.empid=?2,r.gender=?3,r.age=?4,r.mobile=?5,r.companyName=?6,r.companyLoc=?7 where r.email=?8");
	    qry1.setString(1,fname);
	    qry1.setString(2,empid);
	    qry1.setString(3,gender);
	    qry1.setString(4,age);
	    qry1.setString(5,mobno);
	    qry1.setString(6,cname);
	    qry1.setString(7,cloc);
	    qry1.setString(8,email);
	    int n = qry1.executeUpdate();
	    txt.commit();
	    session.close();
	      sf.close();
	}
	
	public void deleterecruiter(String email)
	{
		recrurepository.deleteById(email);
	}
	
	public List<Recruiter> getrecruiterrecords()
	{
		//return (List<Recruiter>)recrurepository.findAll();
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		
		Query qry=s.createQuery("from Recruiter where status='Pending'");
		List<Recruiter> list=qry.list();
		return list;
	}
	

	public void recruaccept(String email)
	  {
	    Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session session = sf.openSession();
	    Transaction txt = session.beginTransaction();
	    Query qry1 = session.createQuery("update Recruiter r set r.status=?1 where r.email=?2");
	    qry1.setString(1, "Accepted");
	    qry1.setString(2, email);
	    int n = qry1.executeUpdate();
	    txt.commit();
	    session.close();
	      sf.close();
	  }
	
	public void recrureject(String email)
	  {
	    Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session session = sf.openSession();
	    Transaction txt = session.beginTransaction();
	    Query qry1 = session.createQuery("update Recruiter r set r.status=?1 where r.email=?2");
	    qry1.setString(1, "Rejected");
	    qry1.setString(2, email);
	    int n = qry1.executeUpdate();
	    txt.commit();
	    session.close();
	      sf.close();
	  }
	
	public List<Recruiter> getallrecruiterrecords()
	{
		return (List<Recruiter>)recrurepository.findAll();
	}
	
	public List<Recruiter> recruiterprofile(String email)
	{
		//return (List<Recruiter>)recrurepository.findAll();
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		
		Query qry=s.createQuery("from Recruiter where email=?1");
		qry.setString(1,email);
		List<Recruiter> list=qry.list();
		return list;
	}
	
	
	public String getrecruName(String email, String password)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Query qry = session.createQuery("select fullName from Recruiter r where r.email=?1");
		String name = null;
		qry.setString(1, email);
		List list = qry.list();
		for(int i=0;i<list.size();i++)
		{
			name=(String) list.get(i);
		}
		Transaction txt = session.beginTransaction();
		txt.commit();
		return name;
	}
	
	public String getCompanyName(String email)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Query qry = session.createQuery("select companyName from Recruiter r where r.email=?1");
		String name = null;
		qry.setString(1, email);
		List list = qry.list();
		for(int i=0;i<list.size();i++)
		{
			name=(String) list.get(i);
		}
		Transaction txt = session.beginTransaction();
		txt.commit();
		return name;
	}
	
	public boolean recruiterchangepasswordsubmit(String email, String npassword)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction txt = session.beginTransaction();
		Query qry = session.createQuery("update Recruiter r set r.password=?1 where r.email=?2");
		qry.setString(1, npassword);
		qry.setString(2, email);
		int n=0;
		n = qry.executeUpdate();
		txt.commit();
		session.close();
	    sf.close();
		if(n!=0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int addjobnew(String companyname, Job job, String name)
	{
		System.out.println(name);
		long count = jobrepository.countByCompanyname(companyname);
		String refid = companyname;
		count=count+1;
		String cnt = String.valueOf(count);
		refid+=cnt;
		//System.out.println(refid);
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		/*Query qry = session.createQuery("insert into Job (companyname, deadline, descr, location, qualification, role, type) values (?,?,?,?,?,?,?)");*/
		Job jb = new Job();
		jb.setCompanyname(job.getCompanyname());
		jb.setDeadline(job.getDeadline());
		jb.setDescr(job.getDescr());
		jb.setLocation(job.getLocation());
		jb.setCgpa(job.getCgpa());
		jb.setBranch(job.getBranch());
		jb.setBacklog(job.getBacklog());
		jb.setRole(job.getRole());
		jb.setType(job.getType());
		jb.setImage(job.getImage());
		jb.setRefid(refid);
		jb.setRecname(name);
		jb.setApplicants(0);
		jb.setAptround(0);
		jb.setHrtrround(0);
		jb.setInterview(0);
		jb.setSelected(0);
		Transaction txt = session.beginTransaction();
		jobrepository.save(jb);
		int n=1;
		txt.commit();
		session.close();
		sf.close();
		if(n==1)
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
	
	
	public List<Job> getalljobs(String name)
	{
		System.out.println(name);
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		
		/*String companyname = "PADWAY";
		Criteria c=s.createCriteria(Recruiter.class);
		c.add(Restrictions.like("fullName", name));
		List <Recruiter> list=c.list();
		for(Recruiter r1:list)
			companyname=r1.getCompanyName();*/
		Query qry=s.createQuery("from Job where recname=?1 ORDER BY deadline DESC");
		qry.setString(1,name);
		List<Job> list1=qry.list();
		return list1;
	}
	
	public void deletejobrecord(int num)
	{
		jobrepository.deleteById(num);
	}
	
	public boolean updatejobrecord(Job job, String deadline, String refid)
	  {
	    //jobrepository.save(job);
	    Configuration cfg = new Configuration();
	    System.out.println(refid);
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session session = sf.openSession();
	    Transaction txt = session.beginTransaction();
	    Query qry = session.createQuery("update Job j set j.deadline=?1 where j.refid=?2");
	    qry.setString(1, deadline);
	    qry.setString(2, refid);
	    int n=0;
	    n = qry.executeUpdate();
	    txt.commit();
	    session.close();
	      sf.close();
	      if(n!=0)
	    {
	      return true;
	    }
	    else
	    {
	      return false;
	    }
	  }
	
	public int getjobid(String refid)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		
		int jobid=0;
		Query a=s.createQuery("select id from Job where refid=?1 ");
		a.setString(1,refid);
		List<Integer> list=a.list();
		for(int i=0;i<list.size();i++)
			jobid = list.get(i);
		return jobid;
	}
	public void updatejob(int jobid)
	{
		Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session s = sf.openSession();
	    
	    Job jb = jobrepository.findById(jobid).get(); 
	    int a=jb.getApplicants();
	    a=a+1;
	    jb.setApplicants(a);
	    jobrepository.save(jb);
	}
	
	public List<Job> getalljobrecords()
	{
		//return (List<Job>)jobrepository.findAll();
		Configuration cfg=new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf=cfg.buildSessionFactory();// Transient State
	    Session s=sf.openSession(); 
	    
	    Query qry = s.createQuery("from Job");
		List<Job> list = qry.list();
		return list;
	}
	public List<Job> getjobrecordbyid(String refid)
	{
		Configuration cfg=new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf=cfg.buildSessionFactory();// Transient State
	    Session s=sf.openSession(); 
	    
	    Query qry = s.createQuery("from Job where refid=?1 "); 
	    qry.setString(1,refid);
		List<Job> list = qry.list();
		return list;
	}
	
	
	public List<Job> jobupdate(String refid)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Query qry = s.createQuery("from Job where refid=?1");
		
		qry.setString(1, refid);
		List<Job> list = qry.list();
		return list;
	}
	
	public void submitcontactus(Contact contact)
	{
		contactrepository.save(contact);
	}
}
