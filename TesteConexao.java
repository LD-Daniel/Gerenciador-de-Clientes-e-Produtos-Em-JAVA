import java.util.Scanner;
import java.util.List;

public class TesteConexao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        while (true) {
            // Exibe as opções do menu
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar Cliente e Produto");
            System.out.println("2. Ver Produtos Cadastrados");
            System.out.println("3. Excluir Produto");
            System.out.println("4. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            if (opcao == 1) {
                // Cadastrar Cliente
                System.out.println("Digite o nome do cliente:");
                String nomeCliente = scanner.nextLine();

                System.out.println("Digite o endereço do cliente:");
                String enderecoCliente = scanner.nextLine();

                System.out.println("Digite o telefone do cliente:");
                String telefoneCliente = scanner.nextLine();

                System.out.println("Digite o e-mail do cliente:");
                String emailCliente = scanner.nextLine();

                // Cria e salva o cliente no banco de dados
                Cliente cliente = new Cliente(1, nomeCliente, enderecoCliente, telefoneCliente, emailCliente);
                clienteDAO.salvarCliente(cliente); // Salvar no banco de dados

                // Cadastrar Produto
                System.out.println("Digite o nome do produto:");
                String nomeProduto = scanner.nextLine();

                System.out.println("Digite a descrição do produto:");
                String descricaoProduto = scanner.nextLine();

                System.out.println("Digite o custo de produção do produto:");
                double custoProduto = scanner.nextDouble();

                System.out.println("Digite o preço de venda do produto:");
                double precoVendaProduto = scanner.nextDouble();
                scanner.nextLine(); // Limpar o buffer

                // Cria e salva o produto no banco de dados
                Produto produto = new Produto(1, nomeProduto, descricaoProduto, custoProduto, precoVendaProduto);
                produtoDAO.salvarProduto(produto); // Salvar no banco de dados
            } else if (opcao == 2) {
                // Ver Produtos Cadastrados
                List<Produto> produtos = produtoDAO.listarProdutos(); // Lista de produtos

                if (produtos.isEmpty()) {
                    System.out.println("Não há produtos cadastrados.");
                } else {
                    System.out.println("Produtos cadastrados:");
                    for (Produto produto : produtos) {
                        System.out.println("ID: " + produto.getId());
                        System.out.println("Nome: " + produto.getNome());
                        System.out.println("Descrição: " + produto.getDescricao());
                        System.out.println("Custo de Produção: " + produto.getCustoProducao());
                        System.out.println("Preço de Venda: " + produto.getPrecoVenda());
                        System.out.println("------");
                    }
                }
            } else if (opcao == 3) {
                // Excluir Produto
                System.out.println("Digite o ID do produto que deseja excluir:");
                int idProduto = scanner.nextInt();

                produtoDAO.excluirProduto(idProduto); // Excluir produto do banco de dados
            } else if (opcao == 4) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }
}
