
package questao1ABC_Lista_Pilha_Fila;


public class Elemento<TIPO> {
    private TIPO valor;
    private Elemento<TIPO> proximo;
    private Elemento<TIPO> anterior;

    
    public Elemento(TIPO valor, Elemento<TIPO> proximo, Elemento<TIPO> anterior) {
        this.valor = valor;
        this.proximo = proximo;
        this.anterior = anterior;
    }

    public Elemento(TIPO novoValor){
        this.valor = novoValor;
    }
    
    public TIPO getValor() {
        return valor;
    }

    public void setValor(TIPO valor) {
        this.valor = valor;
    }

    public Elemento<TIPO> getProximo() {
        return proximo;
    }

    public void setProximo(Elemento<TIPO> proximo) {
        this.proximo = proximo;
    }

    public Elemento<TIPO> getAnterior() {
        return anterior;
    }

    public void setAnterior(Elemento<TIPO> anterior) {
        this.anterior = anterior;
    }
    

}
