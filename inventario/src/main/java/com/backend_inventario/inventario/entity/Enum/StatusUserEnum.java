package com.backend_inventario.inventario.entity.Enum;

public enum StatusUserEnum {
    
    ACTIVE("ATIVO"),
    DISABLED("DESATIVADO");

    private final String descricaoPortugues;

    StatusUserEnum(String descricaoPortugues) {
        this.descricaoPortugues = descricaoPortugues;
    }

    @Override
    public String toString() {
        return descricaoPortugues;
    }

    public String getDescricaoPortugues() {
        return descricaoPortugues;
    }
    
}
