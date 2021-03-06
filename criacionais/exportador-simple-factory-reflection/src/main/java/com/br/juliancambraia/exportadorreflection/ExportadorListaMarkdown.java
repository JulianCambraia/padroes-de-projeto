package com.br.juliancambraia.exportadorreflection;


/**
 * Exporta dados de uma lista de {@link Object} para Markdown (arquivos md).
 *
 * <p>Observe que, como estamos usando o padrão Simple Factory para instanciar
 * objetos {@link ExportadorLista}, as classes concretas como esta são definidas com visibilidade "package",
 * não podendo ser acessadas fora do pacote.
 * Assim, não teremos como instanciar diretamente tais classes.
 * A Simple Factory faz isso pra nós.</p>
 *
 * @author Manoel Campos da Silva Filho
 */
class ExportadorListaMarkdown extends AbstractExportadorLista {

    private static final String SEPARADOR_LN = "-";
    private static final String SEPARADOR_COL = "|";

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
        StringBuilder sb = new StringBuilder();
        for (String column : getNomesCampos()) {
            String linha = stringRepeat(SEPARADOR_LN, column.length());
            sb.append(linha).append(SEPARADOR_COL);
        }
        sb.append("\n");
        return sb.toString();
    }

    private String stringRepeat(String s, int repeticoes) {
        return String.format("%0" + repeticoes + "d", 0).replace("0", s);
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
