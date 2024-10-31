package com.backend_inventario.inventario.entity.Enum;

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
    public String toString() {
        return descricaoPortugues;
    }
}
