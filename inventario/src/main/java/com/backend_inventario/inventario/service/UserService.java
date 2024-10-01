package com.backend_inventario.inventario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.backend_inventario.inventario.entity.User;
import com.backend_inventario.inventario.repository.UserRepository;

import jakarta.validation.Valid;

@Service
@Validated
public class UserService {
   
    @Autowired
    private UserRepository userRepository;

    public User createUser(@Valid User user) {
         
        return  userRepository.save(user);
       
    }


    public List<User> getAllUsers(){
        
        return userRepository.findAll();
    }


    public User getUserById(Long id){

        if(!userRepository.existsById(id)){
            throw new RuntimeException("Usuario nao encontrado");
        }

        Optional <User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }


    public User updateUser(User newUser){

      if(!userRepository.existsById(newUser.getId())){
        throw new RuntimeException("Usuario nao encontrado");
      }

      return userRepository.save(newUser);

    }


    public void deletUser(Long id){

        if(!userRepository.existsById(id)){
            throw new RuntimeException("Usuário com ID " + id + " não encontrado");
        }

        userRepository.deleteById(id);
    }



        
    
        
}
