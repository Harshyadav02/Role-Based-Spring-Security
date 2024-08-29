package com.harsh.springSecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<?> getEmployeeData(String email){

        Employee empDetails = employeeRepo.findByEmail(email);
        if(empDetails!=null) return new ResponseEntity<>(empDetails,HttpStatus.OK);
        return new ResponseEntity<>("No such user",HttpStatus.NOT_FOUND);
        
    }
    public void createEmployee(Employee empDetails){
        String encryptedPassword = passwordEncoder.encode(empDetails.getPassword());
        empDetails.setPassword(encryptedPassword);
        employeeRepo.save(empDetails);
    }
}
