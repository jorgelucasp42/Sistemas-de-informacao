/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao04;

/**
 *
 * @author jorge
 */
import java.util.ArrayList;
import java.util.List;
import questao01.Grafo;
import questao01.Vertice;
import questao01.Aresta;

public class BuscaEmLargura<TIPO> {

    public List<TIPO> buscarCaminhoBFS(Grafo<TIPO> grafo, TIPO inicio, TIPO fim) {
        Fila<Vertice<TIPO>> fila = new Fila<>();
        List<TIPO> caminho = new ArrayList<>();

        Vertice<TIPO> verticeInicio = grafo.getVertice(inicio).orElseThrow(() -> new IllegalArgumentException("Vértice de início não encontrado"));
        fila.enfileirar(verticeInicio);
        verticeInicio.setVisitado(true);
        verticeInicio.setPredecessor(null);

        while (!fila.estaVazia()) {
            Vertice<TIPO> verticeAtual = fila.desenfileirar();
            if (verticeAtual.getDado().equals(fim)) {
                // Reconstruir o caminho
                Vertice<TIPO> verticeCaminho = verticeAtual;
                while (verticeCaminho != null) {
                    caminho.add(0, verticeCaminho.getDado());
                    verticeCaminho = verticeCaminho.getPredecessor();
                }
                return caminho;
            }

            for (Aresta<TIPO> aresta : verticeAtual.getArestasSaida()) {
                Vertice<TIPO> vizinho = aresta.getFim();
                if (!vizinho.isVisitado()) {
                    fila.enfileirar(vizinho);
                    vizinho.setVisitado(true);
                    vizinho.setPredecessor(verticeAtual);
                }
            }
        }
        return null; // Caminho não encontrado
    }
}
