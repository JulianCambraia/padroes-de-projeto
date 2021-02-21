package com.br.juliancambraia.model;

import com.br.juliancambraia.entity.Boleto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface LeituraBoleto {

    static Boleto processarLinhaBancoBrasil(String[] linhaArquivo) {
        return new Boleto(
                Integer.parseInt(linhaArquivo[0])
                , linhaArquivo[1]
                , LocalDate.parse(linhaArquivo[2], ProcessadorBoletos.FORMATO_DATA)
                , LocalDate.parse(linhaArquivo[3], ProcessadorBoletos.FORMATO_DATA).atTime(0, 0, 0)
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
                , LocalDate.parse(linhaArquivo[4], ProcessadorBoletos.FORMATO_DATA)
                , LocalDateTime.parse(linhaArquivo[5], ProcessadorBoletos.FORMATO_DATA_HORA)
                , linhaArquivo[6]
                , Double.parseDouble(linhaArquivo[7])
                , Double.parseDouble(linhaArquivo[8])
                , Double.parseDouble(linhaArquivo[9]));
    }
}
