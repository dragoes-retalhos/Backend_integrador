
package com.backend_inventario.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend_inventario.inventario.entity.User;
import com.backend_inventario.inventario.service.UserService;
import com.backend_inventario.inventario.util.ApiErrorResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        try {

            User createdUser = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);

        } catch (DataIntegrityViolationException e) {

            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.CONFLICT.value(),
                    "Conflict",
                    "Email já cadastrado",
                    "/api/users");

            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);

        } catch (Exception e) {

            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Internal Server Error",
                    "Erro interno no servidor",
                    "/api/users");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }

    }

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        try {
            List<User> users = userService.getAllUsers();
            if (users.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Internal Server Error",
                    "Erro ao buscar os usuários",
                    "/api/users");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getIdUser(@PathVariable Long id) {
        try {
            User user = userService.getUserById(id);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.NOT_FOUND.value(),
                    "Not Found",
                    e.getMessage(),
                    "/api/users/" + id);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);

        } catch (Exception e) {
            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Internal Server Error",
                    "Erro ao buscar o usuário",
                    "/api/users/" + id);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PutMapping
    public ResponseEntity<Object> updateUser(@Valid @RequestBody User user) {

        try {

            User updateUser = userService.updateUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(updateUser);

        } catch (DataIntegrityViolationException e) {

            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.CONFLICT.value(),
                    "Conflict",
                    "Email já cadastrado",
                    "/api/users");

            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);

        } catch (RuntimeException e) {
            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.NOT_FOUND.value(),
                    "Not Found",
                    e.getMessage(),
                    "/api/users/" + user.getId());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);

        } catch (Exception e) {

            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Internal Server Error",
                    "Erro interno no servidor",
                    "/api/users");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }

    }

    @DeleteMapping
    public ResponseEntity<Object> deletUser(@PathVariable Long id) {

        try {

            userService.deletUser(id);
            return ResponseEntity.noContent().build();

        } catch (RuntimeException e) {
            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.NOT_FOUND.value(),
                    "Not Found",
                    e.getMessage(),
                    "/api/users/" + id);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);

        } catch (Exception e) {

            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Internal Server Error",
                    "Erro interno no servidor",
                    "/api/users");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }

    }

}
