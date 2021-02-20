package com.br.juliancambraia.strategytemplatemethod.model;

import com.br.juliancambraia.strategytemplatemethod.entity.Boleto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LeituraRetornoBradesco implements LeituraRetorno {
    @Override
    public Boleto processarLinhaArquivo(String[] arr) {
        return new Boleto(
                Integer.parseInt(arr[0])
                , arr[1]
                , arr[2]
                , arr[3]
                , LocalDate.parse(arr[4], ProcessadorBoletos.FORMATO_DATA)
                , LocalDateTime.parse(arr[5], ProcessadorBoletos.FORMATO_DATA_HORA)
                , arr[6]
                , Double.parseDouble(arr[7])
                , Double.parseDouble(arr[8])
                , Double.parseDouble(arr[9])
        );
    }
}
