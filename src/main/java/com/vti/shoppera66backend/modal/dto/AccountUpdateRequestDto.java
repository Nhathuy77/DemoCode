package com.vti.shoppera66backend.modal.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AccountUpdateRequestDto {
    private int id;
    private String username;
    private String password;
    private Date dateOfBirth;
    private String address;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String information;
}
