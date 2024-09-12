package com.backend_inventario.inventario.entity;

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
    @Colum(name = "id_category")
    private long id;
    
    @Colum(name = "title_category")
    private String title ;

    @Colum(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "laboratory_item_id_laboratory_item")
    private laboratory_item laboratory_item;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public laboratory_item getLaboratory_item() {
        return laboratory_item;
    }

    public void setLaboratory_item(laboratory_item laboratory_item) {
        this.laboratory_item = laboratory_item;
    }

    public Category(long id, String title, String description,
            com.backend_inventario.inventario.entity.laboratory_item laboratory_item) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.laboratory_item = laboratory_item;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((laboratory_item == null) ? 0 : laboratory_item.hashCode());
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
        if (id != other.id)
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (laboratory_item == null) {
            if (other.laboratory_item != null)
                return false;
        } else if (!laboratory_item.equals(other.laboratory_item))
            return false;
        return true;
    }

    

}
