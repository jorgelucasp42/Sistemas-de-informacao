/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao02;

/**
 *
 * @author jorge
 */
import questao01.Aresta;
import questao01.Grafo;
import questao01.Vertice;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class DetectorDeCiclos<TIPO> {

    private Grafo<TIPO> grafo;

    public DetectorDeCiclos(Grafo<TIPO> grafo) {
        this.grafo = grafo;
    }

    public boolean detectarCiclos() {
        Set<Vertice<TIPO>> visitados = new HashSet<>();
        Queue<Vertice<TIPO>> fila = new LinkedList<>();

        // Inicializa a fila com todos os vértices de grau 1
        for (Vertice<TIPO> vertice : grafo.getVertices()) {
            if (vertice.getGrau() == 1) {
                fila.add(vertice);
                visitados.add(vertice);
            }
        }

        // Processa a fila
        while (!fila.isEmpty()) {
            Vertice<TIPO> atual = fila.poll();

            for (Aresta<TIPO> aresta : atual.getArestasSaida()) {
                Vertice<TIPO> vizinho = aresta.getFim();
                vizinho.decrementarGrau();

                // Adiciona o vizinho à fila se seu grau se tornar 1
                if (vizinho.getGrau() == 1 && !visitados.contains(vizinho)) {
                    fila.add(vizinho);
                    visitados.add(vizinho);
                }
            }
        }

        // Verifica se existem vértices não visitados
        for (Vertice<TIPO> vertice : grafo.getVertices()) {
            if (!visitados.contains(vertice)) {
                return true; // Ciclo detectado
            }
        }

        return false; // Sem ciclos
    }
}
