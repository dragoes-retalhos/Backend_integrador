package com.backend_inventario.inventario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend_inventario.inventario.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Long>{
   
    List<Attachment> findByLaboratoryItemId(Long laboratoryItemId);
}
