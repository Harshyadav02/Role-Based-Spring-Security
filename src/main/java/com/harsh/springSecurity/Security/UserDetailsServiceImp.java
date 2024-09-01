package com.harsh.springSecurity.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.harsh.springSecurity.Entity.Admin;
import com.harsh.springSecurity.Entity.Employee;
import com.harsh.springSecurity.Repository.AdminRepo;
import com.harsh.springSecurity.Repository.EmployeeRepo;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private AdminRepo adminRepo;
    
    @Autowired
    private EmployeeRepo employeeRepo;
    
    // @Autowired
    // private StudentRepo studentRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Check if the user is an Admin
        Admin adminDetail = adminRepo.findByEmail(email);
        if (adminDetail != null) {
            return User.builder()
                       .username(adminDetail.getEmail())
                       .password(adminDetail.getPassword())
                       .roles("ADMIN")
                       .build();
        }
        
        // Check if the user is an Employee
        Employee employeeDetail = employeeRepo.findByEmail(email);
        if (employeeDetail != null) {
            return User.builder()
                       .username(employeeDetail.getEmail())
                       .password(employeeDetail.getPassword())
                       .roles("EMPLOYEE")
                       .build();
        }
        // If no user found, throw an exception
        throw new UsernameNotFoundException("No user found with email: " + email);
    }
}
