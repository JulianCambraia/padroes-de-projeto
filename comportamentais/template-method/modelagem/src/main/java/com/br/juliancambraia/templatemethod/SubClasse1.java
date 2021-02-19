package com.br.juliancambraia.templatemethod;

/**
 * Subclasse que fornece uma implementação específica
 * para as operações primitivas definidas na classe abstrata.
 *
 * @author juliancambraia
 */
public class SubClasse1 extends ClasseAbstrata {
    @Override
    protected void operacaoPrimitiva1() {
        //TODO: Seu código aqui.
        System.out.println("\tExecutou operação primitiva 1 na classe " + getClass().getSimpleName());
    }

    @Override
    protected void operacaoPrimitiva2() {
        //TODO: Seu código aqui.
        System.out.println("\tExecutou operação primitiva 2 na classe " + getClass().getSimpleName());
    }

    @Override
    protected void operacaoPrimitivaN() {
        //TODO: Seu código aqui.
        System.out.println("\tExecutou operação primitiva 3 na classe " + getClass().getSimpleName());
    }
}
