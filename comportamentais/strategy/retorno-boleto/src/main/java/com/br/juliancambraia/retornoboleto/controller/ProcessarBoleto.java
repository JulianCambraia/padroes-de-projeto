package com.br.juliancambraia.retornoboleto.controller;

import com.br.juliancambraia.retornoboleto.entity.Boleto;
import com.br.juliancambraia.retornoboleto.model.LeituraRetorno;

import java.io.IOException;
import java.util.List;

/**
 * Classe estrategista
 *
 * @author juliancambraia
 */
public class ProcessarBoleto {

    private LeituraRetorno leituraRetorno;

    /**
     * Instancia em tempo de execução a classe estrategista, já indicando qual estrategia usar
     */
    public ProcessarBoleto() {

    }

    /**
     * Instancia a classe estrategista, já indicando qual estrategia usar
     *
     * @param leituraRetorno
     */
    public ProcessarBoleto(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }

    /**
     * Realiza de fato o processamento de um dado arquivo de retorno de boleto bancário,
     * utilizando uma estratégia definida em {@link #leituraRetorno}.
     * Este método pode realizar diversas operações após a leitura do arquivo,
     * como gravar dados em um banco, enviar emails de notificação, etc.
     * Neste caso, por simplificação, estamos apenas imprimindo os dados no terminal.
     *
     * @param nomeArquivo Nome do arquivo a ser lido
     */
    public void processar(String nomeArquivo) throws IOException {
        System.out.println("Boletos ");
        System.out.println("----------------------------------------------------------------------------------------------");
        List<Boleto> boletos = leituraRetorno.lerArquivo(nomeArquivo);
        boletos.forEach(System.out::println);
    }

    public void setLeituraRetorno(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }
}
