
package br.com.banco.model;
public class ContaBancaria {
     private String numeroConta;
    private double saldo;
    private Cliente titular;

    public ContaBancaria(String numeroConta, Cliente titular, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldoInicial;

        Agencia.registrarNovaConta();
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean sacar(double valor) {

        double total = valor + Agencia.TAXA_SAQUE;

        if (saldo >= total) {
            saldo -= total;
            return true;
        }

        return false;
    }
}
