package com.harsh.springSecurity.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Admin {
    @Id
    private String username;
    @JsonIgnore
    @Column(nullable = false)
    private  String password;
    @Column(nullable = false, length = 5)
    private String roles = "ADMIN";
}