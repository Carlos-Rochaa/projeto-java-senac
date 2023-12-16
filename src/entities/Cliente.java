package entities;

import entities.Exceptions.CadastroException;
import entities.Exceptions.LoginException;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {

    private static final List<Cliente> clientes = new ArrayList<>(Arrays.asList(
            new Cliente("Carlos", "carlos@gmail.com", "123"),
            new Cliente("Luiz ", "luizreis@gmail.com", "123")
    ));
    private static final Scanner scanner = new Scanner(System.in);


    public Cliente() {
    }

    public Cliente(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    public void criarContaCliente() throws CadastroException {
        try {
            System.out.print("Digite o seu nome: ");
            String name = scanner.nextLine();
            System.out.print("Digite o seu email para cadastrar: ");
            String email = scanner.nextLine();
            System.out.print("Digite a senha: ");
            String senha = scanner.nextLine();

            if (email.isBlank() || senha.isBlank()) {
                throw new CadastroException("Email e senha são campos obrigatórios");
            }
            Cliente novoCliente = new Cliente(name, email, senha);
            clientes.add(novoCliente);
            System.out.println("CLIENTE CADASTRADO COM SUCESSO.");
            System.out.println();
        } catch (CadastroException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
            System.out.println();
        }

    }


    public boolean logar() {
        try {
            System.out.print("Digite o seu email de cliente: ");
            String email = scanner.nextLine();
            System.out.print("Digite sua senha: ");
            String senha = scanner.nextLine();

            for (Cliente cliente : clientes) {
                if (cliente != null && email.equalsIgnoreCase(cliente.email) && senha.equals(cliente.senha)) {
                    System.out.println("LOGADO COM SUCESSO! BEM VINDO(A) AO SISTEMA, " + cliente.getName().toUpperCase());
                    return true;
                }
            }
            throw new LoginException("ERRO AO REALIZAR LOGIN, SENHA OU LOGIN INVÁLIDOS. TENTE NOVAMENTE.");
        } catch (Exception e) {
            throw new LoginException("Ocorreu um erro ao realizar o login: " + e.getMessage());
        }
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getName() {
        return name;
    }

}
