package com.backend_inventario.inventario.entity.dto;

import java.util.List;

import com.backend_inventario.inventario.entity.Loan;

public class LoanRequestDTO {
    private Loan loan; 
    private List<Long> laboratoryItemIds; 

    

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public List<Long> getLaboratoryItemIds() {
        return laboratoryItemIds;
    }

    public void setLaboratoryItemIds(List<Long> laboratoryItemIds) {
        this.laboratoryItemIds = laboratoryItemIds;
    }
}
