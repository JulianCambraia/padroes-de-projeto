package com.br.juliancambraia.retornoboletofuncional.negocio;

import com.br.juliancambraia.retornoboletofuncional.entity.Boleto;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Implementação do processamento de arquivos de retorno
 * de boletos bancários usando programação funcional no Java 8+.
 *
 * <p>Esta versão inclui as implementações
 * dos comportamentos, as funções de leitura de arquivos
 * de boleto, todas dentro desta classe estrategista.
 * O ideal seria que tais implementações ficassem
 * uma uma classe separada.
 * Independentemente de tal classe ser criada ou não,
 * como cada implementação está totalmente contida dentro
 * de um único método, uma não interfere na outra
 * e assim não estamos violando o Open/Closed Principle (OCP).
 * </p>
 *
 * @author juliancambraia
 */
public class ProcessarBoletos {

    public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /**
     * {@link Function} que possui a implementação
     * da estratégia para leitura do arquivo de retorno de boleto
     * bancário para um banco específico (como Banco do Brasil, Bradesco, etc).
     */
    private Function<String, List<Boleto>> leituraRetorno;

    public ProcessarBoletos() {
    }


    public ProcessarBoletos(Function<String, List<Boleto>> leituraRetorno) throws IOException {
        this.leituraRetorno = leituraRetorno;
    }

    /**
     * Implementação do comportamento (estratégia)
     * de leitura de arquivos de boleto do Banco do Brasil.
     *
     * @param nomeArquivo
     * @return
     */
    public static List<Boleto> lerArquivoBancoBrasil(String nomeArquivo) {
        List<Boleto> boletos;
        try {
            boletos = Files.lines(Paths.get(nomeArquivo), StandardCharsets.ISO_8859_1)
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
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        return boletos;
    }

    /**
     * Implementação do comportamento (estratégia)
     * de leitura de arquivos de boleto do Bradesco.
     *
     * @param nomeArquivo
     * @return
     */
    public static List<Boleto> lerArquivoBradesco(String nomeArquivo) {
        List<Boleto> boletos;
        try {
            boletos = Files.lines(Paths.get(nomeArquivo), StandardCharsets.ISO_8859_1)
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
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        return boletos;
    }

    public void processar(String nomeArquivo) {
        System.out.println("Boletos:");
        List<Boleto> boletos = leituraRetorno.apply(nomeArquivo);
        boletos.forEach(bol -> {
            System.out.println(bol);
        });
        System.out.println("\n");
    }

    public void setLeituraRetorno(Function<String, List<Boleto>> leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }
}
