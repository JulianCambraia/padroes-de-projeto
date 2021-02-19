import com.br.juliancambraia.retornoboleto.model.LeituraRetornoBancoBrasil;
import com.br.juliancambraia.retornoboleto.model.LeituraRetornoBradesco;
import com.br.juliancambraia.retornoboleto.model.ProcessadorBoletos;

public class Principal {

    public static void main(String[] args) {
        String nomeArquivoBrasil = Principal.class.getResource("banco-do-brasil-1.csv").getPath();
        ProcessadorBoletos processadorBoletosBB = new LeituraRetornoBancoBrasil();
        System.out.println("Lendo arquivo " + nomeArquivoBrasil + "\n");
        processadorBoletosBB.processar(nomeArquivoBrasil).forEach(System.out::println);
        //
        String nomeArquivoBradesco = Principal.class.getResource("bradesco-1.csv").getPath();
        System.out.println("Lendo arquivo " + nomeArquivoBradesco + "\n");
        ProcessadorBoletos processadorBoletosBradesco = new LeituraRetornoBradesco();
        processadorBoletosBradesco.processar(nomeArquivoBradesco).forEach(System.out::println);
        ;
    }
}
