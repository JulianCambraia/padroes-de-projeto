package com.br.juliancambraia.strategytemplatemethod.model;

import com.br.juliancambraia.strategytemplatemethod.entity.Boleto;

import java.time.LocalDate;

public class LeituraRetornoBancoDoBrasil implements LeituraRetorno {
    @Override
    public Boleto processarLinhaArquivo(String[] vetorLinhaArq) {
        Boleto boleto = new Boleto();
        boleto.setId(Integer.parseInt(vetorLinhaArq[0]));
        boleto.setCodBanco(vetorLinhaArq[1]);
        boleto.setDataVencimento(LocalDate.parse(vetorLinhaArq[2], ProcessadorBoletos.FORMATO_DATA));
        boleto.setDataPagamento(LocalDate.parse(vetorLinhaArq[3], ProcessadorBoletos.FORMATO_DATA).atTime(0, 0, 0));
        boleto.setCpfCliente(vetorLinhaArq[4]);
        boleto.setValor(Double.parseDouble(vetorLinhaArq[5]));
        boleto.setMulta(Double.parseDouble(vetorLinhaArq[6]));
        boleto.setJuros(Double.parseDouble(vetorLinhaArq[7]));
        return boleto;
    }
}
