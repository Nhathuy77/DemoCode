package com.vti.shoppera66backend.repository;

import com.vti.shoppera66backend.modal.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findFirstByUsername(String username);
}
