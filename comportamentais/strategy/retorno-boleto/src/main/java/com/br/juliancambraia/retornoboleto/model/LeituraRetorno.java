package com.br.juliancambraia.retornoboleto.model;

import com.br.juliancambraia.retornoboleto.entity.Boleto;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Define um contrato para implementação de estratégias
 * de leitura de arquivos de retorno de bancos brasileiros (como Banco do Brasil e Bradesco).
 *
 * @author juliancambraia
 */
public interface LeituraRetorno {
    DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    List<Boleto> lerArquivo(String nomeArquivo) throws IOException;
}
