package com.br.juliancambraia.exportador;

import com.br.juliancambraia.exportador.entity.Produto;

import java.util.List;

public interface ExportadorListaProduto {

    String abrirTabela();

    String fecharTabela();

    String abrirLinha();

    String fecharLinha();

    String fecharLinhaTitulos();

    String abrirColuna(String valor);

    String fecharColuna();

    String exportar(List<Produto> listaProdutos);

    ExportadorListaProduto newInstance();

    ExportadorListaProduto newInstance(String extensaoArquivoExportacao);
}
