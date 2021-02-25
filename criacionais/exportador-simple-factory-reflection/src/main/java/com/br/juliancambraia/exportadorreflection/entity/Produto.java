package com.br.juliancambraia.exportadorreflection.entity;

import lombok.Data;

@Data
public class Produto {

    private static int ultimoId = 0;
    private long id;
    private String nome;
    private double valor;

    public Produto() {
        this.id = ultimoId;
    }

    public Produto(String nome, double valor) {
        this();
        this.nome = nome;
        this.valor = valor;
    }
}
