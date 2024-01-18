
package questao1ABC_Lista_Pilha_Fila;

public class ListaLigada<TIPO> {
    private Elemento<TIPO> primeiro;
    private Elemento<TIPO> ultimo;
    private int tamanho;

    public ListaLigada(){
        this.tamanho=0;
    }
    
   
    public Elemento<TIPO> getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(Elemento<TIPO> primeiro) {
        this.primeiro = primeiro;
    }

    public Elemento<TIPO> getUltimo() {
        return ultimo;
    }

    public void setUltimo(Elemento<TIPO> ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    
    public void adicionar (TIPO novoValor){
        Elemento<TIPO> novoElemento = new Elemento<TIPO> (novoValor);
        if(this.primeiro== null && this.ultimo == null){
            this.primeiro = novoElemento;
            this.ultimo = novoElemento;
            
        }
        else{
            this.ultimo.setProximo(novoElemento);
            novoElemento.setAnterior(this.ultimo);
            this.ultimo = novoElemento;
            
        }
        this.tamanho++;
    }
    
     public void adicionarComeco (TIPO novoValor){
        Elemento<TIPO> novoElemento = new Elemento<TIPO> (novoValor);
        if(this.primeiro== null && this.ultimo == null){
            this.primeiro = novoElemento;
            this.ultimo = novoElemento;
            
        }
        else{
            this.primeiro.setAnterior(novoElemento);
            novoElemento.setProximo(this.primeiro);
            this.primeiro = novoElemento;
            
        }
        this.tamanho++;
    }
    
    public void remover (TIPO valorProcurado){
        Elemento<TIPO> atual = this.primeiro;
        while(atual != null) {
            if (atual.getValor().equals(valorProcurado)) {
                if (atual == primeiro) {
                    this.primeiro = atual.getProximo();
                    if (this.primeiro != null) {
                        this.primeiro.setAnterior(null);
                    }
                } else if (atual == ultimo) {
                    this.ultimo = atual.getAnterior();
                    if (this.ultimo != null) {
                        this.ultimo.setProximo(null);
                    }
                } else {
                    atual.getAnterior().setProximo(atual.getProximo());
                    atual.getProximo().setAnterior(atual.getAnterior());
                }
                this.tamanho--;
                
                if (tamanho == 0) {
                    primeiro = null;
                    ultimo = null;
                }
                
                return;
            }
            atual = atual.getProximo();
        }
    }
    
  
    public Elemento get(int posicao){
        
        if (posicao >= this.tamanho) {
            return null;  // ou você pode lançar uma exceção, por exemplo, IndexOutOfBoundsException.
        }
        
        Elemento atual = this.primeiro;
        
        
        for(int i=0; i<posicao; i++){
            if(atual.getProximo() !=null){
                atual=atual.getProximo();
            }
        }
        return atual;
    }
    
    public IteratorListaLigada<TIPO> getIterator(){
        return new IteratorListaLigada<TIPO>(this.primeiro); 
    }
    
    public Elemento<TIPO> buscar(TIPO valorProcurado) {
        Elemento<TIPO> atual = this.primeiro;
        while (atual != null) {
            if (atual.getValor().equals(valorProcurado)) {
                return atual;
            }
            atual = atual.getProximo();
        }
        return null;
    }
    
     public void imprimirPrimeiroEUltimo() {
        if (primeiro != null) {
            System.out.println("Primeiro elemento: " + primeiro.getValor());
        } else {
            System.out.println("Primeiro elemento: Lista vazia");
        }

        if (ultimo != null) {
            System.out.println("Último elemento: " + ultimo.getValor());
        } else {
            System.out.println("Último elemento: Lista vazia");
        }
    }
     
    public void imprimir() {
        Elemento<TIPO> atual = this.primeiro;
        while (atual != null) {
            System.out.println(atual.getValor());
            atual = atual.getProximo();
        }
    }
    
    
 
}
