package com.backend_inventario.inventario.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import com.backend_inventario.inventario.entity.Enum.StatusUserAndLoanEnum;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loan")
    private long id; 

    @Column(name = "loan_date", nullable = false)
    private LocalDateTime loanDate;

    @Column(name = "expected_return_date", nullable = false)
    private LocalDate expectedReturnDate;
    
    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private StatusUserAndLoanEnum status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id_user", nullable = false) 
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_loan_iduser_loan", nullable = false) 
    private UserLoan userLoan;

    @ManyToMany
    @JoinTable(
        name = "loan_has_laboratory_item",
        joinColumns = @JoinColumn(name = "loan_id_loan"),
        inverseJoinColumns = @JoinColumn(name = "laboratory_item_id_laboratory_item")
    )
    private Set<LaboratoryItem> laboratoryItems;
    


    public Loan() {}

   
    public Loan(long id, LocalDateTime loanDate, LocalDate expectedReturnDate, LocalDateTime returnDate,
            StatusUserAndLoanEnum status, User user, UserLoan userLoan, Set<LaboratoryItem> laboratoryItems) {
        this.id = id;
        this.loanDate = loanDate;
        this.expectedReturnDate = expectedReturnDate;
        this.returnDate = returnDate;
        this.status = status;
        this.user = user;
        this.userLoan = userLoan;
        this.laboratoryItems = laboratoryItems;
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

    public Set<LaboratoryItem> getLaboratoryItems() {
        return laboratoryItems;
    }

    public void setLaboratoryItems(Set<LaboratoryItem> laboratoryItems) {
        this.laboratoryItems = laboratoryItems;
    }

    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }


    public void setExpectedReturnDate(LocalDate expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
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
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Loan other = (Loan) obj;
        return id == other.id;
    }


   
    
}
