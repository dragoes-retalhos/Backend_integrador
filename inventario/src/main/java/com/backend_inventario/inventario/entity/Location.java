package com.backend_inventario.inventario.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocation;

    @Column(name = "building")
    private String building;

    @Column(name = "room")
    private String room;

    @JoinColumn(name = "laboratory_item_id_laboratory_item")
    private LaboratoryItem LaboratoryItemIdLaboratoryItem;

    public Location() {
    }

    public Location(Long idLocation, String building, String room, LaboratoryItem laboratoryItemIdLaboratoryItem) {
        this.idLocation = idLocation;
        this.building = building;
        this.room = room;
        LaboratoryItemIdLaboratoryItem = laboratoryItemIdLaboratoryItem;
    }

    public Long getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Long idLocation) {
        this.idLocation = idLocation;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public LaboratoryItem getLaboratoryItemIdLaboratoryItem() {
        return LaboratoryItemIdLaboratoryItem;
    }

    public void setLaboratoryItemIdLaboratoryItem(LaboratoryItem laboratoryItemIdLaboratoryItem) {
        LaboratoryItemIdLaboratoryItem = laboratoryItemIdLaboratoryItem;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idLocation == null) ? 0 : idLocation.hashCode());
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
        Location other = (Location) obj;
        if (idLocation == null) {
            if (other.idLocation != null)
                return false;
        } else if (!idLocation.equals(other.idLocation))
            return false;
        return true;
    }

    
}
