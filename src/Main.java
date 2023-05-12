import br.com.viniciusbank.model.Agencia;
import br.com.viniciusbank.model.Banco;
import br.com.viniciusbank.model.ContaCorrente;
import br.com.viniciusbank.model.ContaPoupanca;
import br.com.viniciusbank.pessoa.model.Pessoa;
import br.com.viniciusbank.pessoa.model.PessoaFisica;
import br.com.viniciusbank.pessoa.model.PessoaJuridica;

import javax.swing.*;
import java.time.LocalDate;
import java.time.MonthDay;

public class Main {

    public static Agencia novaAgencia(String nome, Banco banco) {
        Agencia agencia = new Agencia();
        agencia.setNome(nome);
        banco.addAgencia(agencia);
        return agencia;
    }

    public static PessoaFisica novaPessoa(String nome, LocalDate nascimento, String CPF, PessoaFisica mae) {
        PessoaFisica pf = new PessoaFisica();
        pf.setCPF(CPF);
        pf.setNascimento(nascimento);
        pf.setNome(nome);
        pf.setMae(mae);
        return pf;
    }

    public static ContaCorrente novaContaCorrente(Agencia agencia, Pessoa titular, double limite) {
        ContaCorrente cc = new ContaCorrente();
        cc.setAgencia(agencia);
        cc.setTitular(titular);
        cc.setLimite(limite);
        agencia.addConta(cc);
        return cc;

    }

    public static ContaPoupanca novaContaPoupanca(Agencia agencia, Pessoa titular, MonthDay dia) {
        ContaPoupanca cp = new ContaPoupanca();
        cp.setAniversario(dia.getDayOfMonth());
        cp.setAgencia(agencia);
        cp.setTitular(titular);
        agencia.addConta(cp);
        return cp;
    }


    public static void main(String[] args) {

        Banco vinicius = new Banco("Vinicius Bank");
        Agencia mooca = novaAgencia("Mooca", vinicius);
        PessoaFisica mae = novaPessoa("Silvia Andrade", LocalDate.of(1977, 4, 22), "213241651-20", null);
        PessoaFisica vini = novaPessoa("Vinicius Andrade", LocalDate.of(2005, 5, 11), "213246546-50", mae);
        ContaCorrente cc = novaContaCorrente(mooca, vini, 2000);
        ContaPoupanca cp = novaContaPoupanca(mooca, mae, MonthDay.now());

        PessoaJuridica holding = new PessoaJuridica();
        holding.setCNPJ("1231312/0001-09");
        holding.setNascimento(LocalDate.of(2015, 7, 19));
        holding.setNome("Vinicius Holding");
        holding.setRazaoSocial("Vinicius Holding SA");

        PessoaFisica lucca = new PessoaFisica();
        lucca.setCPF("1322121312231");
        lucca.setNascimento(LocalDate.of(2004, 8, 19));
        lucca.setNome("Luca Freitas");
        lucca.setMae(mae);

        Pessoa[] socios = new Pessoa[3];
        socios[0] = vini;
        socios[1] = mae;
        socios[2] = lucca;

        holding.setSocios(socios);



        ContaCorrente ccH = new ContaCorrente();
        ccH.setNumero("3-7");
        ccH.setLimite(500);
        ccH.setSaldo(1000);
        ccH.setTitular(holding);
        ccH.setAgencia(mooca);

        //System.out.println(ccH);

        /*
        System.out.println(socios[0]); // vini
        System.out.println();
        System.out.println(socios[1]); // mae
        System.out.println();
        System.out.println(socios[2]); // Lucca
        */

        int continua;
        int i;
        for(i = 0; i < socios.length; i++) {
            System.out.println(socios[i]);
        }

        System.out.printf("Saldo atual: R$%,.2f%n" , ccH.getSaldo());
        System.out.printf("Limite de saldo negativo: R$-%,.2f%n" , ccH.getLimite());
        System.out.printf("Disponivel para saque: R$%,.2f%n" , (ccH.getSaldo() + ccH.getLimite()));
        System.out.println();
        do{
            double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor que deseja sacar: "));
            boolean saquei = ccH.sacar(valor);
            if(saquei){
                System.out.println("Saque efetuado com sucesso");
            } else {
                System.out.println("Erro no saque, tente novamente!");
            }

            String texto = """
                    
                    Deseja realizar um novo saque?
                    
                    [1] Sim
                    [2] Não
                    """;
            continua = Integer.parseInt(JOptionPane.showInputDialog(texto));
        }while(continua == 1);

        System.out.println();
        System.out.printf("Saldo atual: R$%,.2f%n" , ccH.getSaldo());
        System.out.printf("Limite de saldo negativo: R$-%,.2f%n" , ccH.getLimite());
        System.out.printf("Foi sacado: R$%,.2f%n" , (cc.getSaldo()- ccH.getSaldo()));
        System.out.printf("Disponivel para saque: R$%,.2f%n" , (ccH.getSaldo() + ccH.getLimite()));

        String msg = String.format("Saldo final: R$%.2f", ccH.getSaldo());
        //JOptionPane.showMessageDialog(null, "Saldo final: R$%,.2f%n" , ccH.getSaldo());
        JOptionPane.showMessageDialog(null, msg);
    }
}
