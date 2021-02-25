package com.br.juliancambraia.exportadorreflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractExportadorLista implements ExportadorLista {
    private List<?> lista;
    private List<String> nomesCampos;

    @Override
    public String exportar(List<?> lista) {
        Objects.requireNonNull(lista);
        if (lista.isEmpty()) {
            throw new IllegalArgumentException("A Lista fornecida está vazia");
        }

        this.lista = lista;
        this.nomesCampos = gerarTitulosColunas();

        final StringBuilder sb = new StringBuilder();
        sb.append(abrirTabela());

        gerarColunasLinha(sb, nomesCampos);
        sb.append(fecharLinhaTitulos());
        gerarLinhasObjetos(sb);

        sb.append(fecharTabela());
        return sb.toString();
    }

    private List<String> gerarTitulosColunas() {
        Object objeto = lista.get(0);
        List<String> titulosColunas = new ArrayList<>();

        Field[] campos = objeto.getClass().getDeclaredFields();
        for (Field campo : campos) {
            if (!Modifier.isStatic(campo.getModifiers())) {
                titulosColunas.add(campo.getName());
            }
        }
        return titulosColunas;
    }

    private void gerarLinhasObjetos(StringBuilder sb) {
        for (Object objeto : lista) {
            gerarLinhaObjeto(sb, objeto);
        }
    }

    private void gerarLinhaObjeto(StringBuilder sb, Object objeto) {
        List<String> valoresCamposObjeto = new ArrayList<>();
        nomesCampos.forEach(campo -> {
            String valorCampo = getValorCampoObjeto(objeto, campo);
            valoresCamposObjeto.add(String.valueOf(String.valueOf(valorCampo)));
        });
    }

    private String getValorCampoObjeto(Object objeto, String nomeCampo) {
        Object valorCampo;
        try {
            Field campo = objeto.getClass().getDeclaredField(nomeCampo);
            campo.setAccessible(true);
            valorCampo = campo.get(objeto);

            return valorCampo == null ? "" : String.valueOf(valorCampo);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private void gerarColunasLinha(StringBuilder sb, List<String> valores) {
        sb.append(abrirLinha());

        for (String valor : valores) {
            sb.append(abrirColuna(valor))
                    .append(fecharColuna());
        }

        sb.append(fecharLinha());
    }

    @Override
    public List<String> getNomesCampos() {
        return nomesCampos;
    }
}
