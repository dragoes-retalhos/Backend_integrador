package com.backend_inventario.inventario.entity.Enum;

public enum TypeUserLoanEnum {
    
    TEACHER("PROFESSOR"),
    STUDENT("ALUNO"),
    ENTERPRISE("EMPRESA");

    private final String descricaoPortugues;

    TypeUserLoanEnum(String descricaoPortugues) {
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
