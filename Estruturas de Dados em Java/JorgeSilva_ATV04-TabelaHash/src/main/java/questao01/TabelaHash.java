/*
 Implementação da Tabela Hash com os métodos para realização das operações.
 */
package questao01;

/**
 *
 * @author jorge
 */
public class TabelaHash<K, V> {

    private static final int TAMANHO_INICIAL = 10;
    private ListaLigada<K, V>[] tabela;
    private int tamanho;
    private double fatorCargaLimite = 0.7;
    private boolean rehashRealizado = false;
    private int contadorRehash = 0;

    @SuppressWarnings("unchecked")
    public TabelaHash() {
        this.tabela = (ListaLigada<K, V>[]) new ListaLigada[TAMANHO_INICIAL];
        for (int i = 0; i < TAMANHO_INICIAL; i++) {
            tabela[i] = new ListaLigada<>();
        }
        this.tamanho = 0;
    }

    public void inserir(K chave, V valor) {
        int indice = calcularIndice(chave);
        ListaLigada<K, V> lista = tabela[indice];
        V valorExistente = lista.encontrar(chave);
        if (valorExistente != null) {

            lista.remover(chave);
        } else {
            tamanho++;
        }
        lista.adicionar(chave, valor);

        if ((double) tamanho / tabela.length > fatorCargaLimite) {
            rehashing();

        }

    }

    public void remover(K chave) {
        int indice = calcularIndice(chave);
        ListaLigada<K, V> lista = tabela[indice];
        if (lista.encontrar(chave) != null) {
            lista.remover(chave);
            tamanho--;
        } else {
            throw new IllegalArgumentException("Chave não encontrada: " + chave);
        }
    }

    public V buscar(K chave) {
        int indice = calcularIndice(chave);
        ListaLigada<K, V> lista = tabela[indice];
        return lista.encontrar(chave);
    }

    public void imprimir() {
        System.out.println("[Impressão da Tabela]");
        for (int i = 0; i < tabela.length; i++) {
            ListaLigada<K, V> lista = tabela[i];
            System.out.print("Bucket " + i + ": ");
            if (lista.estaVazia()) {
                System.out.println("Null");
            } else {
                lista.imprimir();
                System.out.println();
            }
        }
        System.out.println();
    }

    public int tamanho() {
        return tamanho;
    }

    private int calcularIndice(K chave) {

        /*
        if (chave.equals("Chave2") || chave.equals("Chave4")) {
            return 5;  // Colisão controlada Escolhendo arbitrariamente o bucket 5
        }
         */
        double A = 0.61803398875; // Constante recomendada (número áureo)
        double produto = meuHash(chave.toString()) * A;
        double parteFracionaria = produto - Math.floor(produto);
        return (int) Math.floor(parteFracionaria * tabela.length);
    }

    public void mostrarColisoes() {
        int flag = 0;
        for (int i = 0; i < tabela.length; i++) { // Percorrendo cada bucket da tabela
            ListaLigada<K, V> listaNoBucket = tabela[i];
            if (listaNoBucket != null && listaNoBucket.tamanho() > 1) { // Verificando se há colisão
                System.out.println("Bucket " + i + " possui colisão:");
                for (Node<K, V> node = listaNoBucket.head; node != null; node = node.proximo) {
                    System.out.println("Chave: " + node.chave + ", Valor: " + node.valor);
                }
                flag++;
            }
        }
        if (flag == 0) {
            System.out.println("Não foram verificadas colisões!");
        }
    }

    private void rehashing() {
        rehashRealizado = true;
        contadorRehash++;
        int novoTamanho = 2 * tabela.length; // Dobrar o tamanho
        ListaLigada<K, V>[] tabelaAntiga = tabela;

        // Criar nova tabela e inicializá-la
        tabela = (ListaLigada<K, V>[]) new ListaLigada[novoTamanho];
        for (int i = 0; i < novoTamanho; i++) {
            tabela[i] = new ListaLigada<>();
        }

        // Reinserir dados na nova tabela após rehashing
        for (int i = 0; i < tabelaAntiga.length; i++) {
            ListaLigada<K, V> lista = tabelaAntiga[i];
            Node<K, V> atual = lista.head;
            while (atual != null) {
                int novoIndice = calcularIndice(atual.chave);
                tabela[novoIndice].adicionar(atual.chave, atual.valor);
                atual = atual.proximo;
            }
        }
    }

    private int meuHash(String chave) {
        int hash = 0;
        int primo = 31;

        for (int i = 0; i < chave.length(); i++) {
            hash = hash * primo + chave.charAt(i);
        }

        return hash;
    }

    public void mostrarStatusRehash() {
        if (rehashRealizado) {
            System.out.println("Rehash foi realizado " + contadorRehash + " vezes.");
        } else {
            System.out.println("Rehash não foi realizado.");
        }
    }
}
