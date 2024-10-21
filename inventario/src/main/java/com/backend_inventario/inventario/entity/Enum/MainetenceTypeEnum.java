package com.backend_inventario.inventario.entity.Enum;

public enum MainetenceTypeEnum {
    
    PREVENTIVE("PREVENTIVA"),
    CORRECTIVE("CORRETIVA");

    
    private final String descricaoPortugues;

    MainetenceTypeEnum(String descricaoPortugues) {
        this.descricaoPortugues = descricaoPortugues;
    }

    @Override
    public String toString() {
        return descricaoPortugues;
    }
}
