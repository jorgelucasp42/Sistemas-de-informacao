/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estruturas;

import java.time.LocalDate;

public class Estoque {

    private SplayTree<Produto> arvoreProdutos;

    public Estoque() {
        arvoreProdutos = new SplayTree<>();
    }

    public void adicionarProduto(int id, String nome, int quantidade, String nomeFuncionarioResponsavel, LocalDate data) {
        Produto produto = new Produto(id, nome, quantidade, nomeFuncionarioResponsavel, data);
        arvoreProdutos.insert(produto);
    }

    public Produto getProdutoMaisRecente() {
        // Retorna o produto que está na raiz da Splay Tree, que é o produto mais recentemente adicionado
        return arvoreProdutos.getRoot();
    }

    public Produto buscarProduto(int id) {
        return arvoreProdutos.find(new Produto(id, null, 0, null, null));
    }

    public void removerProduto(int id) {
        arvoreProdutos.remove(new Produto(id, null, 0, null, null));
    }
    
    // Para imprimir toda a árvore 
    public void imprimirProdutos() {
        arvoreProdutos.printTree();
    }

}


