package com.backend_inventario.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend_inventario.inventario.entity.LaboratoryItem;
import com.backend_inventario.inventario.entity.dto.ListItemViewDto;
import com.backend_inventario.inventario.repository.LaboratoryItemRepository;
import com.backend_inventario.inventario.repository.ListItemViewRepository;
import com.backend_inventario.inventario.util.ResourceNotFoundException;

@Service
public class LaboratoryItemService {

    @Autowired
    private ListItemViewRepository listItemViewRepository;

    @Autowired
    private LaboratoryItemRepository laboratoryItemRepository;

    public List<ListItemViewDto> dynamicList() {
        return listItemViewRepository.findAll();
    }

    public List<LaboratoryItem> getItemsByName(String nameItem) {
        validateLaboratoryItemExistsByName(nameItem); 
        return laboratoryItemRepository.findAllByNameItem(nameItem);
    }

    public LaboratoryItem getItemById(Long id) {
        return laboratoryItemRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Item não encontrado com ID: " + id));
    }

    public LaboratoryItem createItem(LaboratoryItem laboratoryItem) {
        return laboratoryItemRepository.save(laboratoryItem);
    }

    
    private void validateLaboratoryItemExistsByName(String nameItem) {
        if (!laboratoryItemRepository.existsByNameItem(nameItem)) {
            throw new ResourceNotFoundException("Item não encontrado com o nome: " + nameItem);
        }
    }
}
