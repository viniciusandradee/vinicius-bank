package br.com.viniciusbank.pessoa.model;

import java.time.LocalDate;

public class PessoaFisica extends Pessoa{

    private String cpf;
    private PessoaFisica mae;



    public PessoaFisica() {
    }
    public PessoaFisica(String nome, LocalDate nascimento, String cpf, PessoaFisica mae) {
        super(nome, nascimento);
        this.cpf = cpf;
        this.mae = mae;
    }



    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public PessoaFisica getMae() {
        return mae;
    }

    public void setMae(PessoaFisica mae) {
        this.mae = mae;
    }
}
