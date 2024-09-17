package com.backend_inventario.inventario.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_category;

    @Column(name = "title_category")
    private String titleCategory;
    
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "laboratory_item_id_laboratory_item")
    private LaboratoryItem LaboratoryItemIdLaboratoryItem;

    public Category() {
    }

    public Category(Long id_category, String titleCategory, String description,
            LaboratoryItem laboratoryItemIdLaboratoryItem) {
        this.id_category = id_category;
        this.titleCategory = titleCategory;
        this.description = description;
        LaboratoryItemIdLaboratoryItem = laboratoryItemIdLaboratoryItem;
    }

    public Long getId_category() {
        return id_category;
    }

    public void setId_category(Long id_category) {
        this.id_category = id_category;
    }

    public String getTitleCategory() {
        return titleCategory;
    }

    public void setTitleCategory(String titleCategory) {
        this.titleCategory = titleCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        result = prime * result + ((id_category == null) ? 0 : id_category.hashCode());
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
        Category other = (Category) obj;
        if (id_category == null) {
            if (other.id_category != null)
                return false;
        } else if (!id_category.equals(other.id_category))
            return false;
        return true;
    }

    
}
