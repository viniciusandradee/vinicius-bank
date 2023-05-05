import br.com.viniciusbank.model.Agencia;
import br.com.viniciusbank.model.Banco;
import br.com.viniciusbank.model.ContaCorrente;
import br.com.viniciusbank.model.ContaPoupanca;
import br.com.viniciusbank.pessoa.model.PessoaFisica;
import br.com.viniciusbank.pessoa.model.PessoaJuridica;

import javax.swing.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Banco vinicius = new Banco("Vinicius Bank");

        Agencia osasco = new Agencia();
        osasco.setBanco(vinicius);
        osasco.setNome("Osasco");
        osasco.setNumero("1-9");

        var nomeMae = JOptionPane.showInputDialog("Informe o nome da mãe");

        PessoaFisica mae = new PessoaFisica();
        mae.setNome(nomeMae);
        mae.setNascimento(LocalDate.of(1977, 4, 22));
        mae.setCPF("213241651-20");

        PessoaFisica vini = new PessoaFisica();
        vini.setCPF("213246546-50");
        vini.setNascimento(LocalDate.of(2005, 5, 11));
        vini.setNome("Vinicius Andrade");
        vini.setMae(mae);

        ContaCorrente cc = new ContaCorrente();
        cc.setAgencia(osasco);
        cc.setTitular(vini);
        cc.setSaldo(1_000_000.99);
        cc.setLimite(5_000_000);
        cc.setNumero("1-9");

        ContaPoupanca cp = new ContaPoupanca();
        cp.setNumero("2-8");
        cp.setAniversario(4);
        cp.setAgencia(osasco);
        cp.setSaldo(500_000);
        cp.setTitular(mae);

        PessoaJuridica holding = new PessoaJuridica();
        holding.setCNPJ("1231312/0001-09");
        holding.setNascimento(LocalDate.of(2015, 7, 19));
        holding.setNome("Vinicius Holding");
        holding.setRazaoSocial("Vinicius Holding SA");

        ContaCorrente ccH = new ContaCorrente();
        ccH.setNumero("3-7");
        ccH.setLimite(800_000_000);
        ccH.setSaldo(1_000_000_000);
        ccH.setTitular(holding);
        ccH.setAgencia(osasco);

        System.out.println(ccH);

        System.out.println(vini);

    }
}