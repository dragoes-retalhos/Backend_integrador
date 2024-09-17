package com.backend_inventario.inventario.entity;

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
@Table(name = "attachment")
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_attachment;
    
    @Column(name = "name_attachment")
    private String nameAttachment;
    
    @Column(name = "path_attachment")
    private String pathAttachment;
    
    @Column(name = "type_attachment")
    private String typeAttachment;
    
    @Column(name = "size_attachment")
    private Long sizeAttachment;
    
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "laboratory_item_id_laboratory_item_heritage")
    private LaboratoryItem LaboratoryItemIdLaboratoryItemHeritage;

    public Attachment() {
    }

    public Attachment(Long id_attachment, String nameAttachment, String pathAttachment, String typeAttachment,
            Long sizeAttachment, LocalDateTime creationDate, String description,
            LaboratoryItem laboratoryItemIdLaboratoryItemHeritage) {
        this.id_attachment = id_attachment;
        this.nameAttachment = nameAttachment;
        this.pathAttachment = pathAttachment;
        this.typeAttachment = typeAttachment;
        this.sizeAttachment = sizeAttachment;
        this.creationDate = creationDate;
        this.description = description;
        LaboratoryItemIdLaboratoryItemHeritage = laboratoryItemIdLaboratoryItemHeritage;
    }

    public Long getId_attachment() {
        return id_attachment;
    }

    public void setId_attachment(Long id_attachment) {
        this.id_attachment = id_attachment;
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

    public LaboratoryItem getLaboratoryItemIdLaboratoryItemHeritage() {
        return LaboratoryItemIdLaboratoryItemHeritage;
    }

    public void setLaboratoryItemIdLaboratoryItemHeritage(LaboratoryItem laboratoryItemIdLaboratoryItemHeritage) {
        LaboratoryItemIdLaboratoryItemHeritage = laboratoryItemIdLaboratoryItemHeritage;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_attachment == null) ? 0 : id_attachment.hashCode());
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
        if (id_attachment == null) {
            if (other.id_attachment != null)
                return false;
        } else if (!id_attachment.equals(other.id_attachment))
            return false;
        return true;
    }

    

}
