package com.backend_inventario.inventario.entity.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "list_items")
public class ListItemViewDto {

    @Id 
    private String nameItem;
    private Long amount;
    private String description;

    public ListItemViewDto() {
    }

    public ListItemViewDto(String nameItem, Long amount, String description) {
        this.nameItem = nameItem;
        this.amount = amount;
        this.description = description;
    }

    public String getNameItem() {
        return nameItem;
    }

    public Long getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

}
