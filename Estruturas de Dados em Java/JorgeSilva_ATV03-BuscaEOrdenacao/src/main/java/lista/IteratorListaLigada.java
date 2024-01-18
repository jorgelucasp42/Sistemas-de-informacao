
package lista;

public class IteratorListaLigada<TIPO> {
    private Elemento<TIPO> elemento;
    
    public IteratorListaLigada(Elemento<TIPO> atual){
        this.elemento=atual;
    }
    
   public boolean temProximo(){
    return elemento != null;
}

    public Elemento<TIPO> getProximo(){
         if (elemento == null) {
            return null; 
        }

        Elemento<TIPO> elementoAtual = elemento;
        elemento = elemento.getProximo();
        return elementoAtual;
    }
}
