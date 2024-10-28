package com.backend_inventario.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend_inventario.inventario.entity.Loan;
import com.backend_inventario.inventario.service.LoanService;
import com.backend_inventario.inventario.util.ApiErrorResponse;

@RestController
@RequestMapping("/api/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping
    public ResponseEntity<Object> getAllLoans() {
        try {
            List<Loan> loanList = loanService.getAllLoans(); 
            if (loanList.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.ok(loanList);
        } catch (RuntimeException e) {
            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.NOT_FOUND.value(),
                    "Not Found",
                    e.getMessage(),
                    "/api/loan/");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        } catch (Exception e) {
            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Internal Server Error",
                    "Erro ao buscar os empréstimos",
                    "/api/loan/");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping
    public ResponseEntity<Object> createLoan(@RequestBody Loan loan) {
        try {
            Loan newLoan = loanService.createLoan(loan);
            return ResponseEntity.status(HttpStatus.CREATED).body(newLoan);
        } catch (RuntimeException e) {
            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.BAD_REQUEST.value(),
                    "Bad Request",
                    e.getMessage(),
                    "/api/loan/");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } catch (Exception e) {
            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Internal Server Error",
                    "Erro ao criar o empréstimo",
                    "/api/loan/");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
/* 
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateLoan(@PathVariable Long id, @RequestBody Loan loan) {
        try {
            Loan updatedLoan = loanService.updateLoan(id, loan); // Supondo que você tenha esse método no LoanService
            return ResponseEntity.ok(updatedLoan);
        } catch (RuntimeException e) {
            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.NOT_FOUND.value(),
                    "Not Found",
                    e.getMessage(),
                    "/api/loan/" + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        } catch (Exception e) {
            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Internal Server Error",
                    "Erro ao atualizar o empréstimo",
                    "/api/loan/");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
*/
    @GetMapping("/{id}")
    public ResponseEntity<Object> getLoanById(@PathVariable Long id) {
        try {
            Loan loan = loanService.getLoanById(id); // Supondo que você tenha esse método no LoanService
            return ResponseEntity.ok(loan);
        } catch (RuntimeException e) {
            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.NOT_FOUND.value(),
                    "Not Found",
                    e.getMessage(),
                    "/api/loan/" + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        } catch (Exception e) {
            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Internal Server Error",
                    "Erro ao buscar o empréstimo",
                    "/api/loan/");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
