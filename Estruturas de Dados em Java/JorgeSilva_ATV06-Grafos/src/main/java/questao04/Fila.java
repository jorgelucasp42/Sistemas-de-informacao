/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao04;

/**
 *
 * @author jorge
 */
import java.util.ArrayList;
import java.util.List;

public class Fila<T> {

    private List<T> lista = new ArrayList<>();

    // Método para adicionar elementos na fila
    public void enfileirar(T elemento) {
        lista.add(elemento);
    }

    // Método para remover e retornar o elemento no início da fila
    public T desenfileirar() {
        if (estaVazia()) {
            return null; // ou lançar uma exceção
        }
        return lista.remove(0);
    }

    // Método para olhar o elemento no início da fila sem removê-lo
    public T primeiro() {
        if (estaVazia()) {
            return null; // ou lançar uma exceção
        }
        return lista.get(0);
    }

    // Método para verificar se a fila está vazia
    public boolean estaVazia() {
        return lista.isEmpty();
    }

    // Método para obter o tamanho da fila
    public int tamanho() {
        return lista.size();
    }
}
