/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao02;

/**
 *
 * @author jorge
 */

import lista.IteratorListaLigada;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        ListaLigadaOrdenada<Produto> lista = new ListaLigadaOrdenada<>();
        String arquivo = "src\\\\main\\\\java\\\\entrada\\\\EntradaQ2.txt";
        // Ler arquivo e adicionar produtos à lista
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                int id = Integer.parseInt(partes[0]);
                String descricao = partes[1];
                double valor = Double.parseDouble(partes[2]);
                lista.adicionar(new Produto(id, descricao, valor));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Comparator<Produto> sortByDescription = Comparator.comparing(Produto::getDescricao);
        Comparator<Produto> sortByValueAscending = Comparator.comparingDouble(Produto::getValor);
        Comparator<Produto> sortByValueDescending = sortByValueAscending.reversed();

        System.out.println("Ordenando por descrição:");
        lista.sort(sortByDescription);
        printList(lista);

        System.out.println("Ordenando por valor crescente:");
        lista.sort(sortByValueAscending);
        printList(lista);

        System.out.println("Ordenando por valor decrescente:");
        lista.sort(sortByValueDescending);
        printList(lista);
    }

  public static void printList(ListaLigadaOrdenada<Produto> lista) {
    IteratorListaLigada<Produto> iterator = lista.getIterator(); // Use o método getIterator() da lista
    while (iterator.temProximo()) {
        Produto p = iterator.getProximo().getValor();
        System.out.println(p.getId() + ", " + p.getDescricao() + ", " + p.getValor());
    }
    System.out.println("----------------------");
}

}
  
