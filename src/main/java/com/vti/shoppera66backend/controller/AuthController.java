//package com.vti.shoppera66backend.controller;
//
//import com.vti.shoppera66backend.modal.dto.LoginDto;
//import com.vti.shoppera66backend.modal.entity.Account;
//import com.vti.shoppera66backend.repository.AccountRepository;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
////import sun.security.jca.ProviderList;
//
//import java.security.Principal;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("api/v1/product")
//@CrossOrigin("*")
//public class AuthController {
//    @Autowired
//    private AccountRepository accountRepository;
//
//
//    @GetMapping("/login-basic-v1")
//    public LoginDto loginV1(Principal principal) {
//        String username = principal.getName();
//
//        Optional<Account> optionalAccount = accountRepository.findFirstByUsername(username);
//////        ProviderList.ServiceList accountOptional;
////        if (accountOptional.isEmpty()) {
////            throw new UsernameNotFoundException("Username không tồn tại");
////        }
////        Account account = accountOptional.get();
////        LoginDto loginDto = new LoginDto();
////        BeanUtils.copyProperties(account, loginDto);
////        return loginDto;
////
////    }
////}
////
////    @GetMapping("/login-basic-v2")
////    public LoginDto loginV1(Principal principal) {
////        String username = principal.getName();
////
////        Optional<Account> optionalAccount = accountRepository.findFirstByUsername(username);
//////        ProviderList.ServiceList accountOptional;
//////        if (accountOptional.isEmpty()) {
////            throw new UsernameNotFoundException("Username không tồn tại");
////        }
////////        Account account = accountOptional.get();
//////        LoginDto loginDto = new LoginDto();
//////        BeanUtils.copyProperties(account, loginDto);
//////        return loginDto;
//////
//////    }
//////}
////
//
//
