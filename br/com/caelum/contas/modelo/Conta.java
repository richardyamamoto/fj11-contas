package br.com.caelum.contas.modelo;

public class Conta {
    private int numero;
    private String titular;
    private double saldo;
    private String agencia;

    public void setAgencia(String agencia) {
        this.agencia = agencia;
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

    public boolean saca(double valorSaque) {
        if(this.saldo < valorSaque) {
            System.out.printf("Saldo insuficiente para saque.");
            return false;
        }else {
            this.saldo -= valorSaque;
            return true;
        }
    }

    public void deposita(double valorDeposito) {
        if(valorDeposito > 0) {
            this.saldo += valorDeposito;
        }
    }

    public double getSaldo() {
        return this.saldo;
    }

    public boolean transfere(Conta contaDestino, double valorTransferencia) {
        boolean retirou = this.saca(valorTransferencia);
        if(retirou) {
            System.out.println("Saldo insuficiente para transferência");
            return false;
        }else {
            contaDestino.deposita(valorTransferencia);
            return true;
        }
    }

}
