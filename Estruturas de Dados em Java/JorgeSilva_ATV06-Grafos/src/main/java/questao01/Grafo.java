/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao01;

/**
 *
 * @author jorge
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class Grafo<TIPO> {

    private ArrayList<Vertice<TIPO>> vertices;
    private ArrayList<Aresta<TIPO>> arestas;

    public Grafo() {
        this.vertices = new ArrayList<>();
        this.arestas = new ArrayList<>();
    }

    public void adicionarVertice(TIPO dado) {
        if (!verticeExiste(dado)) {
            Vertice<TIPO> novoVertice = new Vertice<>(dado);
            this.vertices.add(novoVertice);
        }
    }

    public ArrayList<Vertice<TIPO>> getVertices() {
        return vertices;
    }

    public void adicionarAresta(Double peso, TIPO dadoInicio, TIPO dadoFim) {
        Vertice<TIPO> inicio = this.getVertice(dadoInicio).orElseThrow(() -> new IllegalArgumentException("Vértice de início não encontrado"));
        Vertice<TIPO> fim = this.getVertice(dadoFim).orElseThrow(() -> new IllegalArgumentException("Vértice de fim não encontrado"));

        if (!arestaExiste(inicio, fim)) {
            Aresta<TIPO> aresta = new Aresta<>(peso, inicio, fim);
            inicio.adicionarArestaSaida(aresta);
            fim.adicionarArestaEntrada(aresta);
            fim.incrementarGrauEntrada();
            this.arestas.add(aresta);
        }
    }

    public void adicionarArestaNaoDirecionada(Double peso, TIPO dadoInicio, TIPO dadoFim) {
        Vertice<TIPO> inicio = this.getVertice(dadoInicio).orElseThrow(() -> new IllegalArgumentException("Vértice de início não encontrado"));
        Vertice<TIPO> fim = this.getVertice(dadoFim).orElseThrow(() -> new IllegalArgumentException("Vértice de fim não encontrado"));

        Aresta<TIPO> aresta = new Aresta<>(peso, inicio, fim);
        Aresta<TIPO> arestaInversa = new Aresta<>(peso, fim, inicio); // Aresta de retorno

        inicio.adicionarArestaSaida(aresta);
        fim.adicionarArestaEntrada(aresta);
        fim.adicionarArestaSaida(arestaInversa);
        inicio.adicionarArestaEntrada(arestaInversa);

        this.arestas.add(aresta);
        this.arestas.add(arestaInversa); // Adiciona ambas as direções

        inicio.incrementarGrau();
        fim.incrementarGrau();
    }

    public ArrayList<Aresta<TIPO>> getArestas() {
        return this.arestas;
    }

    public boolean verticeExiste(TIPO dado) {
        return this.vertices.stream().anyMatch(vertice -> vertice.getDado().equals(dado));
    }

    public boolean pesquisaVertice(TIPO dado) {
        return getVertice(dado).isPresent();
    }

    public boolean pesquisaAresta(TIPO dadoInicio, TIPO dadoFim) {
        Optional<Vertice<TIPO>> inicio = getVertice(dadoInicio);
        Optional<Vertice<TIPO>> fim = getVertice(dadoFim);

        if (inicio.isPresent() && fim.isPresent()) {
            return arestaExiste(inicio.get(), fim.get());
        }
        return false;
    }

    public boolean arestaExiste(Vertice<TIPO> inicio, Vertice<TIPO> fim) {
        return inicio.getArestasSaida().stream().anyMatch(aresta -> aresta.getFim().equals(fim));
    }

    public Optional<Vertice<TIPO>> getVertice(TIPO dado) {
        return this.vertices.stream().filter(vertice -> vertice.getDado().equals(dado)).findFirst();
    }

    public void removerVertice(TIPO dado) {
        Vertice<TIPO> vertice = this.getVertice(dado).orElse(null);
        if (vertice != null) {
            this.vertices.remove(vertice);
            // Remover arestas associadas ao vértice
            vertice.getArestasEntrada().forEach(aresta -> arestas.remove(aresta));
            vertice.getArestasSaida().forEach(aresta -> arestas.remove(aresta));
        }
    }

    public void removerAresta(TIPO dadoInicio, TIPO dadoFim) {
        Vertice<TIPO> inicio = this.getVertice(dadoInicio).orElse(null);
        Vertice<TIPO> fim = this.getVertice(dadoFim).orElse(null);

        if (inicio != null && fim != null) {
            Aresta<TIPO> arestaARemover = inicio.getArestasSaida().stream()
                    .filter(aresta -> aresta.getFim().equals(fim))
                    .findFirst()
                    .orElse(null);

            if (arestaARemover != null) {
                inicio.removerArestaSaida(arestaARemover);
                fim.removerArestaEntrada(arestaARemover);
                this.arestas.remove(arestaARemover);
            }
        }
    }

    public void removerArestaNaoDirecionada(TIPO dadoInicio, TIPO dadoFim) {
        Vertice<TIPO> inicio = this.getVertice(dadoInicio).orElse(null);
        Vertice<TIPO> fim = this.getVertice(dadoFim).orElse(null);

        if (inicio != null && fim != null) {
            Aresta<TIPO> arestaARemover = inicio.getArestasSaida().stream()
                    .filter(aresta -> aresta.getFim().equals(fim))
                    .findFirst()
                    .orElse(null);

            if (arestaARemover != null) {
                inicio.removerArestaSaida(arestaARemover);
                fim.removerArestaEntrada(arestaARemover);
                this.arestas.remove(arestaARemover);
            }
        }
        inicio.decrementarGrau();
        fim.decrementarGrau();
    }

    public void imprimirGrafo() {
        for (Vertice<TIPO> vertice : vertices) {
            String saida = vertice.getDado() + " -> ";
            for (Aresta<TIPO> aresta : vertice.getArestasSaida()) {
                saida += aresta.getFim().getDado() + " (" + aresta.getPeso() + "), ";
            }
            System.out.println(saida);
        }
    }

    public void imprimirGrafoVerticesAdj() {
        for (Vertice<TIPO> vertice : vertices) {
            System.out.print(vertice.getDado() + " -> ");
            List<Aresta<TIPO>> arestasSaida = vertice.getArestasSaida();
            for (Aresta<TIPO> aresta : arestasSaida) {
                System.out.print(aresta.getFim().getDado() + " ");
            }
            System.out.println();
        }
    }

}
