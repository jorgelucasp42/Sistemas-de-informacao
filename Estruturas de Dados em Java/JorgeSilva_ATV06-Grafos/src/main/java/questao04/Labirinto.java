/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao04;

/**
 *
 * @author jorge
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import questao01.Grafo;

public class Labirinto {

    public static void main(String[] args) {
        String filePath = "src\\main\\java\\entrada\\EntradaQ4.txt";
        try {
            List<String> linhas = Files.readAllLines(Paths.get(filePath));
            Grafo<Integer> grafo = new Grafo<>();
            int largura = linhas.get(0).length();
            int altura = linhas.size();
            int[][] matriz = new int[altura][largura];

            // Inicializar o grafo com todos os vértices e a matriz de identificação
            int id = 0;
            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < largura; j++) {
                    grafo.adicionarVertice(id);
                    matriz[i][j] = id++;
                }
            }

            // Conectar os vértices com arestas apenas se não for uma parede (X)
            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < largura; j++) {
                    if (linhas.get(i).charAt(j) != 'X') {
                        // Conectar verticalmente
                        if (i < altura - 1 && linhas.get(i + 1).charAt(j) != 'X') {
                            grafo.adicionarArestaNaoDirecionada(1.0, matriz[i][j], matriz[i + 1][j]);
                        }
                        // Conectar horizontalmente
                        if (j < largura - 1 && linhas.get(i).charAt(j + 1) != 'X') {
                            grafo.adicionarArestaNaoDirecionada(1.0, matriz[i][j], matriz[i][j + 1]);
                        }
                    }
                }
            }

            // Encontrar os IDs de entrada (E) e saída (S)
            int inicioId = -1;
            int fimId = -1;
            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < largura; j++) {
                    if (linhas.get(i).charAt(j) == 'E') {
                        inicioId = matriz[i][j];
                    } else if (linhas.get(i).charAt(j) == 'S') {
                        fimId = matriz[i][j];
                    }
                }
            }

            // Executar a busca em largura (BFS)
            BuscaEmLargura<Integer> busca = new BuscaEmLargura<>();
            List<Integer> caminho = busca.buscarCaminhoBFS(grafo, inicioId, fimId);

            // Imprimir o caminho encontrado
            if (caminho != null) {
                System.out.println("Caminho encontrado: " + caminho);
            } else {
                System.out.println("Caminho não encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
