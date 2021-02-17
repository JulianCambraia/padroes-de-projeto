import com.br.juliancambraia.retornoboleto.controller.ProcessarBoleto;
import com.br.juliancambraia.retornoboleto.model.LeituraRetornoBancoBrasil;
import com.br.juliancambraia.retornoboleto.model.LeituraRetornoBradesco;

import java.io.IOException;

public class AppArquivoRetornoBoleto {

    public static void main(String[] args) throws IOException {
        ProcessarBoleto processarBoleto = new ProcessarBoleto();

        String nomeArquivoBrasil = AppArquivoRetornoBoleto.class.getResource("banco-do-brasil-1.csv").getPath();
        processarBoleto.setLeituraRetorno(new LeituraRetornoBancoBrasil());
        System.out.println("Lendo arquivo " + nomeArquivoBrasil + "\n");
        processarBoleto.processar(nomeArquivoBrasil);

        String nomeArquivoBradesco = AppArquivoRetornoBoleto.class.getResource("bradesco-1.csv").getPath();
        processarBoleto.setLeituraRetorno(new LeituraRetornoBradesco());
        System.out.println("Lendo arquivo " + nomeArquivoBradesco + "\n");
        processarBoleto.processar(nomeArquivoBradesco);

    }
}
