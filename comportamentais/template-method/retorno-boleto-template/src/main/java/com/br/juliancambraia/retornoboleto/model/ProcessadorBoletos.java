package com.br.juliancambraia.retornoboleto.model;

import com.br.juliancambraia.retornoboleto.entidade.Boleto;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe abstrata que implementa o padrão Template Method
 * para a leitura de arquivos de retorno de boletos bancários.
 *
 * @author juliancambraia
 */
public abstract class ProcessadorBoletos {
    public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /**
     * Processa uma lista de arquivos de retorno de boleto bancário
     * e imprime o resultado no terminal (mas poderia fazer qualquer outra coisa como gravar em um banco de dados,
     * gerar um PDF, enviar um email com confirmação de pagamento do boleto para o cliente, etc).
     *
     * <p>Este é o chamado Template Method,
     * que representa um algoritmo, cujo um ou mais passos
     * são métodos abstratos definidos nas subclasses.</p>
     *
     * @param nomeArquivo Nome do arquivo a ser processado
     */
    public final List<Boleto> processar(String nomeArquivo) {
        List<String[]> vetorLinhaArquivo = null;
        try {
            vetorLinhaArquivo = Files.lines(Paths.get(nomeArquivo), StandardCharsets.ISO_8859_1)
                    .map(linha -> linha.split(";")).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return processarLinhaArquivo(vetorLinhaArquivo);
    }

    /**
     * Recebe um vetor com os dados lidos de uma linha de um arquivo
     * de retorno de boleto
     *
     * @param vetorLinhaArquivo vetor contendo os dados de uma linha lida do arquivo,
     *                          onde cada posição representa uma coluna do boleto
     * @return um objeto {@link Boleto} com os dados processados da linha do arquivo
     */
    protected abstract List<Boleto> processarLinhaArquivo(List<String[]> vetorLinhaArquivo);

}
