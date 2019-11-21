package br.com.caelum.contas;
import br.com.caelum.javafx.api.util.Evento;
import br.com.caelum.contas.modelo.*;

public class ManipuladorDeContas {

    private Conta conta;

    public void criaConta(Evento evento) {

        String tipo = evento.getSelecionadoNoRadio("tipo");
        if(tipo.equals("Conta Corrente"))
            this.conta = new ContaCorrente();
        else {
            this.conta = new ContaPoupanca();
        }
        this.conta.setAgencia(evento.getString("agencia"));
        this.conta.setNumero(evento.getInt("numero"));
        this.conta.setTitular(evento.getString("titular"));
    }

    public void deposita(Evento evento) {
        double valorDigitado = evento.getDouble("valorOperacao");

    }

    public void saca(Evento evento) {
        this.conta.saca(evento.getDouble("valorOperacao"));
    }

    public void transfere(Evento evento) {
        Conta destino = (Conta) evento.getSelecionadoNoCombo("destino");
        conta.transfere(evento.getDouble("valorTransferencia"), destino);
    }
}
