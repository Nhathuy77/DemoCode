package com.vti.shoppera66backend.modal.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ACCOUNT")
@Data
public class Account extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "USERNAME", length = 50, unique = true, nullable = false)
    private String username;

    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "PASSWORD", length = 100, nullable = false)
    private String password;

    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    @Column(name = "ADDRESS", length = 255)
    private String address;

    @Column(name = "FULL_NAME", length = 50)
    private String fullName;

    @Column(name = "PHONE_NUMBER", length = 12)
    private String phoneNumber;

    @Column(name = "EMAIL", length = 50, unique = true, nullable = false)
    private String email;

    @Column(name = "INFORMATION", length = 500)
    private String information;


}
