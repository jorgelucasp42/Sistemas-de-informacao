/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estruturas;

/**
 *
 * @author jorge
 */
import java.time.LocalDate;
import java.util.Scanner;

public class TesteEstoqueConsole {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque(); 

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Inserir novo produto");
            System.out.println("2 - Buscar produto por ID");
            System.out.println("3 - Remover produto por ID");
            System.out.println("4 - Imprimir todos os produtos");
            System.out.println("0 - Sair");

            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1: // Inserir novo produto
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir nova linha
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine(); // Consumir nova linha
                    System.out.print("Fornecedor: ");
                    String fornecedor = scanner.nextLine();
                    
                    // Usando a data atual para simplificar, mas poderia pedir ao usuário
                    estoque.adicionarProduto(id, nome, quantidade, fornecedor, LocalDate.now());
                    System.out.println("Produto adicionado.");
                    break;
                case 2: // Buscar produto por ID
                    System.out.print("ID para busca: ");
                    id = scanner.nextInt();
                    Produto produto = estoque.buscarProduto(id);
                    if (produto != null) {
                        System.out.println("Produto encontrado: " + produto);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 3: // Remover produto por ID
                    System.out.print("ID do produto a remover: ");
                    int n = scanner.nextInt();
                    estoque.removerProduto(n);
                    System.out.println("Produto removido.");
                    break;

                case 4: // Imprimir todos os produtos
                    estoque.imprimirProdutos();
                    break;
                case 0: // Sair
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
