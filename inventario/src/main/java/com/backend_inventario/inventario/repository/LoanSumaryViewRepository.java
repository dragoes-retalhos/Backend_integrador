package com.backend_inventario.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend_inventario.inventario.entity.dto.LoanSumaryViewDto;

public interface LoanSumaryViewRepository extends JpaRepository<LoanSumaryViewDto, Long> {
    
}
