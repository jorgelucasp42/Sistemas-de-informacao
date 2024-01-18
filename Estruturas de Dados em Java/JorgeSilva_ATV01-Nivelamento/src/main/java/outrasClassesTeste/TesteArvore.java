

package outrasClassesTeste;

import questao1D_arvore.Arvore;

/**
 *
 * @author jorge
 */
public class TesteArvore {

    public static void main(String[] args) {
        Arvore<Integer> arvore = new Arvore<>();
        
        arvore.adicionar(10);
        arvore.adicionar(8);
        arvore.adicionar(5);
        arvore.adicionar(9);
        arvore.adicionar(7);
        arvore.adicionar(18);
        arvore.adicionar(13);
        arvore.adicionar(20);
        
        System.out.println("\nEm-ordem");
        arvore.emOrdem(arvore.getRaiz()); 
        
        arvore.remover(20);
        
        System.out.println("\nEm-ordem");
        arvore.emOrdem(arvore.getRaiz()); 
        
        arvore.remover(5);
        
        System.out.println("\nEm-ordem");
        arvore.emOrdem(arvore.getRaiz()); 
        
        arvore.remover(8);
        
        System.out.println("\nEm-ordem");
        arvore.emOrdem(arvore.getRaiz()); 
        
        arvore.remover(9);
        
        System.out.println("\nEm-ordem");
        arvore.emOrdem(arvore.getRaiz());
        
        arvore.remover(13);
        
        System.out.println("\nEm-ordem");
        arvore.emOrdem(arvore.getRaiz());
        
        arvore.remover(7);
        arvore.remover(18);
        System.out.println("\nEm-ordem");
        arvore.emOrdem(arvore.getRaiz());
        
        //System.out.println("\nPré-ordem");
        //arvore.preOrdem(arvore.getRaiz()); 
        
        //System.out.println("\nPos-ordem");
        //arvore.posOrdem(arvore.getRaiz()); 
        
    
    }
}
