package com.harsh.springSecurity.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.harsh.springSecurity.Entity.Admin;
import com.harsh.springSecurity.Repository.AdminRepo;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private AdminRepo adminRepo;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Admin adminDetail = adminRepo.findByUsername(username);

        if (adminDetail == null) {
            throw new UsernameNotFoundException("User with username\t" + username + "not found");
        }

        // building User Object by authecation provider and returing it to authentication manager
        return User
                .builder()
                .username(adminDetail.getUsername())
                .password(adminDetail.getPassword())
                // .roles(adminDetail.getRoles())
                .build();
    }
}
