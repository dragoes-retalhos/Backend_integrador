package com.backend_inventario.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend_inventario.inventario.entity.User;
import com.backend_inventario.inventario.service.UserService;



@RestController
@RequestMapping(value = "/api/login")
public class LoginController {

    @Autowired
    UserService userService;
    
    @PostMapping("/authentication")
    public ResponseEntity<User> login(@RequestBody User user){

        User userLogin = userService.authentication(user.getEmail(), user.getPassword());
        return ResponseEntity.ok(userLogin);

        
    }
        
        
    

}
