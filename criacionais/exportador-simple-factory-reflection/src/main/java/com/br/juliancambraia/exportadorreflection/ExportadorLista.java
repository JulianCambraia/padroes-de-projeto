package com.br.juliancambraia.exportadorreflection;

import java.util.List;

public interface ExportadorLista {

    String abrirTabela();

    String fecharTabela();

    String abrirLinha();

    String fecharLinha();

    String fecharLinhaTitulos();

    String abrirColuna(String valor);

    String fecharColuna();

    String exportar(List<?> lista);

    List<String> getNomesCampos();

    static ExportadorLista newInstance() {
        return newInstance("html");
    }

    static ExportadorLista newInstance(String extensaoArquivoExporta) {
        switch (extensaoArquivoExporta) {
            case "html":
                return new ExportadorListaHtml();
            case "md":
                return new ExportadorListaMarkdown();
            default:
                throw new UnsupportedOperationException("Formato de arquivo não suportado: " + extensaoArquivoExporta);
        }
    }
}
