package br.com.caelum.contas.util;

public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(double valor) {
        super("Saldo insuficiente para sacar " + valor);
    }
}
