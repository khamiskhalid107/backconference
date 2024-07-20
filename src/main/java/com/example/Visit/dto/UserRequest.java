package com.example.Visit.dto;

import com.example.Visit.model.Role;
import lombok.Data;

@Data
public class UserRequest {

    private String username;
    private String email;
    private String pasword;
    private Role role;
}
//   private Long id;
//    private String username;
//    private String email;
//    private String phone;