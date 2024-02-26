/*
 Para o correto funcionamento do teste é necessário alterar o bloco 'if' de colisão controlada
 no método de cálculo de índice na classe TabelaHash
 */
package util;

import questao01.TabelaHash;

/**
 *
 * @author jorge
 */
public class TesteColisoes {
    public static void main(String[] args) {
        TabelaHash<String, String> minhaTabela = new TabelaHash<>();

        
        minhaTabela.inserir("Chave1", "Valor1");
        minhaTabela.inserir("Chave2", "Valor2");
        minhaTabela.inserir("Chave3", "Valor3");
        minhaTabela.inserir("Chave4", "Valor4");
        minhaTabela.inserir("Chave5", "Valor5");

        
        // Imprime a tabela hash para ver os buckets
        System.out.println("Tabela Hash:");
        minhaTabela.imprimir();

        // Imprime as colisões
        System.out.println("\nColisões:");
        minhaTabela.mostrarColisoes();
    }
    
    
}
