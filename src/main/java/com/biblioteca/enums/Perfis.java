package com.biblioteca.enums;

public enum Perfis {
    ADMINISTRADOR("Administrador"),
    FUNCIONARIO("Funcionario"),
    GERENTE("Gerente");

    private String descricao;

    Perfis(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }
}
