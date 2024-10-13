package com.backend_inventario.inventario.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.backend_inventario.inventario.entity.LaboratoryItem;

public interface LaboratoryItemRepository extends JpaRepository <LaboratoryItem, Long> {
    
    boolean existsByNameItem(String nameItem);
    
    List<LaboratoryItem> findByNameItem(String nameItem);

}
