package com.br.juliancambraia.retornoboleto.model;

import com.br.juliancambraia.retornoboleto.entidade.Boleto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe que compõe a implementação do padrão Template Method,
 * contendo método que representa um passo do template
 * na superclasse.
 *
 * @author juliancambraia
 */
public class LeituraRetornoBradesco extends ProcessadorBoletos {
    @Override
    protected List<Boleto> processarLinhaArquivo(List<String[]> vetorLinhaArquivo) {
        return vetorLinhaArquivo.stream().map(arr -> new Boleto(
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
