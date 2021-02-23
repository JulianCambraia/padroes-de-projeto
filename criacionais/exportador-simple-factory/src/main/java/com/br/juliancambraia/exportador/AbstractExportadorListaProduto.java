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
        sb.append(abrirLinha());
        TITULOS_COLUNAS.forEach(titulo -> {
            sb.append(abrirColuna(titulo));
            sb.append(fecharColuna());
        });
        sb.append(fecharLinha());
        sb.append(fecharTabela());

        listaProdutos.forEach(produto -> {
            sb.append(abrirLinha());
            sb.append(abrirColuna(String.valueOf(produto.getId())));
            sb.append(fecharLinha());
            sb.append(abrirColuna(produto.getNome()));
            sb.append(fecharLinha());
            sb.append(abrirColuna(String.valueOf(produto.getValor())));
            sb.append(fecharColuna());
        });


        return sb.toString();
    }
}
