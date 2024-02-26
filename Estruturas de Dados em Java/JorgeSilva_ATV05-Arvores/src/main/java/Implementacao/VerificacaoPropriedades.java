/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementacao;

/**
 *
 * @author jorge
 */
public class VerificacaoPropriedades {
    public static void main(String[] args) {
    RedBlackTree<Integer, String> rbt = new RedBlackTree<>();

    // 1. Inserção de elementos
    for (int i = 1; i <= 10; i++) {
        rbt.put(i, "Value " + i);
    }

    // 2. Recuperação de valores
    for (int i = 1; i <= 10; i++) {
        System.out.println("Chave: " + i + ", Valor: " + rbt.get(i));
    }

    // Verificar uma chave que não existe na árvore
    System.out.println("Chave: 11, Valor: " + rbt.get(11));

    // 3. Deleção de alguns elementos
    rbt.delete(5);  // Deletar elemento do meio
    rbt.delete(1);  // Deletar o menor elemento
    rbt.delete(10); // Deletar o maior elemento

    // Recuperação após remoção
    System.out.println("Depois da remoção:");
    for (int i = 1; i <= 10; i++) {
        System.out.println("Chave: " + i + ", Valor: " + rbt.get(i));
    }

    // Deleção mínima
    rbt.deleteMin();
    System.out.println("Depois de deleteMin, Chave: 2, Valor: " + rbt.get(2));

    // 4. Verificar presença de chaves
    System.out.println("Contem chave 5? " + rbt.contains(5));
    System.out.println("Contem chave 6? " + rbt.contains(6));
}
}
