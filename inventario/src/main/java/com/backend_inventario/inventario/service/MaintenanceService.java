package com.backend_inventario.inventario.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend_inventario.inventario.entity.Maintenance;
import com.backend_inventario.inventario.repository.LaboratoryItemRepository;
import com.backend_inventario.inventario.repository.MaintenanceRepository;

@Service
public class MaintenanceService {
    
    @Autowired
    private MaintenanceRepository maintenanceRepository;

    @Autowired
    private LaboratoryItemRepository laboratoryItemRepository;

    public List<Maintenance> getAttachmentsByLaboratoryItemId(Long laboratoryItemId) {

        if(!laboratoryItemRepository.existsById(laboratoryItemId)){
            throw new RuntimeException("Item nao encontrado");
        }

        return maintenanceRepository.findByLaboratoryItemId(laboratoryItemId);
    }
}
