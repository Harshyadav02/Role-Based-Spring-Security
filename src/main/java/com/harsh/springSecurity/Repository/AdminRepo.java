package com.harsh.springSecurity.Repository;

import org.springframework.data.repository.CrudRepository;

import com.harsh.springSecurity.Entity.Admin;

public interface AdminRepo extends CrudRepository<Admin,String>{
    
    public Admin findByUsername(String username);
}
