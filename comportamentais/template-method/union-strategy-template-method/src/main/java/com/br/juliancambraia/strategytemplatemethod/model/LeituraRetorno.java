package com.br.juliancambraia.strategytemplatemethod.model;

import com.br.juliancambraia.strategytemplatemethod.entity.Boleto;

public interface LeituraRetorno {

    Boleto processarLinhaArquivo(String[] vetorLinhaArq);
}
