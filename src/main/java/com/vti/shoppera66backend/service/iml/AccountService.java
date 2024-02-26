package com.vti.shoppera66backend.service.iml;

import com.vti.shoppera66backend.config.exception.AppException;
import com.vti.shoppera66backend.config.exception.ErrorResponseEnum;
import com.vti.shoppera66backend.modal.dto.AccountCreatRequestDto;
import com.vti.shoppera66backend.modal.dto.AccountUpdateRequestDto;
import com.vti.shoppera66backend.modal.entity.Account;
import com.vti.shoppera66backend.modal.entity.Role;
import com.vti.shoppera66backend.repository.AccountRepository;
import com.vti.shoppera66backend.repository.ProductRepository;
import com.vti.shoppera66backend.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountService implements IAccountService, UserDetailsService {
    @Autowired
    public AccountRepository accountRepository;


    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account create(AccountCreatRequestDto dto) {
        Optional<Account> optionalAccount = accountRepository.findFirstByUsername(dto.getUsername());
        if (optionalAccount.isPresent()){
            throw new AppException(ErrorResponseEnum.USERNAME_EXISTED);
        }
        Account account = new Account();
        BeanUtils.copyProperties(dto, account);
        account.setRole(Role.CUSTOMER);
        return accountRepository.save(account);
    }

    @Override
    public Account update(AccountUpdateRequestDto dto) {
        Optional<Account> optionalAccount = accountRepository.findById(dto.getId());
        if (optionalAccount.isPresent()){
            Account account = optionalAccount.get();
            BeanUtils.copyProperties(dto, account);
            return accountRepository.save(account);
        }else {
            throw new AppException(ErrorResponseEnum.NOT_FOUND_ACCOUNT);
        }
    }

    @Override
    public Account getById(int id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()){
            return optionalAccount.get();
        }
        throw new AppException(ErrorResponseEnum.NOT_FOUND_ACCOUNT);
    }

    @Override
    public void delete(int id) {
        accountRepository.deleteById(id);
    }


    /**
     * Dùng để Spring security kiểm tra username có tồn tại trong hệ thống hay ko.
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> accountOptional = accountRepository.findFirstByUsername(username);
        if (accountOptional.isEmpty()){
            throw new UsernameNotFoundException("Username không tồn tại");
        }
        Account account = accountOptional.get();
        // Nếu Account có tồn tại -> tạo ra đối tượng UserDetails từ Account
        /**
         * account.getUsername(): username
         * account.getPassword(): password đã được mã hoá.
         * authorities: danh sách quyền của user
         */
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(account.getRole());
        return new User(account.getUsername(), account.getPassword(), authorities);
    }
}
