package com.backend_inventario.inventario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend_inventario.inventario.entity.UserLoan;

public interface UserLoanRepository extends JpaRepository<UserLoan, Long> {
    List<UserLoan> findByNameContaining(String name);
}
