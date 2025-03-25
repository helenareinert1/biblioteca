package com.biblioteca.dtos;

public class LivroDTO {
    private Long id;
    private String nome;
    private String ano;
    private String editora;

    public LivroDTO(Long id, String nome, String ano, String editora) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.editora = editora;
    }

    public LivroDTO(){}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getAno() {
        return ano;
    }
    public void setAno(String ano) {
        this.ano = ano;
    }
    public String getEditora() {
        return editora;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }
}
