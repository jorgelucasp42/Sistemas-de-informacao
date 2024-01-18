/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao1;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RespostaQ1 {
     public static void main(String[] args) {
        String caminhoArquivo = "src\\\\main\\\\java\\\\entrada\\\\Entrada1.txt";
                
        ListaLigada<Integer> lista = lerNumerosDoArquivo(caminhoArquivo);
        int totalUm = contarUm(lista.getPrimeiro(), lista.getTamanho());
        System.out.println("Total de 1s no arquivo: " + totalUm);
    }

    public static ListaLigada<Integer> lerNumerosDoArquivo(String caminhoArquivo) {
        ListaLigada<Integer> lista = new ListaLigada<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                lista.adicionar(Integer.parseInt(linha.trim()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static int contarUm(Elemento<Integer> inicio, int tamanho) {
        if (tamanho == 1) {
            return inicio.getValor() == 1 ? 1 : 0;
        }

        int metade = tamanho / 2;
        Elemento<Integer> meio = inicio;
        for (int i = 0; i < metade; i++) {
            meio = meio.getProximo();
        }

        int contagemEsquerda = contarUm(inicio, metade);
        int contagemDireita = contarUm(meio, tamanho - metade);

        return contagemEsquerda + contagemDireita;
    }
}
