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

    public ResponseEntity<?> updateEmployeeData(String email,Employee empDetails) {
        // Retrieve the existing employee from the database
        Employee existingEmployee = employeeRepo.findByEmail(email);
        if(existingEmployee==null) {
            return new ResponseEntity<>("Not a valid user to perform update version",HttpStatus.FORBIDDEN);
        }
        // Update fields if they are not null
        if (empDetails.getEmail() != null && !empDetails.getEmail().isEmpty()) {
            existingEmployee.setEmail(empDetails.getEmail());
        }
        if (empDetails.getPassword() != null && !empDetails.getPassword().isEmpty()) {
            existingEmployee.setPassword(empDetails.getPassword());
        }
        if (empDetails.getFirstName() != null && !empDetails.getFirstName().isEmpty()) {
            existingEmployee.setFirstName(empDetails.getFirstName());
        }
        if (empDetails.getLastName() != null && !empDetails.getLastName().isEmpty()) {
            existingEmployee.setLastName(empDetails.getLastName());
        }
        if (empDetails.getPhoneNumber() != null && !empDetails.getPhoneNumber().isEmpty()) {
            existingEmployee.setPhoneNumber(empDetails.getPhoneNumber());
        }
        if (empDetails.getPosition() != null && !empDetails.getPosition().isEmpty()) {
            existingEmployee.setPosition(empDetails.getPosition());
        }
    
        
        employeeRepo.save(existingEmployee);
        return new ResponseEntity<>("Employee Updated", HttpStatus.OK);
    }
    
}
