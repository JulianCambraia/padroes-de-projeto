import com.br.juliancambraia.strategytemplatemethod.model.LeituraRetornoBancoDoBrasil;
import com.br.juliancambraia.strategytemplatemethod.model.LeituraRetornoBradesco;
import com.br.juliancambraia.strategytemplatemethod.model.ProcessadorBoletos;

public class Principal {

    public static void main(String[] args) {
        ProcessadorBoletos processador = null;
        String nomeArquivoBrasil = Principal.class.getResource("banco-do-brasil-1.csv").getPath();
        processador = new ProcessadorBoletos(new LeituraRetornoBancoDoBrasil());
        System.out.println("Lendo arquivo " + nomeArquivoBrasil + "\n");
        processador.processar(nomeArquivoBrasil).forEach(System.out::println);

        //
        String nomeArquivoBradesco = Principal.class.getResource("bradesco-1.csv").getPath();
        System.out.println("Lendo arquivo " + nomeArquivoBradesco + "\n");
        processador = new ProcessadorBoletos(new LeituraRetornoBradesco());
        processador.processar(nomeArquivoBradesco).forEach(System.out::println);
        ;
    }
}
