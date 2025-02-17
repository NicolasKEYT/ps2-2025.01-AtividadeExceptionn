
package br.dev.joaquim.bank;

/**
 * Exceção lançada quando uma operação bancária não pode ser realizada devido a saldo insuficiente.
 */
public class InsufficientFundsException extends Exception {
    /**
     * Construtor que recebe uma mensagem descritiva do erro.
     * 
     * @param message A mensagem detalhando o motivo da exceção
     */
    public InsufficientFundsException(String message) {
        super(message);
    }
}
