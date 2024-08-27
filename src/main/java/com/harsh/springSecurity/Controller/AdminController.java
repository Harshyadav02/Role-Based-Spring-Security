package com.harsh.springSecurity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harsh.springSecurity.Entity.Admin;
import com.harsh.springSecurity.Service.AdminService;

@RestController
@RequestMapping("/admin/")
public class AdminController {
    
    @Autowired
    private AdminService adminService;

    //  Adding new Admin user
    @PostMapping()
    public ResponseEntity<?> createAdmin(@RequestBody Admin adminDetails){

        try {
             adminService.createAdminUser(adminDetails);
             return new ResponseEntity<>("New admin created",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
