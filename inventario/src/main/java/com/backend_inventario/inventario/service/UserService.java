package com.backend_inventario.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.backend_inventario.inventario.entity.User;
import com.backend_inventario.inventario.repository.UserRepository;
import com.backend_inventario.inventario.util.ResourceNotFoundException;

import jakarta.validation.Valid;

@Service
@Validated
public class UserService {
   
    @Autowired
    private UserRepository userRepository;

    public User createUser(@Valid User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + id));
    }

    public User updateUser(User newUser) {
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
}
