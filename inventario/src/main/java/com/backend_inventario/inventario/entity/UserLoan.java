package com.backend_inventario.inventario.entity;

import java.util.List;

import com.backend_inventario.inventario.entity.Enum.StatusUserAndLoanEnum;
import com.backend_inventario.inventario.entity.Enum.TypeUserLoanEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "user_loan")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserLoan {

    @Id
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

    @Column(name = "identification", unique = true)
    private String identification;

    @Column(name = "phone", unique = true, nullable = false)
    private String phone;

    @Column(name = "status")
    private StatusUserAndLoanEnum statusUserEnum;

    @Column(name = "type_user")
    private TypeUserLoanEnum typeUserLoanEnum;

    @OneToMany(mappedBy = "userLoan")
    @JsonIgnoreProperties
    private List<Loan> loans;


    public UserLoan() {}

    public UserLoan(Long id){
        this.id = id;
    }
    public UserLoan(@NotNull long id, String name, String email, String rna, String enterprise, String identification,
                    String phone, StatusUserAndLoanEnum statusUserEnum, TypeUserLoanEnum typeUserLoanEnum) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.rna = rna; //aluno
        this.enterprise = enterprise; //empresa
        this.identification = identification; //chacha
        this.phone = phone;
        this.statusUserEnum = statusUserEnum;
        this.typeUserLoanEnum = typeUserLoanEnum;
    }


    @PrePersist
    protected void initializeStatus() {
        if (statusUserEnum == null) {
            statusUserEnum = StatusUserAndLoanEnum.ACTIVE;
        }
    }


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

    public StatusUserAndLoanEnum getStatusUserEnum() {
        return statusUserEnum;
    }

    public void setStatusUserEnum(StatusUserAndLoanEnum statusUserEnum) {
        this.statusUserEnum = statusUserEnum;
    }

    public TypeUserLoanEnum getTypeUserLoanEnum() {
        return typeUserLoanEnum;
    }

    public void setTypeUserLoanEnum(TypeUserLoanEnum typeUserLoanEnum) {
        this.typeUserLoanEnum = typeUserLoanEnum;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
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
        UserLoan other = (UserLoan) obj;
        return id == other.id;
    }

}
