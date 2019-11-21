package br.com.caelum.contas.main;
import br.com.caelum.contas.modelo.Conta;
public class TesteDoBanco {
    public static void main(String[] args) {
        Conta novaConta = new Conta();
        novaConta.deposita(1500);
        System.out.println("Saldo:" + novaConta.getSaldo());
    }
}
