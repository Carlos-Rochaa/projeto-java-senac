package entities;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String email;
    private long senha;

    private static List<Cliente> clientes = new ArrayList<>();


    private static Scanner scanner = new Scanner(System.in);

    static {
        clientes.add(new Cliente("carlos@gmail.com", 123));
    }

    public Cliente() {
    }

    public Cliente(String email, long senha) {
        this.email = email;
        this.senha = senha;
    }

    public void criarContaCliente() {
        System.out.print("Digite o seu email para cadastrar: ");
        this.email = scanner.nextLine();
        System.out.print("Digite a senha: ");
        this.senha = scanner.nextLong();
        Cliente novoCliente = new Cliente(email, senha);
        clientes.add(novoCliente);
        System.out.println("CLIENTE CADASTRADO COM SUCESSO.");
        scanner.nextLine();
        System.out.println();
    }

    public boolean logar() {
        System.out.print("Digite o seu email de cliente: ");
        String email = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        long senha = scanner.nextLong();
        scanner.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente != null && email.equalsIgnoreCase(cliente.email) && senha == cliente.senha) {
                System.out.println("LOGADO COM SUCESSO!");
                return true;
            }
        }
        System.out.println("ERRO AO REALIZAR LOGIN, SENHA OU LOGIN INVÁLIDOS. TENTE NOVAMENTE.");
        System.out.println();
        return false;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getSenha() {
        return senha;
    }

    public void setSenha(long senha) {
        this.senha = senha;
    }
}
