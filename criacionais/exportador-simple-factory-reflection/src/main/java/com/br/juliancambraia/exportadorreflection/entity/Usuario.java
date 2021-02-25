package com.br.juliancambraia.exportadorreflection.entity;

import lombok.Data;

@Data
public class Usuario {

    private static int ultimoId = 0;
    private int id;
    private String nome;
    private String cpf;
    private String cidade;

    public Usuario() {
        this.id = ultimoId;
    }

    public Usuario(String nome, String cpf, String cidade) {
        this();
        this.nome = nome;
        this.cpf = cpf;
        this.cidade = cidade;
    }
}
