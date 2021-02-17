package com.br.juliancambraia.retornoboleto.model;

import com.br.juliancambraia.retornoboleto.entity.Boleto;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Realiza a leitura de arquivos de retorno de boletos bancários no formato do Banco do Brasil.
 * Esta classe usa o padrão Strategy, representando a implementação da estratégia {@link LeituraRetorno}.
 *
 * @author juliancambraia
 */
public class LeituraRetornoBancoBrasil implements LeituraRetorno {

    @Override
    public List<Boleto> lerArquivo(String nomeArquivo) throws IOException {
        return Files.lines(Paths.get(nomeArquivo), StandardCharsets.ISO_8859_1)
                .map(linha -> linha.split(";"))
                .map(arr -> new Boleto(
                        Integer.parseInt(arr[0])
                        , arr[1]
                        , LocalDate.parse(arr[2], FORMATO_DATA)
                        , LocalDate.parse(arr[3], FORMATO_DATA).atTime(0, 0, 0)
                        , arr[4]
                        , Double.parseDouble(arr[5])
                        , Double.parseDouble(arr[6])
                        , Double.parseDouble(arr[7])
                )).collect(Collectors.toList());

    }
}
