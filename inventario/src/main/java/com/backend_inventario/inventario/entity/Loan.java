package com.backend_inventario.inventario.entity;

import java.time.LocalDateTime;

import com.backend_inventario.inventario.entity.Enum.StatusUserAndLoanEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loan")
    private long id; 

    @Column(name = "loan_date", nullable = false)
    private LocalDateTime loanDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private StatusUserAndLoanEnum status;

    @ManyToOne
    @JoinColumn(name = "user_id_user", nullable = false) 
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_loan_iduser_loan", nullable = false) 
    private UserLoan userLoan;


    public Loan() {}

    public Loan(long id, LocalDateTime loanDate, LocalDateTime returnDate, StatusUserAndLoanEnum status, User user, UserLoan userLoan) {
        this.id = id;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.status = status;
        this.user = user;
        this.userLoan = userLoan;
    }

    
    @PrePersist
    protected void onCreate() {
        if (status == null) {
            status = StatusUserAndLoanEnum.ACTIVE;
        }
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

    public StatusUserAndLoanEnum getStatus() {
        return status;
    }

    public void setStatus(StatusUserAndLoanEnum status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserLoan getUserLoan() {
        return userLoan;
    }

    public void setUserLoan(UserLoan userLoan) {
        this.userLoan = userLoan;
    }

    // Métodos de igualdade e hash
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Loan other = (Loan) obj;
        return id == other.id;
    }
}
