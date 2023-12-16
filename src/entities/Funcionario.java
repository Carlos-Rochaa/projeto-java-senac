package entities;


import java.util.Arrays;
import java.util.List;

public class Funcionario extends Pessoa {

    private static final List<Funcionario> list = Arrays.asList(
            new Funcionario("Leandro", "leandro@gmail.com", "123"),
            new Funcionario("Lucas", "lucas@gmail.com", "123")
    );


    public Funcionario() {

    }


    public Funcionario(String name, String email, String senha) {
        super(name, email, senha);
    }


    public boolean logar(String login, String senhaFornecida) {
        for (Funcionario f : list) {
            if (f.email.equalsIgnoreCase(login) && f.senha.equalsIgnoreCase(senhaFornecida)) {
                return true;
            }

        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
