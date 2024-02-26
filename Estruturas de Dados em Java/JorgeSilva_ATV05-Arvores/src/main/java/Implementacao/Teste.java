/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementacao;

/**
 *
 * @author jorge
 */
public class Teste {
    
    public static void main(String[] args) {
        RedBlackTree<Integer, String> rbt = new RedBlackTree<>();
        rbt.put(1, "um");
        rbt.put(2, "dois");
        rbt.put(3, "três");

        System.out.println(rbt.get(2));  // Deve imprimir "dois"
    }
}
