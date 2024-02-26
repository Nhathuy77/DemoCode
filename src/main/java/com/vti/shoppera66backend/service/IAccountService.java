package com.vti.shoppera66backend.service;

import com.vti.shoppera66backend.modal.dto.AccountCreatRequestDto;
import com.vti.shoppera66backend.modal.dto.AccountUpdateRequestDto;
import com.vti.shoppera66backend.modal.dto.BaseRequest;
import com.vti.shoppera66backend.modal.entity.Account;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IAccountService {
    List<Account> getAll();

    Account create(AccountCreatRequestDto dto);

    Account update(AccountUpdateRequestDto dto);

    Account getById(int id);

    void delete(int id);
}
