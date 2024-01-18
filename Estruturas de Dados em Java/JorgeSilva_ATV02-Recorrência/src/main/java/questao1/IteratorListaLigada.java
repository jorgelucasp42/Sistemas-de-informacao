
package questao1;

public class IteratorListaLigada<TIPO> {
    private Elemento<TIPO> elemento;
    
    public IteratorListaLigada(Elemento<TIPO> atual){
        this.elemento=atual;
    }
    
    public boolean temProximo(){
        if(elemento.getProximo() == null){
            return false;
       
        }else{
            return true;
        }
    }
    public Elemento<TIPO> getProximo(){
         if (elemento == null) {
            return null;  // ou você pode lançar uma exceção personalizada para indicar que não há mais elementos.
        }

        Elemento<TIPO> elementoAtual = elemento;
        elemento = elemento.getProximo();
        return elementoAtual;
    }
}
