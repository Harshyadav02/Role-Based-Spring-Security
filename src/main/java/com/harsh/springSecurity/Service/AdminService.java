package com.harsh.springSecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.harsh.springSecurity.Entity.Admin;
import com.harsh.springSecurity.Repository.AdminRepo;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public void createAdminUser(Admin adminDetails) {
        // password encryption
        adminDetails.setPassword(passwordEncoder.encode(adminDetails.getPassword()));
        adminRepo.save(adminDetails);
    }
    
    public Admin getAdminDetails(String email) {
        Admin adminDetails = adminRepo.findByEmail(email);
        return adminDetails;
    }
}
