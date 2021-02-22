package com.br.juliancambraia.retornoboletossimplefactory.model;

import com.br.juliancambraia.retornoboletossimplefactory.entity.Boleto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface LeituraBoleto {

    DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    static Boleto processarLinhaBancoBrasil(String[] linhaArquivo) {
        return new Boleto(
                Integer.parseInt(linhaArquivo[0])
                , linhaArquivo[1]
                , LocalDate.parse(linhaArquivo[2], FORMATO_DATA)
                , LocalDate.parse(linhaArquivo[3], FORMATO_DATA).atTime(0, 0, 0)
                , linhaArquivo[4]
                , Double.parseDouble(linhaArquivo[5])
                , Double.parseDouble(linhaArquivo[6])
                , Double.parseDouble(linhaArquivo[7])
        );
    }

    static Boleto processarLinhaBradesco(String[] linhaArquivo) {
        return new Boleto(
                Integer.parseInt(linhaArquivo[0])
                , linhaArquivo[1]
                , linhaArquivo[2]
                , linhaArquivo[3]
                , LocalDate.parse(linhaArquivo[4], FORMATO_DATA)
                , LocalDateTime.parse(linhaArquivo[5], FORMATO_DATA_HORA)
                , linhaArquivo[6]
                , Double.parseDouble(linhaArquivo[7])
                , Double.parseDouble(linhaArquivo[8])
                , Double.parseDouble(linhaArquivo[9]));
    }
}
