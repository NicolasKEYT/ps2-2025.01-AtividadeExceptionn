
package br.dev.joaquim.bank;

/**
 * Representa uma conta bancária com operações básicas.
 */
public class BankAccount {
    private int accountNumber;
    private double balance;
    private String accountHolderName;

    /**
     * Construtor padrão.
     */
    public BankAccount() {
    }

    /**
     * Construtor que inicializa uma conta bancária com valores específicos.
     * 
     * @param accountNumber Número da conta
     * @param balance Saldo inicial
     * @param accountHolderName Nome do titular
     */
    public BankAccount(int accountNumber, double balance, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolderName = accountHolderName;
    }

    /**
     * Obtém o número da conta.
     * 
     * @return Número da conta
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Obtém o saldo atual da conta.
     * 
     * @return Saldo atual
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Obtém o nome do titular da conta.
     * 
     * @return Nome do titular
     */
    public String getAccountHolderName() {
        return accountHolderName;
    }

    /**
     * Realiza um depósito na conta.
     * 
     * @param value Valor a ser depositado
     * @throws IllegalArgumentException se o valor for negativo
     */
    public void deposit(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("O valor precisa ser positivo, foi informado o valor R$ " + value);
        }
        this.balance += value;
    }

    /**
     * Realiza um saque na conta.
     * 
     * @param value Valor a ser sacado
     * @throws IllegalArgumentException se o valor for negativo
     * @throws InsufficientFundsException se não houver saldo suficiente
     */
    public void withdraw(double value) throws InsufficientFundsException {
        if (value < 0) {
            throw new IllegalArgumentException("O valor precisa ser positivo, foi informado o valor R$ " + value);
        }
        if (value > this.balance) {
            throw new InsufficientFundsException("Saldo insuficiente. Saldo atual: R$ " + this.balance + ", Valor solicitado: R$ " + value);
        }
        this.balance -= value;
    }

    /**
     * Retorna uma representação em string da conta bancária.
     * 
     * @return String contendo informações da conta
     */
    @Override
    public String toString() {
        return "Conta " + accountNumber + " de " + accountHolderName + " têm R$ " + balance + " de saldo";
    }
}