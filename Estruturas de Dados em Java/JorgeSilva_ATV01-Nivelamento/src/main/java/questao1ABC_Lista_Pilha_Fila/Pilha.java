
package questao1ABC_Lista_Pilha_Fila;


public class Pilha {
    private ListaLigada lista;

    public Pilha() {
        this.lista = new ListaLigada();
    }
    
    public void adicionar (String novoValor){
        this.lista.adicionarComeco(novoValor);
    }
    public void remover(){
        this.lista.remover(this.get());
    }
    
    public Object get(){
        return this.lista.getPrimeiro().getValor();
    }
    public Elemento contemValor(String valor) {
        return lista.buscar(valor);
    }
    
    public void imprimir() {
        this.lista.imprimir();
    }
    
     public boolean contem(String valor) {
        return lista.buscar(valor) != null;
    }

}
