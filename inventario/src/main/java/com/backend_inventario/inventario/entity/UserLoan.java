package com.backend_inventario.inventario.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "user_loan")
public class UserLoan {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser_loan", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @Column(name = "rna", unique = true)
    private String rna;
    
    @Column(name = "enterprise")
    private String enterprise;
    
    @Column(name = "identification", unique = true, nullable = true)
    private String identification;
    
    @Column(name = "phone", unique = true, nullable = false)
    private String phone;
    /* 
    @Column(name = "Status")
    private Status status;
*/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRna() {
        return rna;
    }

    public void setRna(String rna) {
        this.rna = rna;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

   
    public UserLoan() {
        
    }

    public UserLoan(long id, String name, String email, String rna, String enterprise, String identification,
            String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.rna = rna;
        this.enterprise = enterprise;
        this.identification = identification;
        this.phone = phone;
       
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
        UserLoan other = (UserLoan) obj;
        if (id != other.id)
            return false;
        return true;
    }


    
}
