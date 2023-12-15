package entities;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Produto {

    protected String name;
    protected String brand;

    protected String model;
    protected double price;
    protected int inventaryQuantity;
    private static final List<Produto> list = new ArrayList<>();


    private static final Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    static {
        list.add(new Produto("Teclado", "Redragon", "Fizz", 99.99, 10));
        list.add(new Produto("Mouse", "Redragon", "Cobra", 49.99, 15));
        list.add(new Produto("Headset", "JBL", "Quantum", 149.99, 8));
        list.add(new Produto("Monitor", "Samsung", "Odyssey", 1499.99, 5));
        list.add(new Produto("Mousepad", "Hyperx", "Gamer", 19.99, 20));
        list.add(new Produto("Webcam", "Logitech", "x", 79.99, 12));
        list.add(new Produto("Teclado", "Machenike", "K500", 79.99, 10));
        list.add(new Produto("HD", "WD", "500gb", 299.99, 15));
        list.add(new Produto("SSD", "WD", "M2", 499.99, 7));
        list.add(new Produto("GABINETE", "Corsair", "RGB", 399.99, 25));
    }

    public Produto() {

    }

    public Produto(String name, String brand, String model, double price, int inventaryQuantity) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.inventaryQuantity = inventaryQuantity;
    }

    public void listarProdutosDisponiveis() {

        System.out.println("Lista de produtos disponíveis: ");
        System.out.println();
        for (Produto produto : list) {

            if (list.isEmpty()) {
                System.out.println("A LISTA DE PRODUTOS ESTÁ VAZIA");
            } else {
                System.out.println("Nome: " + produto.getName());
                System.out.println("Marca: " + produto.getBrand());
                System.out.println("Valor: " + produto.getPrice());
                System.out.println("Modelo: " + produto.getModel());
                System.out.println("Quantidade em estoque: " + produto.getInventaryQuantity());
                System.out.println("---------------------------------------------");
                System.out.println();
            }
        }
    }

    public void venderProduto() {
        scanner.nextLine();
        System.out.print("Digite o nome do produto que deseja vender: ");
        String nome = scanner.nextLine();
        System.out.println("Modelos de " + nome + " disponíveis");
        for (Produto produto : list) {
            if (produto != null && nome.equalsIgnoreCase(produto.getName())) {
                System.out.println(nome + " " + produto.getModel() + " " + produto.getBrand());
            }
        }
        System.out.print("Qual modelo deseja vender? ");
        String modelo = scanner.nextLine();
        System.out.print("Quantos deseja vender? ");
        int quantidade = scanner.nextInt();
        for (Produto produto : list) {
            if (produto != null && quantidade < produto.getInventaryQuantity() && modelo.equalsIgnoreCase(produto.getModel())) {
                System.out.println("Você vendeu " + quantidade + " " + produto.getName() + " " + produto.getBrand() + " " + produto.getModel()
                        + " totalizando " + (produto.getPrice() * quantidade) + " reais.");
                produto.subtrairEstoque(quantidade);
            }
        }

    }

    public void addNovoProduto() {
        System.out.print("Digite o nome do produto: ");
        String name = scanner.nextLine();
        System.out.print("Digite o nome da marca do produto:  ");
        String brand = scanner.nextLine();
        System.out.print("Digite o modelo do produto: ");
        String modelo = scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        double price = scanner.nextDouble();
        System.out.print("Digite a quantidade inicial do produto em estoque: ");
        int initial = scanner.nextInt();
        list.add(new Produto(name, brand, modelo, price, initial));

        System.out.println("PRODUTO ADICIONADO COM SUCESSO!");
        System.out.println();


    }

    public void subtrairEstoque(int quantidade) {
        this.inventaryQuantity -= quantidade;
    }

    public void alterarProduto() {
        System.out.println("Lista de produtos disponíveis para alteração ");
        listarProdutosDisponiveis();
        System.out.print("Digite o nome do produto que deseja alterar:  ");
        String nome = scanner.nextLine();
        System.out.print("Digite o modelo do produto que deseja alterar: ");
        String modelo = scanner.nextLine();
        for (Produto produto : list) {
            if (produto != null && nome.equalsIgnoreCase(produto.getName()) && modelo.equalsIgnoreCase(produto.getModel())) {
                System.out.println("Digite o novo nome do produto ");
                System.out.print("Novo nome: ");
                produto.setName(scanner.nextLine());
                System.out.println("Digite a nova marca do produto ");
                System.out.print("Nova marca: ");
                produto.setBrand(scanner.nextLine());
                System.out.println("Digite o novo valor do produto ");
                System.out.print("Novo valor: ");
                produto.setPrice(scanner.nextDouble());
                scanner.nextLine();
                System.out.println("Digite o novo nome do modelo do produto ");
                System.out.print("Novo modelo: ");
                produto.setModel(scanner.nextLine());
                System.out.println("Digite a nova quantidade em estoque do produto");
                System.out.print("Nova quantidade em estoque: ");
                produto.setInventaryQuantity(scanner.nextInt());
                System.out.println();
            }
        }

    }


    public void comprarProduto() {
        scanner.nextLine();
        System.out.print("Digite o nome do produto que deseja comprar: ");
        String nomeProduto = scanner.nextLine();
        System.out.println("Modelos de " + nomeProduto + " disponíveis");
        for (Produto produto : list) {
            if (produto != null && nomeProduto.equalsIgnoreCase(produto.getName())) {
                System.out.println(nomeProduto + " " + produto.getModel() + " " + produto.getBrand() + ", preço:  " + produto.getPrice());
            }
        }
        System.out.print("Qual modelo deseja comprar? ");
        String modelo = scanner.nextLine();
        System.out.print("Quantos deseja comprar? ");
        int quantidade = scanner.nextInt();
        for (Produto produto : list) {
            if (produto != null && quantidade < produto.getInventaryQuantity() && modelo.equalsIgnoreCase(produto.getModel())) {
                System.out.println("Você comprou " + quantidade + " " + produto.getName() + " " + produto.getBrand() + " " + produto.getModel()
                        + " totalizando " + (produto.getPrice() * quantidade) + " reais.");
                produto.subtrairEstoque(quantidade);
            }
        }
    }


    public void procurarProduto() {
        System.out.print("Digite o nome do produto que deseja procurar: ");
        String nome = scanner.nextLine();
        System.out.println("Lista de " + nome + " em estoque ");
        for (Produto produtos : list) {
            if (produtos != null && nome.equalsIgnoreCase(produtos.getName())) {
                System.out.println(produtos.getName() + " " + produtos.getModel() + " preço:  " + produtos.getPrice());
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInventaryQuantity() {
        return inventaryQuantity;
    }

    public void setInventaryQuantity(int inventaryQuantity) {
        this.inventaryQuantity = inventaryQuantity;
    }


}
