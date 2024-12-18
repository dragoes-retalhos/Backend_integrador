package com.backend_inventario.inventario.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_location", nullable = false)
    private Long idLocation;

    @Column(name = "building", nullable = false)
    private String building;

    @Column(name = "room", nullable = false)
    private String room;

    @ManyToOne
    @JoinColumn(name = "laboratory_item_id_laboratory_item")
    private LaboratoryItem LaboratoryItem;

    public Location() {
    }

    public Location(Long idLocation, String building, String room, LaboratoryItem LaboratoryItem) {
        this.idLocation = idLocation;
        this.building = building;
        this.room = room;
        this.LaboratoryItem = LaboratoryItem;
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

    public LaboratoryItem getAssociatedLaboratoryItem() {
        return LaboratoryItem;
    }

    public void setAssociatedLaboratoryItem(LaboratoryItem LaboratoryItem) {
        this.LaboratoryItem = LaboratoryItem;
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