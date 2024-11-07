package com.backend_inventario.inventario.entity.Enum;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MaintenanceTypeEnum {
    
    PREVENTIVE("PREVENTIVA"),
    CORRECTIVE("CORRETIVA");

    
    private final String descricaoPortugues;

    MaintenanceTypeEnum(String descricaoPortugues) {
        this.descricaoPortugues = descricaoPortugues;
    }

    @Override
    @JsonValue
    public String toString() {
        return descricaoPortugues;
    }
}
