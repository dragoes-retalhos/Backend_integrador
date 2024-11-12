package com.backend_inventario.inventario.entity.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.backend_inventario.inventario.entity.Enum.StatusUserAndLoanEnum;

public class ListLoanByItemDto {

    private Long id;
    private LocalDateTime loanDate;
    private LocalDate expectedReturnDate;
    private LocalDateTime returnDate;
    private StatusUserAndLoanEnum status;
    private String nameUser;

    public ListLoanByItemDto() {
    }

  

    



    public ListLoanByItemDto(Long id, LocalDateTime loanDate, LocalDate expectedReturnDate, LocalDateTime returnDate,
            StatusUserAndLoanEnum status, String nameUser) {
        this.id = id;
        this.loanDate = loanDate;
        this.expectedReturnDate = expectedReturnDate;
        this.returnDate = returnDate;
        this.status = status;
        this.nameUser = nameUser;
    }







    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
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
        ListLoanByItemDto other = (ListLoanByItemDto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

   
}
