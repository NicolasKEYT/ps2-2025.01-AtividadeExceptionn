
package br.dev.joaquim;

import java.util.Random;
import java.util.Scanner;
import br.dev.joaquim.bank.BankAccount;
import br.dev.joaquim.bank.InsufficientFundsException;

/**
 * Interface de usuário para o sistema bancário.
 * Gerencia a interação com o usuário através do console.
 */
public class UserInterface {
    private Scanner input = new Scanner(System.in);
    private BankAccount account;

    /**
     * Exibe mensagem de boas-vindas e cria uma nova conta bancária.
     */
    private void welcome() {
        System.out.println("Bem-vindo ao sistema bancário");
        System.out.print("Vamos criar usa conta, informe seu nome: ");
        String holderName = input.nextLine();
        int accountNumber = 1000 + (new Random()).nextInt(8999);
        System.out.println("Criamos uma conta com o número: " + accountNumber + ", com saldo igual a 0 (zero).");
        this.account = new BankAccount(accountNumber, 0, holderName);
    }

    /**
     * Exibe o menu de opções disponíveis.
     */
    private void showMenu() {
        System.out.println("\n\n-----------------------");
        System.out.println("Escolha uma das opções:");
        System.out.println("\t1. Verificar dados da conta.");
        System.out.println("\t2. Depositar.");
        System.out.println("\t3. Sacar.");
        System.out.println("\t4. Sair.");
        System.out.print("opção > ");
    }

    /**
     * Inicia a interface do usuário e gerencia o loop principal do programa.
     */
    public void start() {
        welcome();
        if (account == null)
            return;

        while (true) {
            showMenu();
            try {
                int choice = readOption();
                switch (choice) {
                    case 1:
                        System.out.println("\n" + this.account);
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        System.out.println("Até a próxima.");
                        return;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
                waitUser();
            } catch (NumberFormatException ex) {
                System.out.println("Valor informado não é um número");
            }
        }
    }

    /**
     * Processa a operação de depósito.
     */
    private void deposit() {
        System.out.print("\nInforme o valor a ser depositado: ");
        try {
            double value = readValue();
            account.deposit(value);
            System.out.println("Depósito realizado com sucesso.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    /**
     * Processa a operação de saque.
     */
    private void withdraw() {
        System.out.print("\nInforme o valor a ser sacado: ");
        try {
            double value = readValue();
            account.withdraw(value);
            System.out.println("Saque realizado com sucesso");
        } catch (IllegalArgumentException | InsufficientFundsException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    /**
     * Lê uma opção do menu informada pelo usuário.
     * 
     * @return número da opção escolhida
     * @throws NumberFormatException se a entrada não for um número válido
     */
    private int readOption() {
        String choiceString = input.nextLine();
        return Integer.parseInt(choiceString);
    }

    /**
     * Lê um valor monetário informado pelo usuário.
     * 
     * @return valor monetário
     * @throws NumberFormatException se a entrada não for um número válido
     */
    private double readValue() {
        String line = input.nextLine();
        return Double.parseDouble(line);
    }

    /**
     * Aguarda o usuário pressionar ENTER para continuar.
     */
    private void waitUser() {
        System.out.println("pressione ENTER para continuar...");
        input.nextLine();
    }
}
