package com.backend_inventario.inventario.entity.dto;

import java.util.Date;

import com.backend_inventario.inventario.entity.Enum.StatusUserAndLoanEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loan_summary")
public class LoanSumaryViewDto {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private Long id;
    @Column(name = "loan_status")
    private StatusUserAndLoanEnum status;
    @Column(name = "return_date")
    private Date returnDate;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "loaned_items")
    private String loanedItems;
   
    public LoanSumaryViewDto(){
        
    }
    
   
    public LoanSumaryViewDto(Long id, StatusUserAndLoanEnum status, Date returnDate, String userName,
            String loanedItems) {
        this.id = id;
        this.status = status;
        this.returnDate = returnDate;
        this.userName = userName;
        this.loanedItems = loanedItems;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public StatusUserAndLoanEnum getStatus() {
        return status;
    }
    public void setStatus(StatusUserAndLoanEnum status) {
        this.status = status;
    }
    public Date getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getLoanedItems() {
        return loanedItems;
    }
    public void setLoanedItems(String loanedItems) {
        this.loanedItems = loanedItems;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        LoanSumaryViewDto other = (LoanSumaryViewDto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


    
    
}
