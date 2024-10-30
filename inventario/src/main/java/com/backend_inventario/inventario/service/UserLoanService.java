package com.backend_inventario.inventario.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.backend_inventario.inventario.entity.UserLoan;
import com.backend_inventario.inventario.repository.UserLoanRepository;
import com.backend_inventario.inventario.util.ResourceNotFoundException;

import jakarta.validation.Valid;


@Service
@Validated
public class UserLoanService {
    @Autowired
    private UserLoanRepository userRepository;

    public UserLoan createUser(@Valid UserLoan userLoan) {
        return userRepository.save(userLoan);
    }

    public List<UserLoan> getAllUsers() {
        return userRepository.findAll();
    }

    public UserLoan getUserById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + id));
    }

    public UserLoan updateUser(UserLoan newUser) {
        validateUserExists(newUser.getId()); 
        return userRepository.save(newUser);
    }

    public void deleteUser(Long id) {
        validateUserExists(id); 
        userRepository.deleteById(id);
    }

    
    private void validateUserExists(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuário não encontrado com ID: " + id);
        }
    }

    public List<UserLoan> getUserByName(String name) {
        List<UserLoan> users = userRepository.findByNameContaining(name);
        if (users.isEmpty()) {
            throw new ResourceNotFoundException("Usuário não encontrado com nome: " + name);
        }
        return users;
    }
}
