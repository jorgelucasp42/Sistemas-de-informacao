/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estruturas;

/**
 *
 * @author jorge
 */

public class Node<T extends Comparable<T>> {
    T key;
    Node<T> left, right, parent;

    public Node(T key) {
        this.key = key;
        left = right = parent = null;
    }
}