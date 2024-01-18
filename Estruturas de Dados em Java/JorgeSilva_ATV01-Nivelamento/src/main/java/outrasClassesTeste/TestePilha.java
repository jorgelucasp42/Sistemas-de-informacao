
package outrasClassesTeste;

import questao1ABC_Lista_Pilha_Fila.Pilha;


public class TestePilha {
    public static void main (String[] args){
        Pilha pilha = new Pilha();
        
        pilha.adicionar("E");
        pilha.adicionar("B");
        pilha.adicionar("Z");
        pilha.adicionar("D");
        pilha.adicionar("C");
        
        System.out.println("Topo: "+ pilha.get());
        
        pilha.remover();
        
        System.out.println("Topo: "+ pilha.get());
        
    }
}
