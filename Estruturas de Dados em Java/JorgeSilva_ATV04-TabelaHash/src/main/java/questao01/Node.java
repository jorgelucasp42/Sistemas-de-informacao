/*
 Classe que apenas cria o nó que será utilizado na listaligada. 
 */
package questao01;

/**
 *
 * @author jorge
 */
public class Node<K, V> {
    K chave;
    V valor;
    Node<K, V> proximo;

    Node(K chave, V valor) {
        this.chave = chave;
        this.valor = valor;
        this.proximo = null;
    }
}
    
