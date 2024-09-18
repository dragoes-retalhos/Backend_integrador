package com.backend_inventario.inventario.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @Column(name = "id_loan")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 

    @Column(name = "loan_date")
    private LocalDateTime loanDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @Column(name = "status")
    private int status;

    @ManyToOne
    @JoinColumn(name = "user_id_user")
    private User associatedUser;

    @ManyToOne
    @JoinColumn(name = "user_loan_iduser_loan")
    private UserLoan associatedUserLoan;

    public Loan() {
    }

    public Loan(long id, LocalDateTime loanDate, LocalDateTime returnDate, int status, User associatedUser,
            UserLoan associatedUserLoan) {
        this.id = id;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.status = status;
        this.associatedUser = associatedUser;
        this.associatedUserLoan = associatedUserLoan;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDateTime loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getAssociatedUser() {
        return associatedUser;
    }

    public void setAssociatedUser(User associatedUser) {
        this.associatedUser = associatedUser;
    }

    public UserLoan getAssociatedUserLoan() {
        return associatedUserLoan;
    }

    public void setAssociatedUserLoan(UserLoan associatedUserLoan) {
        this.associatedUserLoan = associatedUserLoan;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
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
        Loan other = (Loan) obj;
        if (id != other.id)
            return false;
        return true;
    }

    

}