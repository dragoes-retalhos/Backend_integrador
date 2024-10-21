package com.backend_inventario.inventario.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.backend_inventario.inventario.entity.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Long>{
    

    List<Maintenance> findByLaboratoryItemId(Long laboratoryItemId);
}
