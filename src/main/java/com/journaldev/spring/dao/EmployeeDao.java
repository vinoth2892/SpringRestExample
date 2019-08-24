package com.journaldev.spring.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Employee;

@Repository
public class EmployeeDao {
	
	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	} 
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDao.class);
	Map<Integer, Employee> empData = new HashMap<Integer, Employee>();
	
	public Employee getDummyEmployee() {
		
		logger.info("Start getDummyEmployee Controller");
		Employee emp = new Employee();
		emp.setId(9999);
		emp.setName("Dummy");
		emp.setCreatedDate(new Date());
		empData.put(9999, emp);
		return emp;

		
	}
	
	public Employee getEmployee(int empId)
	{
		 Employee e=(Employee)template.get(Employee.class,empId);
		return e;
	}

}
