package com.backend_inventario.inventario.entity;

import java.time.LocalDate;
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
@Table(name = "maintenance")
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_maintenance")
    private Long idMaintenance;

    @Column(name = "maintenance_type")
    private Long maintenanceType;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "status")
    private Integer status;
    
    @Column(name = "cost")
    private double cost;
    
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    
    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    @ManyToOne
    @JoinColumn(name = "attachment_id_attachment")
    private Attachment associatedAttachment;


    public Maintenance (){

    }


    public Maintenance(Long idMaintenance, Long maintenanceType, String description, Integer status, double cost,
            LocalDateTime creationDate, LocalDate deliveryDate, Attachment associatedAttachment) {
        this.idMaintenance = idMaintenance;
        this.maintenanceType = maintenanceType;
        this.description = description;
        this.status = status;
        this.cost = cost;
        this.creationDate = creationDate;
        this.deliveryDate = deliveryDate;
        this.associatedAttachment = associatedAttachment;
    }


    public Long getIdMaintenance() {
        return idMaintenance;
    }


    public void setIdMaintenance(Long idMaintenance) {
        this.idMaintenance = idMaintenance;
    }


    public Long getMaintenanceType() {
        return maintenanceType;
    }


    public void setMaintenanceType(Long maintenanceType) {
        this.maintenanceType = maintenanceType;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public Integer getStatus() {
        return status;
    }


    public void setStatus(Integer status) {
        this.status = status;
    }


    public double getCost() {
        return cost;
    }


    public void setCost(double cost) {
        this.cost = cost;
    }


    public LocalDateTime getCreationDate() {
        return creationDate;
    }


    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }


    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }


    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }


    public Attachment getAssociatedAttachment() {
        return associatedAttachment;
    }


    public void setAssociatedAttachment(Attachment associatedAttachment) {
        this.associatedAttachment = associatedAttachment;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idMaintenance == null) ? 0 : idMaintenance.hashCode());
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
        Maintenance other = (Maintenance) obj;
        if (idMaintenance == null) {
            if (other.idMaintenance != null)
                return false;
        } else if (!idMaintenance.equals(other.idMaintenance))
            return false;
        return true;
    } 

    

}