package com.harsh.springSecurity.Repository;

import org.springframework.data.repository.CrudRepository;

import com.harsh.springSecurity.Entity.Employee;

public interface EmployeeRepo extends CrudRepository<Employee,String>{
    
    public Employee findByEmail(String email);
}
