package entities;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private String name;
    private String email;
    private String senha;

    private static final List<Funcionario> list = new ArrayList<>();

    static {
        Funcionario funcionario1 = new Funcionario("Leandro", "leandromarques@gmail.com", "123");
        Funcionario funcionario2 = new Funcionario("Lucas", "lucassilva@gmail.com", "123");
        list.add(funcionario1);
        list.add(funcionario2);
    }

    public Funcionario() {

    }


    public Funcionario(String name, String email, String senha) {
        this.name = name;
        this.email = email;
        this.senha = senha;
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
