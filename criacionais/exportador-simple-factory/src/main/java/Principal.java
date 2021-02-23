import com.br.juliancambraia.exportador.ExportadorListaProduto;
import com.br.juliancambraia.exportador.entity.Produto;

import java.util.Arrays;
import java.util.List;

/**
 * Classe Cliente que Executa a aplicação Exportador Simple Factory.
 * Note que a chamada é feita na Interface a classe cliente aqui representada pela Principal não conhece as subclasses
 * que definem formatos específicos de exportação de dados
 *
 * @author juliancambraia
 */
public class Principal {
    public static void main(String[] args) {
        List<Produto> produtos = Arrays.asList(new Produto(1, "TV", 1000),
                new Produto(2, "Geladeira", 900),
                new Produto(3, "Notebook", 3200)
        );

        ExportadorListaProduto exportador = ExportadorListaProduto.newInstance();
        System.out.println(exportador.exportar(produtos));
    }
}
