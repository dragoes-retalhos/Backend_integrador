package com.backend_inventario.inventario.service;

import java.util.List;
import java.util.stream.Collectors;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend_inventario.inventario.entity.LaboratoryItem;
import com.backend_inventario.inventario.entity.dto.ListItemViewDto;
import com.backend_inventario.inventario.repository.LaboratoryItemRepository;
import com.backend_inventario.inventario.repository.ListItemViewRepository;

@Service
public class LaboratoryItemService {

    @Autowired
    private ListItemViewRepository listItemViewRepository;

    @Autowired
    private LaboratoryItemRepository laboratoryItemRepository;

    public List <ListItemViewDto> dynamicList(){
        return listItemViewRepository.findAll();
    }


    public List<LaboratoryItem> getItemsByName(String nameItem) {
        if (!laboratoryItemRepository.existsByNameItem(nameItem)) {
            throw new RuntimeException("Item não encontrado");
        }

        // Filtra e retorna a lista de itens únicos
        return laboratoryItemRepository.findByNameItem(nameItem).stream()
                .distinct() // Filtra duplicatas
                .collect(Collectors.toList());
    }


    public LaboratoryItem getItemByid(Long id){
        
        if(!laboratoryItemRepository.existsById(id)){
            throw new RuntimeException("Item não encontrado");
        }

        Optional <LaboratoryItem> laboratoryItemOptional = laboratoryItemRepository.findById(id);
        return laboratoryItemOptional.orElse(null);
    }

}