/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao02;

import questao01.Grafo;

/**
 *
 * @author jorge
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TesteDetectorDeCiclos {

    public static Grafo<String> lerGrafoDeArquivo(String nomeDoArquivo) throws IOException {
        Grafo<String> grafo = new Grafo<>();

        try ( BufferedReader br = new BufferedReader(new FileReader(nomeDoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 2) {
                    String vertice1 = partes[0].trim();
                    String vertice2 = partes[1].trim();

                    grafo.adicionarVertice(vertice1);
                    grafo.adicionarVertice(vertice2);
                    grafo.adicionarArestaNaoDirecionada(1.0, vertice1, vertice2);
                }
            }
        }

        return grafo;
    }

    public static void main(String[] args) {
        try {
            Grafo<String> grafo = lerGrafoDeArquivo("src/main/java/entrada/EntradaQ2.txt");
            DetectorDeCiclos<String> detector = new DetectorDeCiclos<>(grafo);
            boolean possuiCiclo = detector.detectarCiclos();

            System.out.println("O grafo possui ciclo? " + possuiCiclo);
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
