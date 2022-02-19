package com.klu.demo;

import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job,Integer>
{
	long countByCompanyname(String companyname);
}
