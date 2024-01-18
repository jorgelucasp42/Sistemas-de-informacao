package questao04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ColecaoOrdenada {

    // Método de inserção (Insertion Sort) para ordenação crescente
    private static void ordenacaoPorInsercaoCrescente(List<Integer> lista) {
        for (int i = 1; i < lista.size(); i++) {
            int chave = lista.get(i);
            int j = i - 1;
            while (j >= 0 && lista.get(j) > chave) {
                lista.set(j + 1, lista.get(j));
                j = j - 1;
            }
            lista.set(j + 1, chave);
        }
    }

    // Método de inserção (Insertion Sort) para ordenação decrescente
    private static void ordenacaoPorInsercaoDecrescente(List<Integer> lista) {
        for (int i = 1; i < lista.size(); i++) {
            int chave = lista.get(i);
            int j = i - 1;
            while (j >= 0 && lista.get(j) < chave) {
                lista.set(j + 1, lista.get(j));
                j = j - 1;
            }
            lista.set(j + 1, chave);
        }
    }

    public static void main(String[] args) {
        List<Integer> impares = new ArrayList<>();
        List<Integer> pares = new ArrayList<>();

        // 1. Ler os números de um arquivo de texto e classificá-los como pares ou ímpares.
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src\\\\main\\\\java\\\\entrada\\\\EntradaQ4.txt"));
            String line = reader.readLine();
            line = line.replace("{", "").replace("}", "");
            StringTokenizer st = new StringTokenizer(line, ",");
            while (st.hasMoreTokens()) {
                int valor = Integer.parseInt(st.nextToken().trim());
                if (valor % 2 == 0) {
                    pares.add(valor);
                } else {
                    impares.add(valor);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Ordenar os números usando o método de inserção.
        ordenacaoPorInsercaoDecrescente(impares); // Ordena os ímpares em ordem decrescente
        ordenacaoPorInsercaoCrescente(pares); // Ordena os pares em ordem crescente

        // 3. Imprimir os números em um formato combinado.
        impares.addAll(pares); // Combina as duas listas
        System.out.println("{" + String.join(", ", impares.stream().map(String::valueOf).toArray(String[]::new)) + "}");
    }
}
