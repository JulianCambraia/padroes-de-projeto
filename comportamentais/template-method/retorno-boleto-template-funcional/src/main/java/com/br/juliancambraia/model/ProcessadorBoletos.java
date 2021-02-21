package com.br.juliancambraia.model;

import com.br.juliancambraia.entity.Boleto;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProcessadorBoletos implements LeituraBoleto {
    public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


    Function<String[], Boleto> processarLinhaArquivo;

    public ProcessadorBoletos(Function<String[], Boleto> processarLinhaArquivo) {
        this.processarLinhaArquivo = processarLinhaArquivo;
    }

    public List<Boleto> processar(String nomeArquivo) {
        try {
            return Files.lines(Paths.get(nomeArquivo), StandardCharsets.ISO_8859_1)
                    .map(line -> processarLinhaArquivo.apply(line.split(";")))
                    .peek(System.out::println)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
