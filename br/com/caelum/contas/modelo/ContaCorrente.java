package br.com.caelum.contas.modelo;

public class ContaCorrente extends Conta implements Tributavel{
    @Override
    public String getTipo() {
        return "Conta Corrente";
    }

    @Override
    public void saca(double valorDigitado) {
        this.saldo -= (valorDigitado + 0.10);
    }

    @Override
    public double getValorImposto() {
        return this.getSaldo() * 0.01;
    }
}
