package br.com.viniciusbank.model;

public class Agencia {

    private String numero;
    private String nome;
    private Banco banco;



    public Agencia(){
    }
    public Agencia(String numero, String nome, Banco banco) {
        this.numero = numero;
        this.nome = nome;
        this.banco = banco;
    }



    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }
}
