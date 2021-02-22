import com.br.juliancambraia.retornoboletossimplefactory.model.ProcessarBoleto;

public class Principal {
    public static void main(String[] args) {
        String nomeArquivo = null;

        ProcessarBoleto processarBoletos = new ProcessarBoleto();

        nomeArquivo = Principal.class.getResource("banco-do-brasil-1.csv").getPath();
        System.out.println("Lendo arquivo " + nomeArquivo + "\n");
        processarBoletos.processar(nomeArquivo);

        nomeArquivo = Principal.class.getResource("bradesco-1.csv").getPath();
        System.out.println("Lendo arquivo " + nomeArquivo + "\n");
        processarBoletos.processar(nomeArquivo);
    }
}
