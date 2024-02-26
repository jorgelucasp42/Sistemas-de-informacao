/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao05;

/**
 *
 * @author jorge
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import questao01.Grafo;

public class TesteGrafo {

    public static void main(String[] args) {
        Grafo<String> grafo = new Grafo<>();
        String caminhoArquivo = "src\\main\\java\\entrada\\EntradaQ5.txt"; // Substitua pelo caminho real

        try {
            List<String> linhas = Files.readAllLines(Paths.get(caminhoArquivo));

            if (linhas.size() < 3) {
                throw new IOException("Arquivo de entrada não contém dados suficientes.");
            }

            String origem = linhas.get(0);
            String destino = linhas.get(1);

            for (int i = 2; i < linhas.size(); i++) {
                String[] partes = linhas.get(i).split(";");
                if (partes.length < 3) {
                    throw new IllegalArgumentException("Formato de linha inválido: " + linhas.get(i));
                }
                String cidadeA = partes[0].trim();
                String cidadeB = partes[1].trim();
                double distancia = Double.parseDouble(partes[2].trim());

                grafo.adicionarVertice(cidadeA);
                grafo.adicionarVertice(cidadeB);
                grafo.adicionarAresta(distancia, cidadeA, cidadeB);
            }

            FloydWarshall<String> floydWarshall = new FloydWarshall<>(grafo);
            floydWarshall.executar();

            // Transforma a lista de Vertice<String> em uma lista de String
            List<String> nomesDasCidades = grafo.getVertices().stream()
                    .map(vertice -> vertice.getDado())
                    .collect(Collectors.toList());

            int indiceOrigem = nomesDasCidades.indexOf(origem);
            int indiceDestino = nomesDasCidades.indexOf(destino);
            if (indiceOrigem == -1 || indiceDestino == -1) {
                throw new IllegalArgumentException("Uma das cidades não existe no grafo.");
            }
            double distanciaTotal = floydWarshall.getDistancias()[indiceOrigem][indiceDestino];

            System.out.println("Distância total de " + origem + " para " + destino + ": " + distanciaTotal + " km");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
