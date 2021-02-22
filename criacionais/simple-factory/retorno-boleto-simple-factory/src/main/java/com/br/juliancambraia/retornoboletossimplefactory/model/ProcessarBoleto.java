package com.br.juliancambraia.retornoboletossimplefactory.model;

import com.br.juliancambraia.retornoboletossimplefactory.entity.Boleto;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProcessarBoleto {

    public void processar(String nomeArquivo) {
        Function<String[], Boleto> processarLinhaArquivo = EstrategiaBoletoFacotry.newStrategy(nomeArquivo);

        try {
            Files.lines(Paths.get(nomeArquivo), StandardCharsets.ISO_8859_1)
                    .map(line -> processarLinhaArquivo.apply(line.split(";")))
                    .peek(System.out::println)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

    }
}
