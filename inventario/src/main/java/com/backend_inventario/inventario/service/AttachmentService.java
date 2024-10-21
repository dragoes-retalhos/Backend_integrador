package com.backend_inventario.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend_inventario.inventario.entity.Attachment;
import com.backend_inventario.inventario.repository.AttachmentRepository;
import com.backend_inventario.inventario.repository.LaboratoryItemRepository;

@Service
public class AttachmentService {
    
    @Autowired
    private AttachmentRepository attachmentRepository;

    @Autowired
    private LaboratoryItemRepository laboratoryItemRepository;

    public List<Attachment> getAttachmentsByLaboratoryItemId(Long laboratoryItemId) {

        if(!laboratoryItemRepository.existsById(laboratoryItemId)){
            throw new RuntimeException("Item nao encontrado");
        }

        return attachmentRepository.findByLaboratoryItemId(laboratoryItemId);
    }

    
}
