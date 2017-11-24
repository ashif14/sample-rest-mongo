package com.app.repository;

import com.app.model.Employee;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 
 * @author Administrator
 *
 */
public interface EmployeeRepository extends MongoRepository<Employee, String> {
}