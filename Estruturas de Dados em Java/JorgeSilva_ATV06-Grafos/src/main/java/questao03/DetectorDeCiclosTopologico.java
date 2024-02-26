/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao03;

/**
 *
 * @author jorge
 */
import questao01.Grafo;
import questao01.Vertice;
import questao01.Aresta;
import java.util.ArrayList;
import java.util.List;

public class DetectorDeCiclosTopologico<TIPO> {

    private Grafo<TIPO> grafo;

    public DetectorDeCiclosTopologico(Grafo<TIPO> grafo) {
        this.grafo = grafo;
    }

    public boolean detectarCiclos() {
        // Inicialização do grau de entrada
        List<Vertice<TIPO>> grauZero = new ArrayList<>();
        int[] grauEntrada = new int[grafo.getVertices().size()];
        for (int i = 0; i < grauEntrada.length; i++) {
            grauEntrada[i] = grafo.getVertices().get(i).getArestasEntrada().size();
            if (grauEntrada[i] == 0) {
                grauZero.add(grafo.getVertices().get(i));
            }
        }

        int contador = 0;
        while (!grauZero.isEmpty()) {
            Vertice<TIPO> v = grauZero.remove(0);
            contador++;

            for (Aresta<TIPO> aresta : v.getArestasSaida()) {
                Vertice<TIPO> destino = aresta.getFim();
                grauEntrada[grafo.getVertices().indexOf(destino)]--;
                if (grauEntrada[grafo.getVertices().indexOf(destino)] == 0) {
                    grauZero.add(destino);
                }
            }
        }

        return contador != grafo.getVertices().size();
    }
}
