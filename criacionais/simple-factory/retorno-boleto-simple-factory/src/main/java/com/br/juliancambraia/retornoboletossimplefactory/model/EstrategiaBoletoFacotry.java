package com.br.juliancambraia.retornoboletossimplefactory.model;

import com.br.juliancambraia.retornoboletossimplefactory.entity.Boleto;

import java.util.function.Function;

public class EstrategiaBoletoFacotry {

    private static Function<String[], Boleto> estrategia;

    private EstrategiaBoletoFacotry() {

    }

    static Function<String[], Boleto> newStrategy(String nomeArquivo) {
        if (nomeArquivo.contains("banco-do-brasil")) {
            estrategia = LeituraBoleto::processarLinhaBancoBrasil;
        } else if (nomeArquivo.contains("bradesco")) {
            estrategia = LeituraBoleto::processarLinhaBradesco;
        } else
            throw new UnsupportedOperationException("Banco não identificado ou não suportado para o arquivo " + nomeArquivo);

        return estrategia;
    }
}
