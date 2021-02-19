package com.br.juliancambraia.retornoboleto.model;

import com.br.juliancambraia.retornoboleto.entidade.Boleto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe que compõe a implementação do padrão Template Method,
 * contendo método que representa um passo do template
 * na superclasse.
 *
 * @author juliancambraia
 */
public class LeituraRetornoBancoBrasil extends ProcessadorBoletos {
    @Override
    protected List<Boleto> processarLinhaArquivo(List<String[]> vetorLinhaArquivo) {
        return vetorLinhaArquivo.stream().map(arr -> new Boleto(
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
