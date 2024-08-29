package com.harsh.springSecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.harsh.springSecurity.Entity.Employee;
import com.harsh.springSecurity.Repository.EmployeeRepo;

@Service
public class EmployeeService {
    @Autowired 
    private PasswordEncoder passwordEncoder;
    @Autowired 
    private EmployeeRepo employeeRepo;

    public Employee getEmployeeData(String username){

        return employeeRepo.findByEmail(username);
    }
    public void createEmployee(Employee empDetails){
        String encryptedPassword = passwordEncoder.encode(empDetails.getPassword());
        empDetails.setPassword(encryptedPassword);
        employeeRepo.save(empDetails);
    }
}
