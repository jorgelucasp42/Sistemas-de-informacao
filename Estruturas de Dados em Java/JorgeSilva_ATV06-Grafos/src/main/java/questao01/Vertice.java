/*
         * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
         * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao01;

/**
 *
 * @author jorge
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertice<TIPO> {

    private TIPO dado;
    private ArrayList<Aresta<TIPO>> arestasEntrada;
    private ArrayList<Aresta<TIPO>> arestasSaida;

    private int grau; // Novo campo

    public int getGrau() {
        return grau;
    }

    public void incrementarGrau() {
        this.grau++;
    }

    public void decrementarGrau() {
        if (this.grau > 0) {
            this.grau--;
        }
    }

    private int grauEntrada; // Grau de entrada (indegree)

    public int getGrauEntrada() {
        return grauEntrada;
    }

    public void incrementarGrauEntrada() {
        this.grauEntrada++;
    }

    public void decrementarGrauEntrada() {
        if (this.grauEntrada > 0) {
            this.grauEntrada--;
        }
    }

    public Vertice(TIPO valor) {
        this.dado = valor;
        this.arestasEntrada = new ArrayList<>();
        this.arestasSaida = new ArrayList<>();
    }

    public TIPO getDado() {
        return dado;
    }

    public void setDado(TIPO dado) {
        this.dado = dado;
    }

    public List<Aresta<TIPO>> getArestasEntrada() {
        return arestasEntrada;
    }

    public List<Aresta<TIPO>> getArestasSaida() {
        return arestasSaida;
    }

    public void adicionarArestaEntrada(Aresta<TIPO> aresta) {
        this.arestasEntrada.add(aresta);
    }

    public void adicionarArestaSaida(Aresta<TIPO> aresta) {
        this.arestasSaida.add(aresta);
    }

    public void removerArestaEntrada(Aresta<TIPO> aresta) {
        this.arestasEntrada.remove(aresta);
    }

    public void removerArestaSaida(Aresta<TIPO> aresta) {
        this.arestasSaida.remove(aresta);
    }

    private boolean visitado;
    private Vertice<TIPO> predecessor;

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public Vertice<TIPO> getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertice<TIPO> predecessor) {
        this.predecessor = predecessor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vertice<?> vertice = (Vertice<?>) o;
        return Objects.equals(dado, vertice.dado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dado);
    }
}
