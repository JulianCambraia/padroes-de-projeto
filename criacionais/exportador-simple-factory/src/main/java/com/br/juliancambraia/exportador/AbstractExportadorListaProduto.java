package com.br.juliancambraia.exportador;

import com.br.juliancambraia.exportador.entity.Produto;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractExportadorListaProduto implements ExportadorListaProduto {

    protected static final List<String> TITULOS_COLUNAS = Arrays.asList("Código", "Descrição", "Valor");

    @Override
    public final String exportar(List<Produto> listaProdutos) {
        StringBuilder sb = new StringBuilder();

        sb.append(abrirTabela());

        gerarColunasLinha(sb, TITULOS_COLUNAS);

        gerarLinhasProdutos(sb, listaProdutos);

        sb.append(fecharTabela());

        return sb.toString();
    }

    private void gerarLinhasProdutos(StringBuilder sb, List<Produto> listaProdutos) {
        listaProdutos.forEach(produto -> {
            List<String> valores = Arrays.asList(
                    String.valueOf(produto.getId()),
                    produto.getNome(),
                    String.valueOf(produto.getValor())
            );
            gerarColunasLinha(sb, valores);
        });
    }

    private void gerarColunasLinha(StringBuilder sb, List<String> titulosColunas) {
        sb.append(abrirLinha());
        TITULOS_COLUNAS.forEach(titulo -> {
            sb.append(abrirColuna(titulo));
            sb.append(fecharColuna());
        });
        sb.append(fecharLinha());
    }
}
