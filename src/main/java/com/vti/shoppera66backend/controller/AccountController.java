package com.vti.shoppera66backend.controller;

import com.vti.shoppera66backend.modal.dto.AccountCreatRequestDto;
import com.vti.shoppera66backend.modal.dto.AccountUpdateRequestDto;
import com.vti.shoppera66backend.modal.entity.Account;
import com.vti.shoppera66backend.service.IAccountService;
import com.vti.shoppera66backend.service.iml.AccountService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// BTVN: Code tiêp các chức năng CRUD: Account, Product
// Ngày hôm sau:
// + code tiếp các chức năng của Order
// + học sâu spring JPA -> seach, lọc dữ liệu, phân trang
// + VAlidate dữ liệu đầu vào


@RestController
@RequestMapping("api/v1/account")
@CrossOrigin("*")
@Slf4j
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @GetMapping("/get-all")
    public List<Account> getAll(){
        log.info("Get All Account info");
        log.warn("Get All Account warning");
        log.error("Get All Account error");
        return accountService.getAll();
    }

    @PostMapping("/create")
    public Account create(@RequestBody AccountCreatRequestDto dto){
        return accountService.create(dto);
    }

    @PutMapping("/update")
    public Account update(@RequestBody AccountUpdateRequestDto dto){
        return accountService.update(dto);
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable int id){
        return accountService.getById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize(value = "hasAnyAuthority('ADMIN')")
    public void delete(@PathVariable int id){
        accountService.delete(id);
    }
}
