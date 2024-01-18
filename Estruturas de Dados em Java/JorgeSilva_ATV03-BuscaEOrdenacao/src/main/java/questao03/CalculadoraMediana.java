/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao03;

/**
 *
 * @author jorge
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import lista.ListaLigada;
import lista.Elemento;
import java.util.Comparator;

public class CalculadoraMediana {

    public static void main(String[] args) throws IOException {
        // 1. Ler o arquivo TXT para obter os números
        BufferedReader leitor = new BufferedReader(new FileReader("src\\\\\\\\main\\\\\\\\java\\\\\\\\entrada\\\\\\\\EntradaQ3.txt"));
        String linha = leitor.readLine().replaceAll("\\[", "").replaceAll("\\]", "");
        String[] numerosString = linha.split(", ");
        
        // 2. Inserir os números na ListaLigada
        ListaLigada<Integer> lista = new ListaLigada<>();
        for(String numeroString : numerosString) {
            lista.adicionar(Integer.parseInt(numeroString));
        }
        
        leitor.close();

        // 3. Ordenar os números usando Bubble Sort adaptado para listas ligadas
        ordenacaoBubble(lista);
        
        // 4. Determinar a mediana
        System.out.println("Mediana: " + calcularMediana(lista));
    }

    public static double calcularMediana(ListaLigada<Integer> lista) {
        int n = lista.getTamanho();
        if (n % 2 == 0) {
            return (lista.get(n/2 - 1) + lista.get(n/2)) / 2.0;
        } else {
            return lista.get(n/2);
        }
    }

    public static void ordenacaoBubble(ListaLigada<Integer> lista) {
        if (lista.getTamanho() < 2) return; 

        boolean trocou;
        do {
            trocou = false;
            Elemento<Integer> atual = lista.getPrimeiro();
            Elemento<Integer> proximo = atual.getProximo();
            Elemento<Integer> anterior = null;
            while (proximo != null) {
                if (atual.getValor() > proximo.getValor()) {
                    trocou = true;
                    if (anterior != null) {
                        anterior.setProximo(proximo);
                    } else {
                        lista.setPrimeiro(proximo);
                    }
                    atual.setProximo(proximo.getProximo());
                    proximo.setProximo(atual);
                    anterior = proximo;
                    proximo = atual.getProximo();
                } else {
                    anterior = atual;
                    atual = proximo;
                    proximo = proximo.getProximo();
                }
            }
        } while (trocou);
    }
}
