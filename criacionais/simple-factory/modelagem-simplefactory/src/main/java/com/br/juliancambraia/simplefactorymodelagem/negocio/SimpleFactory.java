package com.br.juliancambraia.simplefactorymodelagem.negocio;

import com.br.juliancambraia.simplefactorymodelagem.entity.Cliente;

/**
 * Esta é uma fábrica que implementa o padrão Simple Factory.
 * O nome da classe deve ser alterado de acordo com o problema sendo resolvido.
 *
 * @author juliancambraia
 */
public final class SimpleFactory {

    /**
     * Método que representa a fábrica de fato.
     * O nome do método pode ser newObject, newInstance ou algo mais
     * específico como "new" + o nome da classe de objetos que o método instancia,
     * como newExportador, newTabela, etc.
     *
     * <p>O método é normalmente definido como estático para evitar
     * que tenhamos que instanciar a fábrica antes de podermos
     * instanciar objetos.</p>
     *
     * @return
     */
    public static TipoAbstrato newObject() {
        final int rand = (int) (Math.random() * 3 * 1);
        switch (rand) {
            case 1:
                return new TipoConcreto1();
            case 2:
                return new TipoConcreto2();
            case 3:
                return new TipoConcreto3();
            default:
                return new TipoConcretoN();
        }
    }

    public static TipoAbstrato newObject(Cliente parametros) {
        return null;
    }
}
