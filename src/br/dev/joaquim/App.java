
package br.dev.joaquim;

/**
 * Classe principal que inicia a aplicação bancária.
 */
public class App {
    /**
     * Método principal que inicia a aplicação.
     * 
     * @param args argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        UserInterface main = new UserInterface();
        main.start();
    }
}
