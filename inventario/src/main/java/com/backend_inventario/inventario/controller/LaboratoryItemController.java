package com.backend_inventario.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend_inventario.inventario.entity.LaboratoryItem;
import com.backend_inventario.inventario.entity.dto.ListItemViewDto;
import com.backend_inventario.inventario.service.LaboratoryItemService;
import com.backend_inventario.inventario.util.ApiErrorResponse;

@RestController
@RequestMapping("/api/item")
public class LaboratoryItemController {

    @Autowired
    private LaboratoryItemService laboratoryItemService;

  
    @GetMapping ("/dynamiclist")
    public ResponseEntity<Object> dynamicList(){
        try {
            List<ListItemViewDto> listItem  = laboratoryItemService.dynamicList();
            if (listItem.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.ok(listItem);
        } catch (Exception e) {
            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Internal Server Error",
                    "Erro ao buscar itens",
                    "/api/item/dynamiclist");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }

    }

    @GetMapping("/by-name/{nameItem}")
    public ResponseEntity<Object> getItemsByName(@PathVariable String nameItem){

        if (nameItem == null || nameItem.isEmpty()) {
            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.BAD_REQUEST.value(),
                    "Bad Request",
                    "O nome do item não pode ser nulo ou vazio.",
                    "/api/item/" + nameItem);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }

        try {
            List <LaboratoryItem> items = laboratoryItemService.getItemsByName(nameItem);
            return ResponseEntity.ok(items);
        } catch (RuntimeException e) {
            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.NOT_FOUND.value(),
                    "Not Found",
                    e.getMessage(),
                    "/api/item/" + nameItem);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);

        } catch (Exception e) {
            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Internal Server Error",
                    "Erro ao buscar o usuário",
                    "/api/item/" + nameItem);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getItemById(@PathVariable Long id){
        
        if (id == null || id.isEmpty()) {
            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.BAD_REQUEST.value(),
                    "Bad Request",
                    "O id do item não pode ser nulo ou vazio.",
                    "/api/item/" + id);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }

       
       
        try {
            LaboratoryItem laboratoryItem = laboratoryItemService.getItemByid(id);
            return ResponseEntity.ok(laboratoryItem);
        } catch (RuntimeException e) {
            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.NOT_FOUND.value(),
                    "Not Found",
                    e.getMessage(),
                    "/api/item/" + id);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);

        } catch (Exception e) {
            ApiErrorResponse errorResponse = new ApiErrorResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Internal Server Error",
                    "Erro ao buscar o iten",
                    "/api/item/" + id);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }



}    
