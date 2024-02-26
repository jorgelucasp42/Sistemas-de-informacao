/*
 Teste para visualização dos principais métodos da Tabela Hash
 */

package util;

import questao01.TabelaHash;

/**
 *
 * @author jorge
 */
public class TesteTabelaHash {
    public static void main(String[] args) {
        TabelaHash<String, Integer> tabela = new TabelaHash<>();

        tabela.inserir("chave1", 1);
        tabela.inserir("chave2", 2);
        tabela.inserir("chave3", 3);

        System.out.println("Imprimindo a tabela:");
        tabela.imprimir();
               
        String chaveBusca = "chave2";
        Integer valorEncontrado = tabela.buscar(chaveBusca);
        System.out.println("Valor encontrado para a chave '" + chaveBusca + "': " + valorEncontrado);
        
        String chaveRemover = "chave1";
        
        tabela.remover(chaveRemover);
        System.out.println();
        
        System.out.println("Removendo a chave '" + chaveRemover + "'.");
        System.out.println();
        
        System.out.println("Imprimindo a tabela após a remoção:");
        System.out.println();
        tabela.imprimir();

        // Tentativa de remover uma chave que não existe
        String chaveInexistente = "chave13";
        try {
            tabela.remover(chaveInexistente);
        } catch (IllegalArgumentException e) {
            System.out.println("Tentativa de remover uma chave inexistente. " + e.getMessage()+".");
            
        }
    }
}


