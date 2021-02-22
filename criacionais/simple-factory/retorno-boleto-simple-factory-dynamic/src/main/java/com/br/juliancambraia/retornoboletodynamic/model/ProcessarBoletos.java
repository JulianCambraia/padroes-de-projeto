package com.br.juliancambraia.retornoboletodynamic.model;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * Processa arquivos de retorno de boletos bancários.
 * É utilizada uma versão da Simple Factory {@link EstrategiaBoletoFactory}
 * que descobre automaticamente qual a classe de estratégia será utilizada,
 * de acordo com o nome do arquivo a ser processado.
 *
 * @author juliancambraia
 */
public class ProcessarBoletos {
    public void processar(String nomeArquivo) {
        LeituraRetorno estrategia = EstrategiaBoletoFactory.newStrategy(nomeArquivo);
        System.out.println("Utilizando a classe " + estrategia.getClass().getSimpleName() + " para ler arquivo " + nomeArquivo + "\n");
        try {
            Files.lines(Paths.get(nomeArquivo), StandardCharsets.ISO_8859_1)
                    .map(line -> estrategia.processarLinhaArquivo(line.split(";")))
                    .peek(System.out::println)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
