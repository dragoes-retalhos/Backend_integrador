package com.backend_inventario.inventario.entity.Enum;

public enum StatusMaintenanceEnum {

    PENDING("PENDENTE"),
    PROCEEDING("EM ANDAMENTO"),
    COMPLETED("CONCLUÍDA");

    private final String descricaoPortugues;

    StatusMaintenanceEnum(String descricaoPortugues) {
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
