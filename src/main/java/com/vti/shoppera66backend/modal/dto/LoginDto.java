package com.vti.shoppera66backend.modal.dto;

import com.vti.shoppera66backend.modal.entity.Role;
import lombok.Data;
@Data
public class LoginDto {
    private int id;
    private String username;
    private Role role;
    private String fullname;


}
