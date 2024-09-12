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
    private LocalDateTime loan_date;

    @Column(name = "return_date")
    private LocalDateTime return_date;

    @Column(name = "status")
    private int status;

    @ManyToOne
    @JoinColumn(name = "user_id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "user_loan_iduser_loan")
    private UserLoan userLoan;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getLoan_date() {
        return loan_date;
    }

    public void setLoan_date(LocalDateTime loan_date) {
        this.loan_date = loan_date;
    }

    public LocalDateTime getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDateTime return_date) {
        this.return_date = return_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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

    public Loan(long id, LocalDateTime loan_date, LocalDateTime return_date, int status, User user, UserLoan userLoan) {
        this.id = id;
        this.loan_date = loan_date;
        this.return_date = return_date;
        this.status = status;
        this.user = user;
        this.userLoan = userLoan;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((loan_date == null) ? 0 : loan_date.hashCode());
        result = prime * result + ((return_date == null) ? 0 : return_date.hashCode());
        result = prime * result + status;
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        result = prime * result + ((userLoan == null) ? 0 : userLoan.hashCode());
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
        if (loan_date == null) {
            if (other.loan_date != null)
                return false;
        } else if (!loan_date.equals(other.loan_date))
            return false;
        if (return_date == null) {
            if (other.return_date != null)
                return false;
        } else if (!return_date.equals(other.return_date))
            return false;
        if (status != other.status)
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        if (userLoan == null) {
            if (other.userLoan != null)
                return false;
        } else if (!userLoan.equals(other.userLoan))
            return false;
        return true;
    }

    
}
