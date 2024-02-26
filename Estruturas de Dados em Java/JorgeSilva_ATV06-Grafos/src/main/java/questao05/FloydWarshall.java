/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao05;

/**
 *
 * @author jorge
 */
import java.util.ArrayList;
import java.util.List;
import questao01.Aresta;
import questao01.Grafo;
import questao01.Vertice;

public class FloydWarshall<TIPO> {

    private Grafo<TIPO> grafo;
    private double[][] distancias;
    private TIPO[][] predecessores;

    public FloydWarshall(Grafo<TIPO> grafo) {
        this.grafo = grafo;
        inicializar();
    }

    private void inicializar() {
        List<Vertice<TIPO>> vertices = grafo.getVertices();
        int N = vertices.size();
        distancias = new double[N][N];
        predecessores = (TIPO[][]) new Object[N][N];

        // Inicialização da matriz de distâncias e predecessores
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    distancias[i][j] = 0;
                    predecessores[i][j] = null;
                } else {
                    distancias[i][j] = Double.MAX_VALUE;
                    predecessores[i][j] = null;
                }
            }
        }

        // Preenchimento das distâncias iniciais com base nas arestas
        for (Aresta<TIPO> aresta : grafo.getArestas()) {
            int u = vertices.indexOf(aresta.getInicio());
            int v = vertices.indexOf(aresta.getFim());
            distancias[u][v] = aresta.getPeso();
            predecessores[u][v] = aresta.getInicio().getDado();
        }
    }

    public void executar() {
        List<Vertice<TIPO>> vertices = grafo.getVertices();
        int N = vertices.size();

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (distancias[i][k] + distancias[k][j] < distancias[i][j]) {
                        distancias[i][j] = distancias[i][k] + distancias[k][j];
                        predecessores[i][j] = predecessores[k][j];
                    }
                }
            }
        }
    }

    public double[][] getDistancias() {
        return distancias;
    }

    public TIPO[][] getPredecessores() {
        return predecessores;
    }

    // rastrear o caminho entre dois vértices
    public List<TIPO> getCaminho(TIPO origem, TIPO destino) {
        List<Vertice<TIPO>> vertices = grafo.getVertices();
        int indiceOrigem = vertices.indexOf(new Vertice<>(origem));
        int indiceDestino = vertices.indexOf(new Vertice<>(destino));

        if (distancias[indiceOrigem][indiceDestino] == Double.MAX_VALUE) {
            return null; // Não há caminho
        }

        List<TIPO> caminho = new ArrayList<>();
        TIPO passo = destino;
        while (passo != null && !passo.equals(origem)) {
            caminho.add(0, passo);
            int indicePasso = vertices.indexOf(new Vertice<>(passo));
            passo = predecessores[indiceOrigem][indicePasso];
        }
        caminho.add(0, origem);
        return caminho;
    }
}
