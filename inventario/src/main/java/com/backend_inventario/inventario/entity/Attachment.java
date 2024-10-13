package com.backend_inventario.inventario.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "attachment")
public class Attachment {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_attachment", nullable = false)
    private Long id;
    
    @Column(name = "name_attachment", nullable = true)
    private String nameAttachment;
    
    @Column(name = "path_attachment", nullable = true)
    private String pathAttachment;
    
    @Column(name = "type_attachment", nullable = true)
    private String typeAttachment;
    
    @Column(name = "size_attachment", nullable = true)
    private Long sizeAttachment;
    
    @Column(name = "creation_date", nullable = true)
    private LocalDateTime creationDate;
    
    @Column(name = "description", nullable = true)
    private String description;

    @ManyToOne
    @JoinColumn(name = "laboratory_item_id_laboratory_item_heritage", nullable = true)
    @JsonBackReference
    private LaboratoryItem laboratoryItem;

    @ManyToOne
    @JoinColumn(name = "maintenance_id_maintenance", nullable = true) 
    @JsonBackReference
    private Maintenance maintenance;

    public Attachment() {
        
    }

    public Attachment(Long id, String nameAttachment, String pathAttachment, String typeAttachment,
            Long sizeAttachment, LocalDateTime creationDate, String description,
            LaboratoryItem laboratoryItem) {
        this.id = id;
        this.nameAttachment = nameAttachment;
        this.pathAttachment = pathAttachment;
        this.typeAttachment = typeAttachment;
        this.sizeAttachment = sizeAttachment;
        this.creationDate = creationDate;
        this.description = description;
        this.laboratoryItem = laboratoryItem;
    }

    public Long getId_attachment() {
        return id;
    }

    public void setId_attachment(Long id) {
        this.id = id;
    }

    public String getNameAttachment() {
        return nameAttachment;
    }

    public void setNameAttachment(String nameAttachment) {
        this.nameAttachment = nameAttachment;
    }

    public String getPathAttachment() {
        return pathAttachment;
    }

    public void setPathAttachment(String pathAttachment) {
        this.pathAttachment = pathAttachment;
    }

    public String getTypeAttachment() {
        return typeAttachment;
    }

    public void setTypeAttachment(String typeAttachment) {
        this.typeAttachment = typeAttachment;
    }

    public Long getSizeAttachment() {
        return sizeAttachment;
    }

    public void setSizeAttachment(Long sizeAttachment) {
        this.sizeAttachment = sizeAttachment;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

  

    public LaboratoryItem getLaboratoryItem() {
        return laboratoryItem;
    }

    public void setLaboratoryItem(LaboratoryItem laboratoryItem) {
        this.laboratoryItem = laboratoryItem;
    }

    public Maintenance getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(Maintenance maintenance) {
        this.maintenance = maintenance;
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
        Attachment other = (Attachment) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


}
