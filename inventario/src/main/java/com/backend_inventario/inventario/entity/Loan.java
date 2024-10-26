package com.backend_inventario.inventario.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
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

    @Column(name = "loan_date", nullable = false)
    private LocalDateTime loanDate;

    @Column(name = "return_date", nullable = true)
    private LocalDateTime returnDate;

    @ManyToOne
    @JoinColumn(name = "user_id_user", nullable = false) 
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_loan_iduser_loan", nullable = false) 
    private UserLoan userLoan;


    public Loan() {
    }

   

    public Loan(long id, LocalDateTime loanDate, LocalDateTime returnDate, User user, UserLoan userLoan) {
        this.id = id;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.user = user;
        this.userLoan = userLoan;
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

    public UserLoan getUserLoan() {
        return userLoan;
    }

    public void setUserLoan(UserLoan userLoan) {
        this.userLoan = userLoan;
    }

    public User getUser() {
        return user;
    }



    public void setUser(User user) {
        this.user = user;
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
