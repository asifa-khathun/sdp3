package com.klu.demo;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController 
{
	@Autowired
	MainService mainservice;
	
	@PostMapping("/submitcontactus")
	public String submitcontactus(@ModelAttribute("contact") Contact contact)
	{
		mainservice.submitcontactus(contact);
	    return "redirect:/thankyou";
	}

	
	@GetMapping("/thankyou")
	public ModelAndView thankyou()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("thankyou");
		return mv;
	}  
	
	@GetMapping("/applicants/{cname}")
	public ModelAndView applicants(@PathVariable("cname") String cname)
	{
		List<JobApplicants> ja = mainservice.getallapplicants(cname);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("applicants");
		mv.addObject("jobapplicants", ja);
		return mv;
	}
	
	@GetMapping("/aptround/{cname}")
	public ModelAndView aptitude(@PathVariable("cname") String cname)
	{
		List<JobApplicants> ja = mainservice.getallapt(cname);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aptitude");
		mv.addObject("jobapplicants", ja);
		return mv;
	}
	
	@GetMapping("/japaptitudequalify/{refid}/{email}/{companyname}/{id}")
	public String qualapt(@PathVariable("refid") String refid,@PathVariable("email") String email,@PathVariable("companyname") String companyname,@PathVariable("id") int id)
	{
		int jobid=mainservice.getjobid(refid);
	    mainservice.qualifyapt(jobid, email); //job table
	    mainservice.qualifyapt1(id);			 //jobapplicants table
	    return "redirect:/applicants/{companyname}";
	}
	
	 @GetMapping("/japaptitudedisqualify/{refid}/{email}/{companyname}/{id}")
	 public String disqapt(@PathVariable("refid") String refid,@PathVariable("email") String email,@PathVariable("companyname") String companyname,@PathVariable("id") int id)
	 {
		  mainservice.disqualifyapt(id);			 //jobapplicants table
		  return "redirect:/applicants/{companyname}";
	 }
	 
	 @GetMapping("/hrtrround/{cname}")
	 public ModelAndView hrtr(@PathVariable("cname") String cname)
	 {
		 List<JobApplicants> ja = mainservice.getallhrtr(cname);
		 ModelAndView mv = new ModelAndView();
		 mv.setViewName("hrtr");
		 mv.addObject("jobapplicants", ja);
		 return mv;
	 }
	
	@GetMapping("/japhrtrqualify/{refid}/{email}/{companyname}/{id}")
	public String qualhrtr(@PathVariable("refid") String refid,@PathVariable("email") String email,@PathVariable("companyname") String companyname,@PathVariable("id") int id)
	{
		int jobid=mainservice.getjobid(refid);
	    mainservice.qualifyhrtr(jobid, email); //job table
	    mainservice.qualifyhrtr1(id);		//jobapplicants table
	    return "redirect:/aptround/{companyname}";
	}
	
	@GetMapping("/japhrtrdisqualify/{refid}/{email}/{companyname}/{id}")
	public String disqhrtr(@PathVariable("refid") String refid,@PathVariable("email") String email,@PathVariable("companyname") String companyname,@PathVariable("id") int id)
	{
		mainservice.disqualifyhrtr(id);			 //jobapplicants table
		return "redirect:/aptround/{companyname}";
	}
	
	@GetMapping("/interviewround/{cname}")
	public ModelAndView interview(@PathVariable("cname") String cname)
	{
		List<JobApplicants> ja = mainservice.getallinterview(cname);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("interview");
		mv.addObject("jobapplicants", ja);
		return mv;
	}
	
	@GetMapping("/japinterviewqualify/{refid}/{email}/{companyname}/{id}")
	public String qualinterview(@PathVariable("refid") String refid,@PathVariable("email") String email,@PathVariable("companyname") String companyname,@PathVariable("id") int id)
	{
		int jobid=mainservice.getjobid(refid);
	    mainservice.qualifyinterview(jobid, email); //job table
	    mainservice.qualifyinterview1(id);		//jobapplicants table
	    return "redirect:/hrtrround/{companyname}";
	}
	
	@GetMapping("/japinterviewdisqualify/{refid}/{email}/{companyname}/{id}")
	public String disqinterview(@PathVariable("refid") String refid,@PathVariable("email") String email,@PathVariable("companyname") String companyname,@PathVariable("id") int id)
	{
		mainservice.disqualifyinterview(id);			 //jobapplicants table
		return "redirect:/hrtrround/{companyname}";
	}
	
	@GetMapping("/selected/{cname}")
	public ModelAndView selected(@PathVariable("cname") String cname)
	{
		List<JobApplicants> ja = mainservice.getallselected(cname);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("selected");
		mv.addObject("jobapplicants", ja);
		return mv;
	}
	
	@GetMapping("/japselected/{refid}/{email}/{companyname}/{id}")
	public String selected(@PathVariable("refid") String refid,@PathVariable("email") String email,@PathVariable("companyname") String companyname,@PathVariable("id") int id)
	{
		int jobid=mainservice.getjobid(refid);
	    mainservice.jobselected(jobid, email); //job table
	    mainservice.jobselected1(id);		//jobapplicants table
	    return "redirect:/interviewround/{companyname}";
	}
	
	@GetMapping("/japnotselected/{refid}/{email}/{companyname}/{id}")
	public String notselected(@PathVariable("refid") String refid,@PathVariable("email") String email,@PathVariable("companyname") String companyname,@PathVariable("id") int id)
	{
		mainservice.jobnotselected(id);			 //jobapplicants table
		return "redirect:/interviewround/{companyname}";
	}
	
	@GetMapping("/failed/{cname}")
	public ModelAndView failed(@PathVariable("cname") String cname)
	{
		List<JobApplicants> ja = mainservice.failed(cname);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("failed");
		mv.addObject("jobapplicants", ja);
		return mv;
	}
	
	@GetMapping("/jobaddnew")
	public ModelAndView jobaddnew()
	{
		ModelAndView mv=new ModelAndView();
		return new ModelAndView("jobaddnew", "job", new Job());
	}
	
	@PostMapping("/addnewjob/{name}")
	public String jobaddnewsubmit(@ModelAttribute("job") Job job, @RequestParam("companyname") String companyname,@RequestParam("recname") String recname)
	{
		int flag = mainservice.addjobnew(companyname, job, recname);
		if(flag==1)
			return "redirect:/jobaddnewfail";
		else
		    return "redirect:/jobaddnewsuccess";
		
	}
	
	@GetMapping("/jobaddnewsuccess")
	public ModelAndView jobaddnewsuccess()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("jobaddnewsuccess");
		return mv;
	}
	
	@GetMapping("/jobaddnewfail")
	public ModelAndView jobaddnewfail()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("jobaddnewfail");
		return mv;
	}
	
	@GetMapping("/recruiterviewjobs/{name}")
	public ModelAndView jobviewall(@PathVariable("name") String name)
	{
		List<Job> j=mainservice.getalljobs(name);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("recruiterviewjobs");
		mv.addObject("jobs",j);
		return mv;
	}
	
	@GetMapping("/recrujobupdate/{refid}")
	public ModelAndView jobupdate(@PathVariable("refid") String refid)
	{
		List<Job> jobs = mainservice.jobupdate(refid);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("recrujobupdate");
		mv.addObject("job", jobs);
		return mv;
	}
	
	@GetMapping("/jsjobprofile/{id}")
	public ModelAndView jsjobprofile(@PathVariable("id") int id)
	{
		List<JobApplicants> jobseekers = mainservice.jsjobprofile(id);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("jsjobprofile");
		mv.addObject("jobseekers", jobseekers);
		return mv;
	}
	
	@PostMapping("/recrujobupdatesubmit/{name}/{refid}")
	  public String updatejob(@ModelAttribute("job") Job job, @PathVariable("name") String name, @PathVariable("refid") String refid, @RequestParam("deadline") String deadline)
	  {
	    boolean val = mainservice.updatejobrecord(job, deadline, refid);
	    if(val)
	    {
	      return "redirect:/recruiterviewjobs/{name}";
	    }
	    else
	    {
	      return "redirect:/recruiterhome";
	    }
	  }
	
	@GetMapping("/jobseekerviewjobs")
	public ModelAndView jobseekerviewjobs()
	{
		List<Job> jsviewjobs=mainservice.getalljobrecords();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("jobseekerviewjobs");
		mv.addObject("jsjobs",jsviewjobs);
		return mv;
	}
	@GetMapping("/jobseekerviewjob/{refid}")
	public ModelAndView jobseekerviewjob(@PathVariable("refid") String refid)
	{
		List<Job> jsviewjobs=mainservice.getjobrecordbyid(refid);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("jobseekerviewjob");
		mv.addObject("jsjobs",jsviewjobs);
		return mv;
	}
	
	@GetMapping("/jobseekerhome")
	public ModelAndView jobseekerhome(HttpServletRequest request,HttpSession session)
	{
		String jsname =(String) session.getAttribute("jsname");
		String jsemail =(String) session.getAttribute("jsemail");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jobseekerhome");
		mv.addObject("jsname",jsname);
		mv.addObject("jsemail",jsemail);
		return mv;
	}
	
	@GetMapping("/jobseekerregistration")
	public ModelAndView addjobseeker()
	{
		return new ModelAndView("jobseekerregistration", "js", new JobSeeker());
	}
	
	
	@GetMapping("/jobseekerregistrationtryagain")
    public ModelAndView jobseekerregistrationtryagain()
    {
      ModelAndView mv = new ModelAndView();
      mv.setViewName("jobseekerregistrationtryagain");
      return mv;
    }
 
 @PostMapping("/addjobseekersubmit")
 public ModelAndView submitrecuiter(@ModelAttribute("js") JobSeeker js,@RequestParam("email") String email)
   {
     ModelAndView mv = new ModelAndView();
     int flag=mainservice.jobseekerregistration(js,email);
     if(flag==1)
       
      mv.setViewName("jobseekerregistrationtryagain");
     else
       mv.setViewName("jobseekerlogin");
     return mv;
   }
	@GetMapping("/jobseekerchangepwdbefore")
	public ModelAndView jobseekerchangepwdbefore()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jobseekerchangepwdbefore");
		return mv;
	}
	
	@RequestMapping("/submitjobseekerchangepwdbefore")
	public String submitjobseekerchangepwdbefore(@RequestParam("email") String email, @RequestParam("npassword") String npassword, HttpServletRequest req)
	{
		boolean val = mainservice.submitjobseekerchangepwdbefore(email, npassword);
		if(val)
		{
			return "redirect:/jobseekerlogin";
		}
		else
		{
			return "redirect:/jobseekerchangepwdbefore";
		}
	}
	
	@GetMapping("/jobseekerlogin")
	public ModelAndView login()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jobseekerlogin");
		return mv;
	}
	
	@GetMapping("/jobseekerlogintryagain")
	public ModelAndView jobseekerlogintryagain()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jobseekerlogintryagain");
		return mv;
	}
	
	@RequestMapping(value="/jobseekerlogincheck")
	  public ModelAndView checklogin(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session,HttpServletRequest request)
	  {
	    session.setAttribute("email",email);
	      String jsname=mainservice.getName(email, password);
	      String access = mainservice.getAccess(email, password);
	      String jsemail=email;
	      int val = mainservice.getjobseekerCredentials(email, password, access);
	      if(val==0)
	      {
	        session.setAttribute("jsname",jsname);
	        session.setAttribute("jsemail",jsemail);
	        ModelAndView mv = new ModelAndView();
	        mv.setViewName("jobseekerhome");
	        mv.addObject("jsname",jsname);
	        mv.addObject("jsemail",jsemail);
	        return mv;
	      }
	      else if(val==1)
	      {
	        ModelAndView mv = new ModelAndView();
	        mv.setViewName("jobseekerlogintryagain");
	        return mv;  
	      }
	      ModelAndView mv = new ModelAndView();
	    mv.setViewName("jobseekerloginblocked");
	    return mv;  
	      
	  }
	
	
	
	@GetMapping("/jobseekersviewall")
	public ModelAndView jobseekersviewall()
	{
		List<JobSeeker> j=mainservice.getalljobseekers();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("jobseekersviewall");
		mv.addObject("js",j);
		return mv;
	}
	@GetMapping("/jobseekersviewalladmin")
	public ModelAndView jobseekersviewalladmin()
	{
		List<JobSeeker> j=mainservice.getalljobseekers();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("jobseekersviewalladmin");
		mv.addObject("js",j);
		return mv;
	}


	
	@GetMapping("/jobseekerprofile")
	  public ModelAndView jobseekerprofile(HttpSession session)
	  {
	    String jsemail =(String) session.getAttribute("jsemail");
	    List<JobSeeker> jobseekers=mainservice.jobseekerprofile(jsemail);
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("jobseekerprofile");
	    mv.addObject("jobseekers",jobseekers);
	    return mv;
	  }
	
	@GetMapping("/jobseekerprofileupdate")
	  public ModelAndView jobseekerprofileupdate(HttpSession session)
	  {
	    String jsemail =(String) session.getAttribute("jsemail");
	    List<JobSeeker> jobseekers=mainservice.jobseekerprofile(jsemail);
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("jobseekerprofileupdate");
	    mv.addObject("jobseekers",jobseekers);
	    return mv;
	  }
	
	@PostMapping("/jobseekerprofileupdatesubmit")
	  public ModelAndView jobseekerprofileupdatesubmit(@ModelAttribute("js") JobSeeker js)
	    {
	    String jsemail =js.getEmail();
	    List<JobSeeker> jobseekers=mainservice.jobseekerprofilesubmit(js,jsemail);
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("jobseekerprofile");
	    mv.addObject("jobseekers",jobseekers);
	    return mv;
	    }
	@GetMapping("/jobseekerchangepassword")
	public ModelAndView jobseekerchangepassword()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jobseekerchangepassword");
		return mv;
	}
	
	@RequestMapping("/jobseekerchangepasswordsubmit")
	public String jobseekerchangepasswordsubmit(@RequestParam("email") String email, @RequestParam("npassword") String npassword, HttpServletRequest req)
	{
		boolean val = mainservice.jobseekerchangepasswordsubmit(email, npassword);
		if(val)
		{
			return "redirect:/jobseekerlogin";
		}
		else
		{
			return "redirect:/jobseekerchangepassword";
		}
	}
	
	@GetMapping("/jobseekerapplyjob/{refid}")
	public ModelAndView jobseekerapplyjob(@PathVariable("refid") String refid)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jobseekerapplyjob");
		mv.addObject(refid);
		return mv;
	}
	@GetMapping("/jobseekerapplyjobcheck/{refid}")
	public ModelAndView jobseekerapplyjobcheck(@PathVariable("refid") String refid,HttpSession session)
	{
		String jsemail =(String) session.getAttribute("jsemail");
		int n = mainservice.jobseekerapplyjobcheck(refid,jsemail);
		if(n==3)
		{
			int jobid=mainservice.getjobid(refid);
			mainservice.updatejob(jobid);
			ModelAndView mv=new ModelAndView();
			mv.setViewName("jobseekerapplyjobsuccess");
			return mv;
		}
		else
		{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("jobseekerapplyjobfail");
			mv.addObject("n",n);
			return mv;
		}
	}
	
	@GetMapping("/jobseekerapplyjobsuccess")
	public ModelAndView jobseekerapplyjobsuccess()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jobseekerapplyjobsuccess");
		return mv;
	}
	@GetMapping("/jobseekerapplyjobfail")
	public ModelAndView jobseekerapplyjobfail()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jobseekerapplyjobfail");
		return mv;
	}
	
	@GetMapping("/jobseekerjobstatus/{jsemail}")
	public ModelAndView jobseekerjobstatus(@PathVariable("jsemail") String jsemail,HttpSession session)
	{
		List<JobApplicants> jobs=mainservice.jobseekerjobstatus(jsemail);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jobseekerjobstatus");
		mv.addObject("job", jobs);
		return mv;
	}
	
	@GetMapping("/recruiterjobseekerprofile/{email}")
	public ModelAndView recruiterjobseekerprofile(@PathVariable("email") String email,HttpSession session)
	{
		List<JobSeeker> jobseekers=mainservice.jobseekerprofile(email);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("recruiterjobseekerprofile");
		mv.addObject("jobseekers",jobseekers);
		return mv;
	}
	
	@GetMapping("/superadminviewjobseeker/{email}")
	public ModelAndView superadminviewjobseeker(@PathVariable("email") String email,HttpSession session)
	{
		List<JobSeeker> jobseekers=mainservice.jobseekerprofile(email);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("superadminviewjobseeker");
		mv.addObject("jobseekers",jobseekers);
		return mv;
	}
	@GetMapping("/superadminviewjobseeker")
	public ModelAndView superadminviewjobseeker()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("superadminviewjobseeker");
		return mv;
	}
	@GetMapping("unblockjobseeker/{email}")
	public String blockjobseekeradmin(@PathVariable("email") String email,HttpSession session)
	{
	  mainservice.unblockjobseekeradmin(email);
	  return "redirect:/jobseekersviewalladmin";
	}

	@GetMapping("/deletejobseeker/{email}")
	public String deletejobseeker(@PathVariable("email") String email,HttpSession session)
	{
	  mainservice.deletejobseeker(email);
	  return "redirect:/jobseekersviewalladmin";
	}
	
	@GetMapping("/recruiterhome")
	public ModelAndView home(HttpServletRequest request,HttpSession session)
	{
		String name =(String) session.getAttribute("name");
		String cname =(String) session.getAttribute("cname");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("recruiterhome");
		mv.addObject("name",name);
		mv.addObject("cname",cname);
		return mv;
	}
	
	@GetMapping("/recruiterjobstatus")
	public ModelAndView recruiterjobstatus(HttpServletRequest request,HttpSession session)
	{
		String cname =(String) session.getAttribute("cname");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("recruiterjobstatus");
		mv.addObject("cname",cname);
		return mv;
	} 
	 @GetMapping("/recruiterregistration")
	  public ModelAndView addrecruiter()
	  {
	    return new ModelAndView("recruiterregistration", "recru", new Recruiter());
	  }
	  
	  
	  @GetMapping("/recruiterregistrationtryagain")
	   public ModelAndView recruiterregistrationtryagain()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("recruiterregistrationtryagain");
	     return mv;
	   }
	   
	    @PostMapping("/addrecruitersubmit")
	    public ModelAndView submitrecuiter(@ModelAttribute("recru") Recruiter recru,@RequestParam("email") String email)
	    {
	      ModelAndView mv = new ModelAndView();
	      int flag=mainservice.recruiterregistration(recru,email);
	      if(flag==1)
	        
	       mv.setViewName("recrutierregistrationtryagain");
	      else
	        mv.setViewName("recruiterlogin");
	      return mv;
	    }
	  
	
	@GetMapping("/recruiterchangepwdbefore")
	public ModelAndView recruiterchangepwdbefore()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("recruiterchangepwdbefore");
		return mv;
	}
	
	@RequestMapping("/submitrecruiterchangepwdbefore")
	public String submitrecruiterchangepwdbefore(@RequestParam("email") String email, @RequestParam("npassword") String npassword, HttpServletRequest req)
	{
		boolean val = mainservice.submitrecruiterchangepwdbefore(email, npassword);
		if(val)
		{
			return "redirect:/recruiterlogin";
		}
		else
		{
			return "redirect:/recruiterchangepwdbefore";
		}
	}
	
	@GetMapping("/recruiterlogin")
	public ModelAndView recrulogin()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("recruiterlogin");
		return mv;
	}
	
	@GetMapping("/recruiterlogout")
	public ModelAndView logout(HttpSession session)
	{
		session.invalidate();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("recruiterlogin");
		return mv;
	}
	@GetMapping("/jobseekerlogout")
	public ModelAndView jobseekerlogout(HttpSession session)
	{
		session.invalidate();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jobseekerlogin");
		return mv;
	}
	@GetMapping("/superadminlogout")
	public ModelAndView superadminlogout(HttpSession session)
	{
		session.invalidate();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("superadminlogin");
		return mv;
	}
	
	@GetMapping("/recruiterlogintryagain")
	public ModelAndView recruiterlogintryagain()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("recruiterlogintryagain");
		return mv;
	}
	
	@GetMapping("/recruiterloginpending")
	public ModelAndView recruiterloginpending()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("recruiterloginpending");
		return mv;
	}
	
	@GetMapping("/recruiterloginrejected")
	public ModelAndView recruiterloginrejected()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("recruiterloginrejected");
		return mv;
	}
	
	
	@RequestMapping(value = "/recruiterlogincheck")
	public ModelAndView recruchecklogin(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session,HttpServletRequest request)
	{
		int val = mainservice.getCredentials(email, password);
		session.setAttribute("email",email);
		String name=mainservice.getrecruName(email, password);
		String cname=mainservice.getCompanyName(email);
		//System.out.println(val);
		if(val==1)
		{
			session.setAttribute("name",name);
			session.setAttribute("cname",cname);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("recruiterhome");
			mv.addObject("name",name);
			return mv;
		}
		else if(val==2)
		{
			ModelAndView mv = new ModelAndView();
			mv.setViewName("recruiterlogintryagain");
			return mv;
		}
		else if(val==3)
		{
			ModelAndView mv = new ModelAndView();
			mv.setViewName("recruiterloginpending");
			return mv;
		}
		else
		{
			ModelAndView mv = new ModelAndView();
			mv.setViewName("recruiterloginrejected");
			return mv;
		}
		
	}
	
	@GetMapping("/recruiterrequests")
	public ModelAndView recruiterrequests()
	{
		List<Recruiter> recruiters=mainservice.getrecruiterrecords();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("recruiterrequests");
		mv.addObject("recdata",recruiters);
		return mv;
	}
	
	@GetMapping("/recruiterproof/{proof}")
	  public ModelAndView recruiterproof(@PathVariable("proof") String proof)
	  {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("recruiterproof");
		mv.addObject("proof",proof);
		return mv;
	  }
	
	@GetMapping("/acceptrecruiter/{email}")
	  public String acceptrecruiter(@PathVariable("email") String email)
	  {
	    mainservice.recruaccept(email);
	      
	    	// Recipient's email ID needs to be mentioned.
	        String to = email;

	        // Sender's email ID needs to be mentioned
	        String from = "Padvay4124@gmail.com";

	        // Assuming you are sending email from through gmails smtp
	        String host = "smtp.gmail.com";

	        // Get system properties
	        Properties properties = System.getProperties();

	        // Setup mail server
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", "465");
	        properties.put("mail.smtp.ssl.enable", "true");
	        properties.put("mail.smtp.auth", "true");

	        // Get the Session object.// and pass username and password
	        Session session = Session.getInstance(properties, new javax.mail.Authenticator() 
	        {

	            protected PasswordAuthentication getPasswordAuthentication() 
	            {
	                return new PasswordAuthentication("Padvay4124@gmail.com", "sas@4124");
	            }

	        });

	        // Used to debug SMTP issues
	        session.setDebug(true);
	        try 
	        {
	            // Create a default MimeMessage object.
	            MimeMessage message = new MimeMessage(session);

	            // Set From: header field of the header.
	            message.setFrom(new InternetAddress(from));

	            // Set To: header field of the header.
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	            // Set Subject: header field
	            message.setSubject("Welcome to PADVAY!");

	            // Now set the actual message
	            message.setText("Congratulations on joining PADVAY! You can now login with your credentials.\n\nLink for Login: http://localhost:2021/recruiterlogin\n\nThank you\nTeam PADVAY");

	            System.out.println("sending...");
	            // Send message
	            Transport.send(message);
	            System.out.println("Sent message successfully....");
	        } 
	        catch (MessagingException mex) 
	        {
	            mex.printStackTrace();
	        }
	    return "redirect:/recruiterrequests";
	  }
	
	 @GetMapping("/rejectrecruiter/{email}")
	  public String rejectrecruiter(@PathVariable("email") String email)
	  {
	      mainservice.recrureject(email);
	      
	      String to = email;

	        // Sender's email ID needs to be mentioned
	        String from = "Padvay4124@gmail.com";

	        // Assuming you are sending email from through gmails smtp
	        String host = "smtp.gmail.com";
	     // Get system properties
	        Properties properties = System.getProperties();

	        // Setup mail server
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", "465");
	        properties.put("mail.smtp.ssl.enable", "true");
	        properties.put("mail.smtp.auth", "true");

	        // Get the Session object.// and pass username and password
	        Session session = Session.getInstance(properties, new javax.mail.Authenticator() 
	        {

	            protected PasswordAuthentication getPasswordAuthentication() 
	            {
	                return new PasswordAuthentication("Padvay4124@gmail.com", "sas@4124");
	            }

	        });

	        // Used to debug SMTP issues
	        session.setDebug(true);
	        try 
	        {
	            // Create a default MimeMessage object.
	            MimeMessage message = new MimeMessage(session);

	            // Set From: header field of the header.
	            message.setFrom(new InternetAddress(from));

	            // Set To: header field of the header.
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	            // Set Subject: header field
	            message.setSubject("PADVAY: Sorry, your details are not valid!");

	            // Now set the actual message
	            message.setText("We are sorry to inform that your registration request has been rejected.\n\nYou may try to register again here: http://localhost:2021/recruiterregistration\n\nThank you\nTeam PADVAY");

	            System.out.println("sending...");
	            // Send message
	            Transport.send(message);
	            System.out.println("Sent message successfully....");
	        } 
	        catch (MessagingException mex) 
	        {
	            mex.printStackTrace();
	        }
	      
	      return "redirect:/recruiterrequests";
	  }
	
	@GetMapping("/recruitersall")
	public ModelAndView recruiterall()
	{
		List<Recruiter> recruiters=mainservice.getallrecruiterrecords();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("recruitersall");
		mv.addObject("recdata",recruiters);
		return mv;
	}
	
	@GetMapping("/recruiterprofile")
	public ModelAndView recruiterprofile(HttpSession session)
	{
		String email =(String) session.getAttribute("email");
		List<Recruiter> recruiters=mainservice.recruiterprofile(email);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("recruiterprofile");
		mv.addObject("recdata",recruiters);
		return mv;
	}
	
	@GetMapping("/recruiterprofileupdate")
	public ModelAndView recruiterprofileupdate(HttpSession session)
	{
		String email =(String) session.getAttribute("email");
		List<Recruiter> recruiters=mainservice.recruiterprofile(email);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("recruiterprofileupdate");
		mv.addObject("recdata",recruiters);
		return mv;
	}
	
	@PostMapping("/recruiterprofileupdatesubmit")
	public ModelAndView recruiterprofileupdatesubmit(@ModelAttribute("recru") Recruiter recru)
	  {
		mainservice.updaterecruiter(recru);
		String email =recru.getEmail();
		List<Recruiter> recruiters=mainservice.recruiterprofile(email);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("recruiterprofile");
		mv.addObject("recdata",recruiters);
		return mv;
	  }
	
	
	@GetMapping("/recruiterchangepassword")
	public ModelAndView recruiterchangepassword()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("recruiterchangepassword");
		return mv;
	}
	@GetMapping("/recruiterchangepasswordfail")
	public ModelAndView recruiterchangepasswordfail()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("recruiterchangepasswordfail");
		return mv;
	}
	
	@RequestMapping("/recruiterchangepasswordsubmit")
	public String recruiterchangepasswordsubmit(@RequestParam("email") String email, @RequestParam("npassword") String npassword, HttpServletRequest req)
	{
		boolean val = mainservice.recruiterchangepasswordsubmit(email, npassword);
		if(val)
		{
			return "redirect:/recruiterlogin";
		}
		else
		{
			return "redirect:/recruiterchangepasswordfail";
		}
	}
	
	@GetMapping("/index")
	public ModelAndView home()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@GetMapping("/contactus")
	public ModelAndView contact()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("contactus");
		return mv;
	}
	
	@GetMapping("/aboutus")
	public ModelAndView aboutus()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("aboutus");
		return mv;
	}
	/*@GetMapping("/about")
	public ModelAndView about()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("about");
		return mv;
	}*/
	
	@GetMapping("/superadminhome")
	public ModelAndView superadminhome()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("superadminhome");
		return mv;
	}
	
	@GetMapping("/superadminlogin")
	public ModelAndView superadminlogin()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("superadminlogin");
		return mv;
	}
	
	@GetMapping("/superadminlogintryagain")
	public ModelAndView superadminlogintryagain()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("superadminlogintryagain");
		return mv;
	}
	
	@RequestMapping(value = "/superadminlogincheck")
	public String checklogin(@RequestParam("email") String email, @RequestParam("password") String password)
	{
		boolean val = mainservice.getsuperadminCredentials(email, password);
		//System.out.println(val);
		if(val)
		{
			return "redirect:/superadminhome";
		}
		else
		{
			return "redirect:/superadminlogintryagain";	
		}
	}
	
	@GetMapping("/superadminchangepwd")
	public ModelAndView updatesuperadmin()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("superadminchangepwd");
		return mv;
	}
	
	@RequestMapping("/submitsuperadminupdate")
	public String updatesuperadminsubmit(@RequestParam("email") String email, @RequestParam("npassword") String npassword, HttpServletRequest req)
	{
		//String email = (String) req.getSession().getAttribute("email");
		//req.getSession().setAttribute("email", email);
		boolean val = mainservice.updateSuperadmin(email, npassword);
		if(val)
		{
			return "redirect:/superadminlogin";
		}
		else
		{
			return "redirect:/superadminchangepwd";
		}
	}
	
	@GetMapping("/superadminchangepwdbefore")
	public ModelAndView superadminchangepwdbefore()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("superadminchangepwdbefore");
		return mv;
	}
	
	@RequestMapping("/submitsuperadminchangepwdbefore")
	public String submitsuperadminchangepwdbefore(@RequestParam("email") String email, @RequestParam("npassword") String npassword, HttpServletRequest req)
	{
		boolean val = mainservice.submitsuperadminchangepwdbefore(email, npassword);
		if(val)
		{
			return "redirect:/superadminlogin";
		}
		else
		{
			return "redirect:/superadminchangepwdbefore";
		}
	}
}
