package com.backend_inventario.inventario.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "loan_has_laboratory_item")
public class LoanHasLaboratoryItem {

    @ManyToOne
    @JoinColumn(name = "loan_id_loan")
    private Loan loanIdLoan;

    @ManyToOne
    @JoinColumn(name = "laboratory_item_id_laboratory_item")
    private LaboratoryItem laboratoryItemIdLaboratoryItem;

    public LoanHasLaboratoryItem() {

        
    }

    public LoanHasLaboratoryItem(Loan loanIdLoan, LaboratoryItem laboratoryItemIdLaboratoryItem) {
        this.loanIdLoan = loanIdLoan;
        this.laboratoryItemIdLaboratoryItem = laboratoryItemIdLaboratoryItem;
    }

    public Loan getLoanIdLoan() {
        return loanIdLoan;
    }

    public void setLoanIdLoan(Loan loanIdLoan) {
        this.loanIdLoan = loanIdLoan;
    }

    public LaboratoryItem getLaboratoryItemIdLaboratoryItem() {
        return laboratoryItemIdLaboratoryItem;
    }

    public void setLaboratoryItemIdLaboratoryItem(LaboratoryItem laboratoryItemIdLaboratoryItem) {
        this.laboratoryItemIdLaboratoryItem = laboratoryItemIdLaboratoryItem;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((loanIdLoan == null) ? 0 : loanIdLoan.hashCode());
        result = prime * result
                + ((laboratoryItemIdLaboratoryItem == null) ? 0 : laboratoryItemIdLaboratoryItem.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LoanHasLaboratoryItem other = (LoanHasLaboratoryItem) obj;
        if (loanIdLoan == null) {
            if (other.loanIdLoan != null)
                return false;
        } else if (!loanIdLoan.equals(other.loanIdLoan))
            return false;
        if (laboratoryItemIdLaboratoryItem == null) {
            if (other.laboratoryItemIdLaboratoryItem != null)
                return false;
        } else if (!laboratoryItemIdLaboratoryItem.equals(other.laboratoryItemIdLaboratoryItem))
            return false;
        return true;
    }

    
    

}
