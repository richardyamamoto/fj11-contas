package br.com.caelum.contas;
import br.com.caelum.javafx.api.util.Evento;
import br.com.caelum.contas.modelo.*;

public class ManipuladorDeContas {

    private Conta conta;

    public void criaConta(Evento evento){
        this.conta = new Conta();
        this.conta.setAgencia("1234");
        this.conta.setNumero(56789);
        this.conta.setTitular("Batman");
    }

    public void deposita(Evento evento) {
        double valorDigitado = evento.getDouble("valorDigitado");
        this.conta.deposita(valorDigitado);
    }

    public void saca(Evento evento) {
        double valorDigitado = evento.getDouble("valorDigitado");
        this.conta.saca(valorDigitado);
    }
}
