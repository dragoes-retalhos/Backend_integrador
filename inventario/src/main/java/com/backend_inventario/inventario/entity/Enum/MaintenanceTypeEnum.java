package com.backend_inventario.inventario.entity.Enum;

public enum MaintenanceTypeEnum {
    
    PREVENTIVE("PREVENTIVA"),
    CORRECTIVE("CORRETIVA");

    
    private final String descricaoPortugues;

    MaintenanceTypeEnum(String descricaoPortugues) {
        this.descricaoPortugues = descricaoPortugues;
    }

    @Override
    public String toString() {
        return descricaoPortugues;
    }
}
