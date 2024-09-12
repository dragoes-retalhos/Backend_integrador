package com.backend_inventario.inventario.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "laboratory_item")
public class LaborattoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Colum(name = "id_laboratory_item_heritage")
    private long id;

    @Colum(name = "name_item")
    private String name;

    @Colum(name = "brand")
    private String brand;

    @Colum(name = "model")
    private String model;

    @Colum(name = "serial_number")
    private long serial_number;  

    @Colum(name = "invoice_number")
    private long invoice_number;

    @Colum(name = "entry_date")
    private LocalDate entry_date;

    @Colum(name = "next_calibration")
    private LocalDate next_calibration;

    @OneToMany
    @JoinColumn(name = "maintenance_id_maintenance")
    private maintenance maintenance;

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

    public long getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(long serial_number) {
        this.serial_number = serial_number;
    }

    public long getInvoice_number() {
        return invoice_number;
    }

    public void setInvoice_number(long invoice_number) {
        this.invoice_number = invoice_number;
    }

    public LocalDate getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(LocalDate entry_date) {
        this.entry_date = entry_date;
    }

    public LocalDate getNext_calibration() {
        return next_calibration;
    }

    public void setNext_calibration(LocalDate next_calibration) {
        this.next_calibration = next_calibration;
    }

    public maintenance getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(maintenance maintenance) {
        this.maintenance = maintenance;
    }

    public LaborattoryItem(long id, String name, String brand, String model, long serial_number, long invoice_number,
            LocalDate entry_date, LocalDate next_calibration,
            com.backend_inventario.inventario.entity.maintenance maintenance) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.serial_number = serial_number;
        this.invoice_number = invoice_number;
        this.entry_date = entry_date;
        this.next_calibration = next_calibration;
        this.maintenance = maintenance;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((brand == null) ? 0 : brand.hashCode());
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + (int) (serial_number ^ (serial_number >>> 32));
        result = prime * result + (int) (invoice_number ^ (invoice_number >>> 32));
        result = prime * result + ((entry_date == null) ? 0 : entry_date.hashCode());
        result = prime * result + ((next_calibration == null) ? 0 : next_calibration.hashCode());
        result = prime * result + ((maintenance == null) ? 0 : maintenance.hashCode());
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
        LaborattoryItem other = (LaborattoryItem) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (brand == null) {
            if (other.brand != null)
                return false;
        } else if (!brand.equals(other.brand))
            return false;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        if (serial_number != other.serial_number)
            return false;
        if (invoice_number != other.invoice_number)
            return false;
        if (entry_date == null) {
            if (other.entry_date != null)
                return false;
        } else if (!entry_date.equals(other.entry_date))
            return false;
        if (next_calibration == null) {
            if (other.next_calibration != null)
                return false;
        } else if (!next_calibration.equals(other.next_calibration))
            return false;
        if (maintenance == null) {
            if (other.maintenance != null)
                return false;
        } else if (!maintenance.equals(other.maintenance))
            return false;
        return true;
    }

    
}
