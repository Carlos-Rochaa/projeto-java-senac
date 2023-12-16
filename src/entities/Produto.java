package entities;


import java.util.*;

public class Produto implements Operacoes {

    protected String name;
    protected String brand;

    protected String model;
    protected double price;
    protected int inventaryQuantity;
    private static final List<Produto> list = new ArrayList<>(Arrays.asList(
            new Produto("Teclado", "Redragon", "Fizz", 99.99, 10),
            new Produto("Mouse", "Redragon", "Cobra", 49.99, 15),
            new Produto("Headset", "JBL", "Quantum", 149.99, 8),
            new Produto("Monitor", "Samsung", "Odyssey", 1499.99, 5),
            new Produto("Mousepad", "Hyperx", "Gamer", 19.99, 20),
            new Produto("Webcam", "Logitech", "x", 79.99, 12),
            new Produto("Teclado", "Machenike", "K500", 79.99, 10),
            new Produto("HD", "WD", "500gb", 299.99, 15),
            new Produto("SSD", "WD", "M2", 499.99, 7),
            new Produto("GABINETE", "Corsair", "RGB", 399.99, 25)
    ));


    private static final Scanner scanner = new Scanner(System.in).useLocale(Locale.US);


    public Produto() {

    }

    public Produto(String name, String brand, String model, double price, int inventaryQuantity) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.inventaryQuantity = inventaryQuantity;
    }


    @Override
    public void listar() {
        listarProdutosDisponiveis();
    }

    @Override
    public void vender() {
        venderProduto();
    }

    @Override
    public void adicionar() {
        addNovoProduto();
    }

    @Override
    public void alterar() {
        alterarProduto();
    }


    public void listarProdutosDisponiveis() {

        System.out.println("Lista de produtos disponíveis: ");
        System.out.println();

        if (list.isEmpty()) {
            System.out.println("A LISTA DE PRODUTOS ESTÁ VAZIA");
        } else {
            for (Produto produto : list) {
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

        boolean produtoEncontrado = false;

        for (Produto produto : list) {
            if (produto != null && nome.equalsIgnoreCase(produto.getName())) {
                System.out.println("MODELOS DE " + produto.getName().toUpperCase() + " DISPONÍVEIS");
                System.out.println(produto.getName().toUpperCase() + " " + produto.getBrand().toUpperCase() +
                        " " + produto.getModel().toUpperCase() + ", QUANTIDADE EM ESTOQUE: " + produto.getInventaryQuantity());

                System.out.print("Qual modelo deseja vender? ");
                String modelo = scanner.nextLine();
                System.out.print("Quantos deseja vender? ");
                int quantidade = scanner.nextInt();

                if (quantidade > 0 && quantidade <= produto.getInventaryQuantity() && modelo.equalsIgnoreCase(produto.getModel())) {
                    System.out.println("Você vendeu " + quantidade + " " + produto.getName() + " " + produto.getBrand() + " " + produto.getModel()
                            + " totalizando " + String.format("%.2f,", produto.getPrice() * quantidade) + " reais.");
                    produto.subtrairEstoque(quantidade);
                } else {
                    System.out.println("Quantidade inválida ou modelo não correspondente. Venda não realizada.");
                }

                produtoEncontrado = true;
                break;
            }
        }

        if (!produtoEncontrado) {
            System.out.println("Produto não encontrado.");
            System.out.println();
        }
    }

    public void addNovoProduto() {
        try {
            System.out.print("Digite o nome do produto: ");
            String name = scanner.nextLine();

            System.out.print("Digite o nome da marca do produto: ");
            String brand = scanner.nextLine();

            System.out.print("Digite o modelo do produto: ");
            String modelo = scanner.nextLine();

            System.out.print("Digite o preço do produto: ");
            double price = scanner.nextDouble();

            System.out.print("Digite a quantidade inicial do produto em estoque: ");
            int initial = scanner.nextInt();


            if (price < 0 || initial < 0) {
                System.out.println("Erro: Preço e quantidade inicial não podem ser negativos. Tente novamente.");
                return;
            }


            list.add(new Produto(name, brand, modelo, price, initial));

            System.out.println("PRODUTO ADICIONADO COM SUCESSO!");
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Certifique-se de inserir valores numéricos corretos.");
            scanner.nextLine();
        }
    }


    public void subtrairEstoque(int quantidade) {
        this.inventaryQuantity -= quantidade;
    }

    public void alterarProduto() {

        listarProdutosDisponiveis();


        System.out.print("Digite o nome do produto que deseja alterar: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o modelo do produto que deseja alterar: ");
        String modelo = scanner.nextLine();

        for (Produto produto : list) {
            if (produto != null && nome.equalsIgnoreCase(produto.getName()) && modelo.equalsIgnoreCase(produto.getModel())) {
                System.out.println("Digite as novas informações do produto");

                System.out.print("Novo nome: ");
                produto.setName(scanner.nextLine());

                System.out.print("Nova marca: ");
                produto.setBrand(scanner.nextLine());

                System.out.print("Novo valor: ");
                produto.setPrice(scanner.nextDouble());
                scanner.nextLine();
                System.out.print("Novo modelo: ");
                produto.setModel(scanner.nextLine());

                System.out.print("Nova quantidade em estoque: ");
                produto.setInventaryQuantity(scanner.nextInt());

                System.out.println("Produto alterado com sucesso!");
                System.out.println();
                return;
            }
        }

        System.out.println("Produto não encontrado. Nenhuma alteração realizada.");
        System.out.println();
    }


    public void comprarProduto() {

        System.out.print("Digite o nome do produto que deseja comprar: ");
        String nomeProduto = scanner.nextLine();

        boolean produtoEncontrado = false;
        for (Produto produto : list) {
            if (produto != null && nomeProduto.equalsIgnoreCase(produto.getName())) {
                System.out.println(nomeProduto + " " + produto.getModel() + " " + produto.getBrand() + ", preço: " + produto.getPrice());
                produtoEncontrado = true;
            }
        }

        if (!produtoEncontrado) {
            System.out.println("Produto não encontrado.");
            return;
        }

        System.out.print("Qual modelo deseja comprar? ");
        String modelo = scanner.nextLine();
        System.out.print("Quantos deseja comprar? ");

        try {
            int quantidade = scanner.nextInt();

            if (quantidade <= 0) {
                System.out.println("Quantidade inválida. A compra não foi realizada.");
                return;
            }

            for (Produto produto : list) {
                if (produto != null && quantidade <= produto.getInventaryQuantity() && modelo.equalsIgnoreCase(produto.getModel())) {
                    System.out.println("Você comprou " + quantidade + " " + produto.getName() + " " + produto.getBrand() + " " +
                            produto.getModel() + " totalizando " + (produto.getPrice() * quantidade) + " reais.");
                    produto.subtrairEstoque(quantidade);
                    return;
                }
            }

            System.out.println("Produto não disponível em quantidade suficiente. A compra não foi realizada.");
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Certifique-se de inserir um número para a quantidade.");
        } finally {
            scanner.nextLine();
            System.out.println();
        }
    }


    public void procurarProduto() {
        System.out.print("Digite o nome do produto que deseja procurar: ");
        String nome = scanner.nextLine();

        if (nome.isBlank()) {
            System.out.println("Nome de produto inválido.");
            return;
        }

        boolean produtoEncontrado = false;

        System.out.println("Lista de " + nome + " em estoque: ");
        for (Produto produtos : list) {
            if (produtos != null && nome.equalsIgnoreCase(produtos.getName())) {
                System.out.println(produtos.getName() + " " + produtos.getModel() + " preço: " + produtos.getPrice());
                produtoEncontrado = true;
            }
        }

        if (!produtoEncontrado) {
            System.out.println("Produto não encontrado.");
        }

        System.out.println();
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
