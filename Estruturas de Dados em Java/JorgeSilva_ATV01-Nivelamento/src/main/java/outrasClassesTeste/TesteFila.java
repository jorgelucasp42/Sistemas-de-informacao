
package outrasClassesTeste;

import questao1ABC_Lista_Pilha_Fila.Fila;
import questao1ABC_Lista_Pilha_Fila.Fila;


public class TesteFila {
    
    public static void main(String[] args){
        Fila fila = new Fila();
        
        fila.adicionar("Jão");
        fila.adicionar("Zé");
        fila.adicionar("Juca");
        System.out.println(fila.get());
        fila.remover();
        System.out.println(fila.get());
        
        
    }
} 
