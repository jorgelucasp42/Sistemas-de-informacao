/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementacao;

/**
 *
 * @author jorge
 */


import java.util.function.BiConsumer;

public class RedBlackTreeTest {

    public static void main(String[] args) {
        RedBlackTree<Integer, String> tree = new RedBlackTree<>();

        // Inserir 7 IDs na árvore
        for (int i = 1; i <= 7; i++) {
            tree.put(i, "ID" + i);
        }

        // Imprimir a árvore com cores e IDs usando inOrderTraversal
       // ...
BiConsumer<Integer, Boolean> action = (key, color) -> {
            String colorStr = color == RedBlackTree.isRed() ? "Vermelho" : "Preto";
            System.out.println("ID: " + key + " Cor: " + colorStr);
        };


        tree.inOrderTraversal(action);
    }
}
