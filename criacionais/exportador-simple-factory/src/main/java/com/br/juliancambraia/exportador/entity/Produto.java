package com.br.juliancambraia.exportador.entity;

import lombok.Data;

@Data
public class Produto {
    private long id;
    private String nome;
    private double valor;

    public Produto(long id, String nome, double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }
}
