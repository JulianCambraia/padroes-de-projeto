import com.br.juliancambraia.retornoboletodynamic.model.ProcessarBoletos;

/**
 * Executa a aplicação para ler um arquivo de
 * retorno de boleto e imprimir no terminal.
 *
 * @author juliancambraia
 */
public class Principal {
    public static void main(String[] args) {
        /*Tente carregar o arquivo "itau-1.csv" e veja que,
         * como não existe uma classe para ler o formato de arquivos do
         * banco Itaú, ocorrerá uma exceção informando isto.*/
        String nomeArquivo = Principal.class.getResource("bradesco-1.csv").getPath();
        ProcessarBoletos processador = new ProcessarBoletos();
        processador.processar(nomeArquivo);
    }
}
