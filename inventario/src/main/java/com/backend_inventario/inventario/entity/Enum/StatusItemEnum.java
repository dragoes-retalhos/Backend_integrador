package com.backend_inventario.inventario.entity.Enum;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusItemEnum {

    ACTIVE("ATIVO"),
    INACTIVE("INATIVO"),
    MAINTENANCE("MANUTENÇÃO"),
    UNAVAILABLE("INDISPONÍVEL");

    private final String descricaoPortugues;

    StatusItemEnum(String descricaoPortugues) {
        this.descricaoPortugues = descricaoPortugues;
    }

    @Override
    @JsonValue
    public String toString() {
        return descricaoPortugues;
    }
}
