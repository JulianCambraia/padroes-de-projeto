package com.br.juliancambraia.strategytemplatemethod.entity;

import com.br.juliancambraia.strategytemplatemethod.model.ProcessadorBoletos;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor

/**
 * Entidade Boleto - representa os campos de um boleto ficctício
 *
 * @author juliancambraia
 */
public class Boleto {
    private int id;
    private String codBanco;
    private LocalDate dataVencimento;
    private LocalDateTime dataPagamento;
    private String cpfCliente;
    private double valor;
    private double multa;
    private double juros;
    private String agencia;
    private String contaBancaria;

    public Boleto(int id, String codBanco, String agencia, String contaBancaria, LocalDate dataVencimento, LocalDateTime dataPagamento, String cpfCliente, double valor, double multa, double juros) {
        this.id = id;
        this.codBanco = codBanco;
        this.agencia = agencia;
        this.contaBancaria = contaBancaria;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.cpfCliente = cpfCliente;
        this.valor = valor;
        this.multa = multa;
        this.juros = juros;
    }

    public Boleto(int id, String codBanco, LocalDate dataVencimento, LocalDateTime dataPagamento, String cpfCliente, double valor, double multa, double juros) {
        this.id = id;
        this.codBanco = codBanco;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.cpfCliente = cpfCliente;
        this.valor = valor;
        this.multa = multa;
        this.juros = juros;
    }

    /**
     * Formata os dados do boleto para ser usado como String ou impresso.
     * Assim, podemos fazer System.out.println(boleto) e exibir os dados formatados adequadamente.
     *
     * @return
     */
    @Override
    public String toString() {
        String str = String.format("Id: %10d Banco: %3s", id, codBanco);
        String ag = "";
        if (agencia != null && !agencia.isEmpty() && contaBancaria != null && !contaBancaria.isEmpty()) {
            ag = String.format(" Ag: %6s CC: %10s", agencia, contaBancaria);
        }

        str += ag + String.format(
                " Venc: %s Pag: %s Valor: %10.2f",
                ProcessadorBoletos.FORMATO_DATA.format(dataVencimento),
                ProcessadorBoletos.FORMATO_DATA_HORA.format(dataPagamento), valor);
        if (multa > 0) {
            str += String.format(" Multa: %10.2f", multa);
        }

        if (juros > 0) {
            str += String.format(" Juros: %10.2f", juros);
        }

        return str;
    }
}
