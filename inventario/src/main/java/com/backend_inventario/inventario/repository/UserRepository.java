package com.backend_inventario.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend_inventario.inventario.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
 
    
    
}