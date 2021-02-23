package com.br.juliancambraia.exportador;

import com.br.juliancambraia.exportador.entity.Produto;

import java.util.Arrays;
import java.util.List;

/**
 * Classe abstrata que fornece uma implementação base para as subclasses
 * que definem formatos específicos de exportação de dados.
 *
 * @author juliancambraia
 */
public abstract class AbstractExportadorListaProduto implements ExportadorListaProduto {

    /**
     * Colunas a serem exibidas na tabela gerada no processo de exportação.
     */
    protected static final List<String> TITULOS_COLUNAS = Arrays.asList("Código", "Descrição", "Valor");

    @Override
    public final String exportar(List<Produto> listaProdutos) {
        StringBuilder sb = new StringBuilder();

        sb.append(abrirTabela());

        sb.append(gerarColunasLinha(TITULOS_COLUNAS));
        sb.append(fecharLinhaTitulos());

        gerarLinhasProdutos(sb, listaProdutos);

        sb.append(fecharTabela());

        return sb.toString();
    }

    /**
     * Gera o texto representando todas as linhas de uma tabela (em um formato definido pelas subclasses)
     * contendo os dados dos produtos na lista de produtos.
     *
     * @param sb            {@link StringBuilder} onde o texto gerado será adicionado
     * @param listaProdutos
     */
    private void gerarLinhasProdutos(StringBuilder sb, List<Produto> listaProdutos) {
        listaProdutos.forEach(produto -> {
            List<String> valores = Arrays.asList(
                    String.valueOf(produto.getId()),
                    produto.getNome(),
                    String.valueOf(produto.getValor())
            );
            sb.append(gerarColunasLinha(valores));
        });
    }

    /**
     * Gera o texto representando uma única linha de uma tabela (em um formato definido pelas subclasses).
     *
     * @param valores valores a serem exibidos nas colunas, que podem ser:
     *                (i) os títulos das colunas (caso esteja sendo gerada a linha de cabeçalho da tabela) ou
     *                (ii) os valores de uma linha da tabela (caso esteja sendo gerado uma linha de conteúdo da tabela).
     *                Neste último caso, tal parâmetro deve conter os valores dos atributos de um objeto da lista de produtos.
     * @return uma String representando a linha gerada com os valores
     */
    protected String gerarColunasLinha(List<String> valores) {
        StringBuilder sb = new StringBuilder();
        sb.append(abrirLinha());
        valores.forEach(titulo -> {
            sb.append(abrirColuna(titulo));
            sb.append(fecharColuna());
        });
        sb.append(fecharLinha());
        sb.append("\n");
        return sb.toString();
    }
}
