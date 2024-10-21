package com.backend_inventario.inventario.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.backend_inventario.inventario.entity.Enum.MainetenceTypeEnum;
import com.backend_inventario.inventario.entity.Enum.StatusMaintenanceEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "maintenance")
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_maintenance", nullable = false)
    @NotNull
    private Long id;

    @Column(name = "maintenance_type", nullable = true)
    @Enumerated(EnumType.ORDINAL)
    private MainetenceTypeEnum maintenanceType;

    @Column(name = "description", length = 1000, nullable = true)
    private String description;

    @Column(name = "status", nullable = true)
    @Enumerated(EnumType.ORDINAL)
    private StatusMaintenanceEnum statusMaintenance;

    @Column(name = "cost", precision = 10, scale = 2)
    private BigDecimal cost;

    @Column(name = "creation_date", nullable = true)
    private LocalDateTime creationDate;

    @Column(name = "delivery_date", nullable = true)
    private LocalDate deliveryDate;

    @ManyToOne
    @JoinColumn(name = "laboratory_item_id_laboratory_item_heritage", nullable = false) 
    @NotNull
    private LaboratoryItem laboratoryItem;

    @OneToMany(mappedBy = "maintenance")
    @JsonIgnore
    private List<Attachment> attachments;

    public Maintenance() {

    }

    public Maintenance(@NotNull Long id, MainetenceTypeEnum maintenanceType, String description, StatusMaintenanceEnum statusMaintenance, BigDecimal cost,
            LocalDateTime creationDate, LocalDate deliveryDate, @NotNull LaboratoryItem laboratoryItem,
            List<Attachment> attachments) {
        this.id = id;
        this.maintenanceType = maintenanceType;
        this.description = description;
        this.statusMaintenance = statusMaintenance;
        this.cost = cost;
        this.creationDate = creationDate;
        this.deliveryDate = deliveryDate;
        this.laboratoryItem = laboratoryItem;
        this.attachments = attachments;
    }

    public Long getIdMaintenance() {
        return id;
    }

    public void setIdMaintenance(Long id) {
        this.id = id;
    }

    public MainetenceTypeEnum getMaintenanceType() {
        return maintenanceType;
    }

    public void setMaintenanceType(MainetenceTypeEnum maintenanceType) {
        this.maintenanceType = maintenanceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   
    public void setStatus(StatusMaintenanceEnum statusMaintenance) {
        this.statusMaintenance = statusMaintenance;
    }
    

   
    public StatusMaintenanceEnum getStatusMaintenance() {
        return statusMaintenance;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
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

    public void setLaboratoryItem(LaboratoryItem laboratoryItem) {
        this.laboratoryItem = laboratoryItem;
    }

    public LaboratoryItem getLaboratoryItem() {
        return laboratoryItem;
    }

    public List<Attachment> getAttachments() {
        return attachments;
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
        Maintenance other = (Maintenance) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}