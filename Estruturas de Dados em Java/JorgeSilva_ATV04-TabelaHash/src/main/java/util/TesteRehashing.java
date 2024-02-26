/*
 Teste para visualização das flags de Rehash da Tabela Hash
 */
package util;

import questao01.TabelaHash;

/**
 *
 * @author jorge
 */
public class TesteRehashing {
        public static void main(String[] args) {
        TabelaHash<String, String> tabela = new TabelaHash<>();

        
        for (int i = 0; i < 20; i++) {
            tabela.inserir("Chave" + i, "Valor" + i);
        }

        // Imprimir a tabela para visualização da distribuição dos valores
        tabela.imprimir();

        // Verificar o total de elementos
        System.out.println("\nTamanho total de dados armazenados: " + tabela.tamanho());
        
        tabela.mostrarStatusRehash();
        
        }
    
}
    

