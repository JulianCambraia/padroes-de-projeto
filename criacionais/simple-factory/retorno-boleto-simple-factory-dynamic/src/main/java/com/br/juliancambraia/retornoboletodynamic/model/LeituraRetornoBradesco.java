package com.br.juliancambraia.retornoboletodynamic.model;

import com.br.juliancambraia.retornoboletodynamic.entity.Boleto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LeituraRetornoBradesco implements LeituraRetorno {
    @Override
    public Boleto processarLinhaArquivo(String[] vetor) {
        return new Boleto(
                Integer.parseInt(vetor[0])
                , vetor[1]
                , vetor[2]
                , vetor[3]
                , LocalDate.parse(vetor[4], FORMATO_DATA)
                , LocalDateTime.parse(vetor[5], FORMATO_DATA_HORA)
                , vetor[6]
                , Double.parseDouble(vetor[7])
                , Double.parseDouble(vetor[8])
                , Double.parseDouble(vetor[9])
        );
    }
}
