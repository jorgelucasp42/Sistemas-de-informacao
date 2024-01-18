
package questao1ABC_Lista_Pilha_Fila;


public class Fila<TIPO> {
    private ListaLigada elementos;
    
    public Fila(){
        this.elementos =new ListaLigada();
    }
    
    public void adicionar(TIPO novoValor){
        this.elementos.adicionar(novoValor);
    }
    
    public void remover(){
        this.elementos.remover(this.elementos.get(0).getValor());
    }
    
   public Object get() {
        if (this.elementos.getTamanho() > 0) {
            return this.elementos.get(0).getValor();
        } else {
            return null;
        }
    }
    
    public boolean contem(TIPO valor) {
        Elemento<TIPO> elementoEncontrado = this.elementos.buscar(valor);
        return elementoEncontrado != null;
    }
   
    public void imprimir() {
        this.elementos.imprimir();
    }
}
