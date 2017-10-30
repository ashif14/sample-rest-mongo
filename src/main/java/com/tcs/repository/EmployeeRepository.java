package com.tcs.repository;

import com.tcs.model.Employee;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 
 * @author Administrator
 *
 */
public interface EmployeeRepository extends MongoRepository<Employee, String> {
}