package com.backend_inventario.inventario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.backend_inventario.inventario.entity.LaboratoryItem;

public interface LaboratoryItemRepository extends JpaRepository <LaboratoryItem, Long> {
    
    boolean existsByNameItem(String nameItem);


    @Query("SELECT li FROM LaboratoryItem li WHERE li.nameItem = :nameItem")
    List<LaboratoryItem> findAllByNameItem(@Param("nameItem") String nameItem);

    
    
}
    
    

