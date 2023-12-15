package services;

import entities.Funcionario;
import entities.Produto;
import entities.Cliente;

import java.util.*;

public class Menu {

    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    private final Cliente cliente = new Cliente();
    private final Produto produto = new Produto();
    private final Funcionario funcionario = new Funcionario("Administrador", "admin", "123");

    public Menu() {
    }

    public void showMenu() {
        System.out.println("BEM VINDO A RECIFÉRICOS");
        System.out.println();
        System.out.println("Antes de começar, se identifique, você é cliente ou funcionário? (c/f) ");
        System.out.print("Sua escolha: ");
        char ch = scanner.next().charAt(0);

        boolean logado = false;

        while (!logado) {
            try {
                if (ch == 'c') {
                    System.out.println("O que você deseja? ");
                    System.out.println("1- Realizar login\n2- Criar conta");
                    System.out.print("Sua escolha: ");
                    int escolha = scanner.nextInt();
                    if (escolha == 1) {
                        if (cliente.logar()) {
                            logado = true;
                        }
                    } else if (escolha == 2) {
                        cliente.criarContaCliente();
                    } else {
                        System.out.println("Escolha inválida ");
                    }
                } else if (ch == 'f') {
                    scanner.nextLine();
                    System.out.print("Digite o seu email de funcionário: ");
                    String login = scanner.nextLine().trim();
                    System.out.print("Digite a sua senha: ");
                    String senha = scanner.nextLine().trim();

                    if (funcionario.logar(login, senha)) {
                        logado = true;
                        System.out.println("LOGIN REALIZADO COM SUCESSO, BEM VINDO(A)! ");
                        System.out.println();
                        menuFuncionario();
                    } else {
                        System.out.println("VOCÊ DIGITOU O LOGIN OU A SENHA INCORRETAMENTE, TENTE NOVAMENTE.");
                    }
                } else {
                    System.out.println("Entrada inválida.");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
            System.out.println();
        }

        if (ch == 'c') {
            menuCliente();
        }
    }

    public void menuFuncionario() {
        int escolha = 0;
        do {
            try {
                System.out.println("""
                        1- Listar produtos disponíveis
                        2- Vender produto
                        3- Adicionar um novo produto
                        4- Alterar informações de um produto
                        5- Voltar ao menu principal
                        6- Sair do sistema""");
                System.out.print("Sua escolha: ");
                escolha = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
                switch (escolha) {
                    case 1:
                        produto.listarProdutosDisponiveis();
                        break;
                    case 2:
                        produto.venderProduto();
                        break;
                    case 3:
                        produto.addNovoProduto();
                        break;
                    case 4:
                        produto.alterarProduto();
                        break;
                    case 5:
                        showMenu();
                        break;
                    case 6:
                        System.out.println("Finalizando o sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha novamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
        } while (escolha != 5);
    }

    public void menuCliente() {
        int escolha = 0;
        do {
            try {
                System.out.println("""
                        1- Comprar produto
                        2- Procurar produto
                        3- Retornar ao menu inicial
                        4- Listar produtos
                        5- Sair do sistema""");
                System.out.print("Sua escolha: ");
                escolha = scanner.nextInt();
                System.out.println();
                scanner.nextLine();

                switch (escolha) {
                    case 1:
                        produto.comprarProduto();
                        break;
                    case 2:
                        produto.procurarProduto();
                        break;
                    case 3:
                        showMenu();
                        break;
                    case 4:
                        produto.listarProdutosDisponiveis();
                        break;
                    case 5:
                        System.out.println("Encerrando o sistema.");
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha novamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
        } while (escolha != 5);

        scanner.close();
    }
}
