package com.backend_inventario.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend_inventario.inventario.entity.Attachment;
import com.backend_inventario.inventario.service.AttachmentService;
import com.backend_inventario.inventario.util.ApiErrorResponse;


@RestController
@RequestMapping("/api/attachment")
public class AttachmentController {
    
    @Autowired
    private AttachmentService attachmentService;


    @GetMapping("/{laboratoryId}")
    public ResponseEntity<Object> getAttachmentsByLaboratoryItemId(@PathVariable Long laboratoryId){
     
        try {
            List<Attachment> attachments = attachmentService.getAttachmentsByLaboratoryItemId(laboratoryId);
            if (attachments.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.ok(attachments);
        }  catch (RuntimeException e) {
            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.NOT_FOUND.value(),
                    "Not Found",
                    e.getMessage(),
                    "/api/attachment/" + laboratoryId);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        } catch (Exception e) {
            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Internal Server Error",
                    "Erro ao buscar os usuários",
                    "/api/attachment");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
       
    }

    

}
