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
    private Loan associatedLoan;

    @ManyToOne
    @JoinColumn(name = "laboratory_item_id_laboratory_item")
    private LaboratoryItem associatedLaboratoryItem;

    public LoanHasLaboratoryItem() {

        
    }

    public LoanHasLaboratoryItem(Loan associatedLoan, LaboratoryItem associatedLaboratoryItem) {
        this.associatedLoan = associatedLoan;
        this.associatedLaboratoryItem = associatedLaboratoryItem;
    }

    public Loan getAssociatedLoan() {
        return associatedLoan;
    }

    public void setAssociatedLoan(Loan associatedLoan) {
        this.associatedLoan = associatedLoan;
    }

    public LaboratoryItem getAssociatedLaboratoryItem() {
        return associatedLaboratoryItem;
    }

    public void setAssociatedLaboratoryItem(LaboratoryItem associatedLaboratoryItem) {
        this.associatedLaboratoryItem = associatedLaboratoryItem;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((associatedLoan == null) ? 0 : associatedLoan.hashCode());
        result = prime * result + ((associatedLaboratoryItem == null) ? 0 : associatedLaboratoryItem.hashCode());
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
        if (associatedLoan == null) {
            if (other.associatedLoan != null)
                return false;
        } else if (!associatedLoan.equals(other.associatedLoan))
            return false;
        if (associatedLaboratoryItem == null) {
            if (other.associatedLaboratoryItem != null)
                return false;
        } else if (!associatedLaboratoryItem.equals(other.associatedLaboratoryItem))
            return false;
        return true;
    }

    
    
}
