package services;

import entities.Produto;
import entities.Cliente;

import java.util.*;

public class Menu {


    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    Cliente cliente = new Cliente();

    Produto produto = new Produto();

    String loginFunc = "admin";
    String senhaFunc = "123";

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
                System.out.print("Digite o seu login de funcionário: ");
                String login = scanner.nextLine();
                System.out.print("Digite a sua senha: ");
                String senha = scanner.nextLine();

                if (login.equalsIgnoreCase(loginFunc) && senha.equalsIgnoreCase(senhaFunc)) {
                    logado = true;
                    System.out.println("LOGIN REALIZADO COM SUCESSO");
                    System.out.println();
                    menuFuncionario();
                } else {
                    System.out.println("VOCÊ DIGITOU O LOGIN OU A SENHA INCORRETAMENTE, TENTE NOVAMENTE.");
                }
            } else {
                System.out.println("Entrada inválida.");
            }

            scanner.nextLine();
            System.out.println();
        }

        if (ch == 'c') {
            menuCliente();
        }

    }


    public void menuFuncionario() {
        int escolha;
        do {


            System.out.println("1- Listar produtos disponíveis\n2- Vender produto\n3- Adicionar um novo produto\n4- Alterar informações de um produto\n5- Sair");
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
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção invalida");
            }
        } while (escolha != 5);
    }


    public void menuCliente() {
        int escolha;
        do {
            System.out.println("1- Comprar produto\n2- Procurar produto\n3- Sair");
            System.out.print("Sua escolha: ");
            escolha = scanner.nextInt();
            System.out.println();

            switch (escolha) {
                case 1:
                    produto.comprarProduto();
                    break;
                case 2:
                    produto.procurarProduto();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;

            }
        } while (escolha != 3);


    }


}
