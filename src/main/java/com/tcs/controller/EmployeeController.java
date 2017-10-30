package com.tcs.controller;

import com.tcs.repository.EmployeeRepository;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tcs.model.Employee;

 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/api")
public class EmployeeController{
	private static final String SUCCESS = "sucess";
	private static final String RESPONSE_DATA = "data";
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	@Autowired
	private EmployeeRepository empRepo;
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping( value = "/getEmployees", method=RequestMethod.GET )
	public Map<String, Object> getEmployees(){
        logger.info("This is an info message");
		
		List<Employee> employees = empRepo.findAll();
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put(SUCCESS, true);
		response.put(RESPONSE_DATA, employees);
	  
		return response;
	}
	
	/**
	 * 
	 * @param employeeId
	 * @return
	 */
	@RequestMapping(value = "/getEmployee/{employeeId}", method=RequestMethod.GET)
	public Map<String, Object> getEmployee( @PathVariable("employeeId") String employeeId){
	
		Employee emp = empRepo.findOne(employeeId);
		
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		
		if(emp != null ){
			response.put(SUCCESS, true);
			response.put(RESPONSE_DATA, emp);
		} else{
			response.put(SUCCESS , false);
			response.put(RESPONSE_DATA, null);
			response.put("msg","No Data found");
		}
		
		return response;
	}
	
	/**
	 * 
	 * @param emp
	 * @return
	 */
	@RequestMapping(value = "/createEmployee" , method = RequestMethod.POST)
	public Map<String, Object> createEmployee(@RequestBody  Map<String, Object> emp){
	
		String name = (emp.get("name") == null)?null:emp.get("name").toString();
		String stream = (emp.get("stream") == null)?null:emp.get("stream").toString();
		Double experience = (emp.get("experience") == null)?null:Double.parseDouble(emp.get("experience").toString());
		Double salary = (emp.get("salary") == null)?null:Double.parseDouble(emp.get("salary").toString());
		
		
		Employee  newEmp = new Employee(name, stream, experience, salary);
		
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("message" , "Employee Records Created");
		response.put(SUCCESS, true);
		response.put(RESPONSE_DATA, newEmp);
		empRepo.save(newEmp);
		return response;
	}
	
	/**
	 * 
	 * @param emp
	 * @param employeeId
	 * @return
	 */
	@RequestMapping(value = "/updateEmployee/{employeeId}", method= RequestMethod.PUT)
	public Map<String, Object> updateEmployee(@RequestBody Map<String, Object> emp, @PathVariable("employeeId") String employeeId){
	
		//Employee oldEmp  = empRepo.findOne(employeeId);
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		
		Employee oldEmp = empRepo.findOne(employeeId);
		
		String name = (emp.get("name") == null)?null:emp.get("name").toString();
		String stream = (emp.get("stream") == null)?null:emp.get("stream").toString();
		Double experience = (emp.get("experience") == null)?null:Double.parseDouble(emp.get("experience").toString());
		Double salary = (emp.get("salary") == null)?null:Double.parseDouble(emp.get("salary").toString());
		
		Employee updatedEmp = new Employee(name, stream, experience, salary);
		updatedEmp.setId(employeeId);
		
		if(oldEmp != null){
			if(updatedEmp.getName() == null)
				updatedEmp.setName(oldEmp.getName());
			if(updatedEmp.getStream() == null)
				updatedEmp.setStream(oldEmp.getStream());
			if(updatedEmp.getExperience() == null)
				updatedEmp.setExperience(oldEmp.getExperience());
			if(updatedEmp.getSalary() == null)
				updatedEmp.setSalary(oldEmp.getSalary());
			
			response.put(SUCCESS, true);
			empRepo.save(updatedEmp);
			response.put(RESPONSE_DATA, updatedEmp);
		} else {
			response.put(SUCCESS, false);
			response.put(RESPONSE_DATA,"No Data Found to update");
		}
		return response;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.DELETE)
	public Map<String, Object> deleteEmployee(@PathVariable("id") String id){
		Employee empObj = empRepo.findOne(id);
		Map<String , Object> response = new LinkedHashMap<String, Object>();
		
		if(empObj != null ){
			empRepo.delete(id);
			response.put(SUCCESS, true);
			response.put(RESPONSE_DATA, empObj);
			response.put("msg", "Document Deleted with Id:"+id);
		} else{
			response.put(SUCCESS , false);
			response.put(RESPONSE_DATA, null);
			response.put("msg","No Data found to delete");
		}
		return response;
	}
}
