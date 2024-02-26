/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estruturas;

import java.time.LocalDate;

public class TesteEstoquePosicoes {

    public static void main(String[] args) {
        // Criação do estoque
        Estoque estoque = new Estoque();

        // Definindo uma data base 'x'
        LocalDate dataBase = LocalDate.now();

        // Adiciona produtos na árvore splay
        estoque.adicionarProduto(10, "Caneta", 100, "José", dataBase);
        estoque.adicionarProduto(20, "Lápis", 150, "Ana", dataBase.plusDays(2));
        estoque.adicionarProduto(15, "Borracha", 50, "Carlos", dataBase.plusDays(3));
        estoque.adicionarProduto(25, "Marcador", 80, "Mariana", dataBase.plusDays(4));
        estoque.adicionarProduto(5, "Régua", 60, "Fernando", dataBase.plusDays(5));

        // Chamada de método para imprimir a árvore splay
        System.out.println("Árvore Splay após inserções:");
        estoque.imprimirProdutos();
        
        estoque.adicionarProduto(1, "Grafite", 10, "José", LocalDate.now().plusDays(6));
        estoque.adicionarProduto(2, "Apontador", 15, "Ana", LocalDate.now().plusDays(7));
        estoque.adicionarProduto(3, "Estojo", 5, "Carlos", LocalDate.now().plusDays(8));
        
        System.out.println();
        System.out.println("Árvore Splay após novas inserções:");        
        estoque.imprimirProdutos();
        System.out.println();
        
        // Exibe o produto mais recente (deve ser o último produto acessado ou adicionado)
        Produto maisRecente = estoque.getProdutoMaisRecente();
        System.out.println("Produto mais recente: " + maisRecente);
        System.out.println();
        
         // Buscar produtos pelo ID
        Produto produtoBuscado = estoque.buscarProduto(2);
        System.out.println("Produto buscado: " + produtoBuscado);
        System.out.println();
        
         // Remover um produto
        estoque.removerProduto(2);
           
        // Tenta buscar o produto removido
        Produto produtoRemovido = estoque.buscarProduto(2);
        if (produtoRemovido == null) {
            System.out.println("Produto com ID 2 foi removido e não está mais no estoque.");
        }
        System.out.println();
        
         // Imprime todos os produtos no estoque
        System.out.println("Produtos em estoque após remoção:");
        estoque.imprimirProdutos();
    }
}
