/*
 Implementação da lista ligada para estruturação dos dados. 
 */
package questao01;

/**
 *
 * @author jorge
 */


public class ListaLigada<K, V> {
    public Node<K, V> head;

    public void adicionar(K chave, V valor) {
        Node<K, V> novoNode = new Node<>(chave, valor);
        if (head == null) {
            head = novoNode;
        } else {
            Node<K, V> atual = head;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNode;
        }
    }

    public V encontrar(K chave) {
        Node<K, V> atual = head;
        while (atual != null) {
            if (atual.chave.equals(chave)) {
                return atual.valor;
            }
            atual = atual.proximo;
        }
        return null;
    }

    public void remover(K chave) {
        if (head == null) {
            return;
        }
        if (head.chave.equals(chave)) {
            head = head.proximo;
            return;
        }
        Node<K, V> anterior = head;
        Node<K, V> atual = head.proximo;
        while (atual != null) {
            if (atual.chave.equals(chave)) {
                anterior.proximo = atual.proximo;
                return;
            }
            anterior = atual;
            atual = atual.proximo;
        }
    }

    public boolean estaVazia() {
        return head == null;
    }

    public void imprimir() {
        Node<K, V> atual = head;
        while (atual != null) {
            System.out.print("[" + atual.chave + ", " + atual.valor + "] ");
            atual = atual.proximo;
        }
    }
    
    public int tamanho() {
        int cont = 0;
        Node<K, V> atual = head;
        while (atual != null) {
            cont++;
            atual = atual.proximo;
        }
        return cont;
    }
}
