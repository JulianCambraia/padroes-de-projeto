import com.br.juliancambraia.model.LeituraBoleto;
import com.br.juliancambraia.model.ProcessadorBoletos;

public class Principal {
    public static void main(String[] args) {
        ProcessadorBoletos processadorBoletos;
        String nomeArquivo = null;

        processadorBoletos = new ProcessadorBoletos(LeituraBoleto::processarLinhaBancoBrasil);
        nomeArquivo = Principal.class.getResource("banco-do-brasil-1.csv").getPath();
        System.out.println("Lendo arquivo " + nomeArquivo + "\n");
        processadorBoletos.processar(nomeArquivo);

        processadorBoletos = new ProcessadorBoletos(LeituraBoleto::processarLinhaBradesco);
        nomeArquivo = Principal.class.getResource("bradesco-1.csv").getPath();
        System.out.println("Lendo arquivo " + nomeArquivo + "\n");
        processadorBoletos.processar(nomeArquivo);
    }
}
