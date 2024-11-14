package com.backend_inventario.inventario.entity.dto;

import java.util.List;

import com.backend_inventario.inventario.entity.Loan;
import com.backend_inventario.inventario.entity.UserLoan;

public class UserLoanRequestDto {
    
    private UserLoan user;
    private List<Loan> loans;

    public UserLoan getUser() {
        return user;
    }
    public void setUser(UserLoan user) {
        this.user = user;
    }
    public List<Loan> getLoans() {
        return loans;
    }
    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
    public UserLoanRequestDto() {
    }
    public UserLoanRequestDto(UserLoan user, List<Loan> loans) {
        this.user = user;
        this.loans = loans;
    }



    
}
