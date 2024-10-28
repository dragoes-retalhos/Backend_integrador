package com.backend_inventario.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend_inventario.inventario.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long>{
    
}
