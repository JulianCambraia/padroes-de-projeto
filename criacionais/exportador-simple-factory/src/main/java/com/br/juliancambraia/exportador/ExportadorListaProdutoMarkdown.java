package com.br.juliancambraia.exportador;

import com.br.juliancambraia.exportador.entity.Produto;

import java.util.Arrays;

/**
 * Exporta dados de uma lista de {@link Produto} para Markdown (arquivos md).
 *
 * <p>Observe que, como estamos usando o padrão Simple Factory para instanciar
 * objetos {@link ExportadorListaProduto}, as classes concretas como esta são definidas com visibilidade "package",
 * não podendo ser acessadas fora do pacote.
 * Assim, não teremos como instanciar diretamente tais classes.
 * A Simple Factory faz isso pra nós.</p>
 *
 * @author Manoel Campos da Silva Filho
 */
class ExportadorListaProdutoMarkdown extends AbstractExportadorListaProduto {

    @Override
    public String abrirTabela() {
        return "";
    }

    @Override
    public String fecharTabela() {
        return "";
    }

    @Override
    public String abrirLinha() {
        return "";
    }

    @Override
    public String fecharLinha() {
        return "";
    }

    @Override
    public String fecharLinhaTitulos() {
        return gerarColunasLinha(Arrays.asList("-----", "-----", "-----"));
    }

    @Override
    public String abrirColuna(String valor) {
        return "| " + valor;
    }

    @Override
    public String fecharColuna() {
        return "";
    }
}
