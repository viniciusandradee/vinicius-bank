package br.com.viniciusbank.pessoa.model;

import java.time.LocalDate;
import java.util.Arrays;

public class PessoaJuridica extends Pessoa {

    private String CNPJ;
    private String razaoSocial;

    //Collection<Pessoa> socios;
    private Pessoa[] socios;
    public PessoaJuridica() {
    }

    //public PessoaJuridica(String nome, LocalDate nascimento, String CNPJ, String razaoSocial) {
    //    super(nome, nascimento);
    //    this.CNPJ = CNPJ;
    //    this.razaoSocial = razaoSocial;
    //}


    public PessoaJuridica(String nome, LocalDate nascimento, String CNPJ, String razaoSocial, Pessoa[] socios) {
        super(nome, nascimento);
        this.CNPJ = CNPJ;
        this.razaoSocial = razaoSocial;
        this.socios = socios;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Pessoa[] getSocios() {
        return socios;
    }

    public void setSocios(Pessoa[] socios) {
        this.socios = socios;
    }


    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "CNPJ='" + getCNPJ() + '\'' +
                ", razaoSocial='" + getRazaoSocial() + '\'' +
                ", socios=" + Arrays.toString(getSocios()) +
                "} " + super.toString();
    }
}
