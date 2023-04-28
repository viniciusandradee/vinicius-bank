package br.com.viniciusbank.model;

import br.com.viniciusbank.pessoa.model.Pessoa;

public class ContaPoupanca extends Conta {

    private int aniversario;



    public ContaPoupanca() {
    }
    public ContaPoupanca(Agencia agencia, Pessoa titular, double saldo, int aniversario) {
        super(agencia, titular, saldo);
        this.aniversario = aniversario;
    }



    public int getAniversario() {
        return aniversario;
    }

    public void setAniversario(int aniversario) {
        this.aniversario = aniversario;
    }
}
