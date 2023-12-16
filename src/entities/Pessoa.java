package entities;

public class Pessoa {
    protected String name;
    protected String email;
    protected String senha;

    public Pessoa() {

    }


    public Pessoa(String name, String email, String senha) {
        this.name = name;
        this.email = email;
        this.senha = senha;
    }
}
