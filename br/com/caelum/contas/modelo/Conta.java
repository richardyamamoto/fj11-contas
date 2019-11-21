package br.com.caelum.contas.modelo;
import br.com.caelum.contas.util.SaldoInsuficienteException;

public abstract class Conta {
    private int numero;
    private String titular;
    protected double saldo;
    private String agencia;

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
    public String getAgencia() {
        return this.agencia;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
    public String getTitular() {
        return this.titular;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return this.numero;
    }

    public void saca(double valorSaque) {
        if(valorSaque < 0) {
            throw new IllegalArgumentException("Valor de saque deve ser positivo.");
        }
        if(this.saldo < valorSaque) {
            throw new SaldoInsuficienteException(valorSaque);
        }else {
            this.saldo -= valorSaque;
        }
    }

    public void deposita(double valorDeposito) {
        if (valorDeposito < 0) {
            throw new IllegalArgumentException("Valor de deposito deve ser positivo.");
        } else if (valorDeposito > 0) {
            this.saldo += valorDeposito;
        }
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void transfere(double valorTransferencia, Conta conta) {
        this.saca(valorTransferencia);
        conta.deposita(valorTransferencia);
    }

    public abstract String getTipo();

    public String recuperaDadosParaImpressao() {
        String dados = "Titular: " + this.titular;
        dados += "\nNúmero: " + this.numero;
        dados += "\nAgência: " + this.agencia;
        dados += "\nSaldo: R$" + this.saldo;
        return dados;
    }
}
