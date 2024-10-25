package com.backend_inventario.inventario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend_inventario.inventario.entity.Maintenance;
import com.backend_inventario.inventario.entity.dto.MaintenanceDTO;
import com.backend_inventario.inventario.repository.LaboratoryItemRepository;
import com.backend_inventario.inventario.repository.MaintenanceRepository;
import com.backend_inventario.inventario.util.ResourceNotFoundException;

@Service
public class MaintenanceService {
    
    @Autowired
    private MaintenanceRepository maintenanceRepository;

    @Autowired
    private LaboratoryItemRepository laboratoryItemRepository;

    public List<Maintenance> getAttachmentsByLaboratoryItemId(Long laboratoryItemId) {
        validateLaboratoryItemExists(laboratoryItemId); 
        return maintenanceRepository.findByLaboratoryItemId(laboratoryItemId);
    }

    public Maintenance createMaintenance(Maintenance maintenance) {
        validateLaboratoryItemExists(maintenance.getLaboratoryItem().getId()); 
        return maintenanceRepository.save(maintenance);
    }

    @Transactional
    public Maintenance updateMaintenance(Long maintenanceId, MaintenanceDTO maintenanceDTO) {
        Maintenance maintenance = maintenanceRepository.findById(maintenanceId)
            .orElseThrow(() -> new ResourceNotFoundException("Manutenção não encontrada com o ID: " + maintenanceId));

        updateFields(maintenance, maintenanceDTO);
        return maintenanceRepository.save(maintenance);
    }


    private void validateLaboratoryItemExists(Long laboratoryItemId) {
        if (!laboratoryItemRepository.existsById(laboratoryItemId)) {
            throw new ResourceNotFoundException("Item não encontrado com ID: " + laboratoryItemId);
        }
    }

    private void updateFields(Maintenance maintenance, MaintenanceDTO dto) {
        Optional.ofNullable(dto.getStatusMaintenance())
                .ifPresent(maintenance::setStatusMaintenance);
        
        Optional.ofNullable(dto.getCost())
                .ifPresent(maintenance::setCost);
        
        Optional.ofNullable(dto.getDescription())
                .ifPresent(maintenance::setDescription);
    }
}
