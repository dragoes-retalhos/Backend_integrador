package com.backend_inventario.inventario.entity.Enum;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusUserAndLoanEnum {
    
    ACTIVE("ATIVO"),
    DISABLED("DESATIVADO");

    private final String descricaoPortugues;

    StatusUserAndLoanEnum(String descricaoPortugues) {
        this.descricaoPortugues = descricaoPortugues;
    }

    @Override
    @JsonValue
    public String toString() {
        return descricaoPortugues;
    }

    public String getDescricaoPortugues() {
        return descricaoPortugues;
    }
    
}
