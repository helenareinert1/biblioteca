package com.biblioteca.dtos;

import java.util.Date;

public class ReservaDTO {
    private Long id;
    private Date data;
    private String hora_inicio;
    private String hora_fim;
    private String descricao;
    private String categoria;
    private String codigo;
    private Boolean status;
    private CompradorDTO comprador;

    public ReservaDTO() {
    }

    public ReservaDTO(Long id, Date data, String hora_inicio,
                      String hora_fim, String descricao, String categoria, String codigo, Boolean status, CompradorDTO comprador) {
        this.id = id;
        this.data = data;
        this.hora_inicio = hora_inicio;
        this.hora_fim = hora_fim;
        this.descricao = descricao;
        this.categoria = categoria;
        this.codigo = codigo;
        this.status = status;
        this.comprador = comprador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_fim() {
        return hora_fim;
    }

    public void setHora_fim(String hora_fim) {
        this.hora_fim = hora_fim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public CompradorDTO getComprador() {
        return comprador;
    }

    public void setComprador(CompradorDTO comprador) {
        this.comprador = comprador;
    }
}
