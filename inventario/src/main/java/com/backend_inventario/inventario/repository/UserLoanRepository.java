package com.backend_inventario.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend_inventario.inventario.entity.UserLoan;

public interface UserLoanRepository extends JpaRepository<UserLoan, Long> {
    
}
