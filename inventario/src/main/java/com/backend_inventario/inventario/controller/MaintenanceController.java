package com.backend_inventario.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend_inventario.inventario.entity.Maintenance;
import com.backend_inventario.inventario.service.MaintenanceService;
import com.backend_inventario.inventario.util.ApiErrorResponse;

@RestController
@RequestMapping("/api/maintenance")
public class MaintenanceController {
    
    @Autowired
    private MaintenanceService maintenanceService;


    @GetMapping("/{laboratoryId}")
    public ResponseEntity<Object> getMaintenanceByLaboratoryItemId(@PathVariable Long laboratoryId){
     
        try {
            List<Maintenance> maintenanceList = maintenanceService.getAttachmentsByLaboratoryItemId(laboratoryId);
            if (maintenanceList.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.ok(maintenanceList);
        }  catch (RuntimeException e) {
            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.NOT_FOUND.value(),
                    "Not Found",
                    e.getMessage(),
                    "/api/maintenance/" + laboratoryId);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        } catch (Exception e) {
            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Internal Server Error",
                    "Erro ao buscar os usuários",
                    "/api/maintenance/");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
       
    }

}
