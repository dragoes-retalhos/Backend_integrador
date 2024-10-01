package com.backend_inventario.inventario.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend_inventario.inventario.entity.User;
import com.backend_inventario.inventario.repository.UserRepository;



@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/authentication")
    public ResponseEntity<String> authentication(@RequestBody User user){
        
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if(existingUser.isPresent()){

            if(existingUser.get().getPassword().equals(user.getPassword())){

               return ResponseEntity.ok("Login Realizado com sucesso"); 

            } else {

                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha inválida.");
            }

        }  

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");     

    }
         

}
