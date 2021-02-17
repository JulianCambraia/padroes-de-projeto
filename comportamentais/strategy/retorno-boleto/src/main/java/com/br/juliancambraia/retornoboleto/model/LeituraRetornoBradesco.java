package com.br.juliancambraia.retornoboleto.model;

import com.br.juliancambraia.retornoboleto.entity.Boleto;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Realiza a leitura de arquivos de retorno de boletos bancários no formato do Banco Bradesco.
 * Esta classe usa o padrão Strategy, representando a implementação da estratégia {@link LeituraRetorno}.
 *
 * @author juliancambraia
 */
public class LeituraRetornoBradesco implements LeituraRetorno {
    @Override
    public List<Boleto> lerArquivo(String nomeArquivo) throws IOException {

        return Files.lines(Paths.get(nomeArquivo), StandardCharsets.ISO_8859_1)
                .map(linha -> linha.split(";"))
                .map(arr -> new Boleto(
                        Integer.parseInt(arr[0])
                        , arr[1]
                        , arr[2]
                        , arr[3]
                        , LocalDate.parse(arr[4], FORMATO_DATA)
                        , LocalDateTime.parse(arr[5], FORMATO_DATA_HORA)
                        , arr[6]
                        , Double.parseDouble(arr[7])
                        , Double.parseDouble(arr[8])
                        , Double.parseDouble(arr[9])
                )).collect(Collectors.toList());
    }
}
