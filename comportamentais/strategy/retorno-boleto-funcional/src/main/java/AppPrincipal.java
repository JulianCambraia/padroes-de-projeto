import com.br.juliancambraia.retornoboletofuncional.negocio.ProcessarBoletos;

import java.io.IOException;

/**
 * Executa a aplicação para ler vários arquivos de
 * retorno de boleto e imprimir no terminal.
 *
 * @author juliancambraia
 */
public class AppPrincipal {

    public static void main(String[] args) throws IOException {
        ProcessarBoletos processarBoletos = new ProcessarBoletos();

        processarBoletos.setLeituraRetorno(ProcessarBoletos::lerArquivoBancoBrasil);
        String nomeArquivoBrasil = AppPrincipal.class.getResource("banco-do-brasil-1.csv").getPath();
        System.out.println("Lendo arquivo " + nomeArquivoBrasil + "\n");
        processarBoletos.processar(nomeArquivoBrasil);

        processarBoletos.setLeituraRetorno(ProcessarBoletos::lerArquivoBradesco);
        String nomeArquivoBradesco = AppPrincipal.class.getResource("bradesco-1.csv").getPath();
        processarBoletos.processar(nomeArquivoBradesco);

        // para leitura de um único arquivo - chamando o construtor com parâmetros
        // ProcessarBoletos processador = new ProcessarBoletos(ProcessarBoletos::lerArquivoBancoBrasil);
    }
}
