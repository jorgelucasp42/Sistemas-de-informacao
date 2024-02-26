/*
 No presente programa é possível adicionar mais que 1 entrada através da manipulação do arquivo EntradaQ2.txt. 
 Assim, em cada linha do arquivo de EntradaQ2 será possível adicionar uma sequência de números em nova linha,
 que será interpretada como um nova entrada para leitura e análise de valores duplicados.
 */
package questao02;

import questao01.TabelaHash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class EncontrarDuplicados {

    public static void main(String[] args) {
        String filename = "src/main/java/entrada/EntradaQ2.txt"; 
        int entradaCont = 0;  //contador de linhas de entrada

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                entradaCont++;  // Incrementa no começo do loop

                line = line.trim();  // Remove espaços em branco no início e no final da linha
                if (line.isEmpty()) {
                    throw new EmptyLineException("Linha vazia encontrada na entrada " + entradaCont + ".");
                }

                if (!line.matches("((-?\\d+\\s*,\\s*)*-?\\d+)?")) {
                    throw new InvalidFileFormatException("Formato de linha inválido na entrada " + entradaCont + ": " + line);
                }

                int[] arr = Arrays.stream(line.split(","))
                        .map(String::trim)
                        .mapToInt(Integer::parseInt)
                        .toArray();

                System.out.print("Entrada " + entradaCont + " - Duplicados: ");  
                encontrarDuplicados(arr);
                System.out.println();
            }
        } catch (IOException | InvalidFileFormatException | EmptyLineException e) {
            System.out.println(e.getMessage());
            if (e instanceof InvalidFileFormatException || e instanceof EmptyLineException) {
                System.out.println("Por favor, formate arquivo de texto a partir da linha acima e execute o programa novamente!");
            }
        }
        
    }

    public static void encontrarDuplicados(int[] arr) {
        TabelaHash<Integer, Integer> tabela = new TabelaHash<>();

        for (int num : arr) {
            if (tabela.buscar(num) == null) {
                tabela.inserir(num, 1);
            } else {
                tabela.inserir(num, tabela.buscar(num) + 1);
            }
        }

        boolean possuiDuplicados = false;
        for (int num : arr) {
            Integer count = tabela.buscar(num);
            if (count != null && count > 1) {
                System.out.print(num + " ");
                tabela.remover(num);
                possuiDuplicados = true;
            }
        }

        if (!possuiDuplicados) {
            System.out.print("Nenhum elemento duplicado!");
        }
    }

    static class InvalidFileFormatException extends Exception {
        public InvalidFileFormatException(String message) {
            super(message);
        }
    }

    static class EmptyLineException extends Exception {
        public EmptyLineException(String message) {
            super(message);
        }
    }
}
