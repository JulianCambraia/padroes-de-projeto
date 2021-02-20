package com.br.juliancambraia.strategytemplatemethod.model;

import com.br.juliancambraia.strategytemplatemethod.entity.Boleto;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessadorBoletos {

    public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    LeituraRetorno leituraRetorno;

    public ProcessadorBoletos(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }

    public final List<Boleto> processar(String nomeArquivo) {
        try {
            return Files.lines(Paths.get(nomeArquivo), StandardCharsets.ISO_8859_1)
                    .map(line -> leituraRetorno.processarLinhaArquivo(line.split(";"))).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
