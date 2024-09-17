package com.backend_inventario.inventario.entity;

import java.time.LocalDate;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "laboratory_item")
public class LaboratoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_laboratory_item_heritage")
    private Long idLaboratoryItemHeritage;

    @Column(name = "name_item")
    private String nameItem;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "invoice_number")
    private String invoiceNumber;

    @Column(name = "entry_date")
    private LocalDate entryDate;

    @Column(name = "next_calibration")
    private LocalDate  nextCalibration;

    @ManyToAny
    @JoinColumn(name = "maintenance_id_maintenance")
    private Maintenance maintenanceIdMaintenance;

    public LaboratoryItem(){

    }

    public LaboratoryItem(Long idLaboratoryItemHeritage, String nameItem, String brand, String model,
            String serialNumber, String invoiceNumber, LocalDate entryDate, LocalDate nextCalibration,
            Maintenance maintenanceIdMaintenance) {
        this.idLaboratoryItemHeritage = idLaboratoryItemHeritage;
        this.nameItem = nameItem;
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
        this.invoiceNumber = invoiceNumber;
        this.entryDate = entryDate;
        this.nextCalibration = nextCalibration;
        this.maintenanceIdMaintenance = maintenanceIdMaintenance;
    }

    public Long getIdLaboratoryItemHeritage() {
        return idLaboratoryItemHeritage;
    }

    public void setIdLaboratoryItemHeritage(Long idLaboratoryItemHeritage) {
        this.idLaboratoryItemHeritage = idLaboratoryItemHeritage;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDate getNextCalibration() {
        return nextCalibration;
    }

    public void setNextCalibration(LocalDate nextCalibration) {
        this.nextCalibration = nextCalibration;
    }

    public Maintenance getMaintenanceIdMaintenance() {
        return maintenanceIdMaintenance;
    }

    public void setMaintenanceIdMaintenance(Maintenance maintenanceIdMaintenance) {
        this.maintenanceIdMaintenance = maintenanceIdMaintenance;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idLaboratoryItemHeritage == null) ? 0 : idLaboratoryItemHeritage.hashCode());
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
        LaboratoryItem other = (LaboratoryItem) obj;
        if (idLaboratoryItemHeritage == null) {
            if (other.idLaboratoryItemHeritage != null)
                return false;
        } else if (!idLaboratoryItemHeritage.equals(other.idLaboratoryItemHeritage))
            return false;
        return true;
    }

    

    

        

}
