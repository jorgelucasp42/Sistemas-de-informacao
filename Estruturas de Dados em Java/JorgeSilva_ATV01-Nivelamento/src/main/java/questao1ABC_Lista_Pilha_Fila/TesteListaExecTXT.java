/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao1ABC_Lista_Pilha_Fila;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class TesteListaExecTXT {
    public static void main(String[] args){
        ListaLigada<String> lista = new ListaLigada<String>();
       
        String arquivoEntrada = "src\\\\main\\\\java\\\\entradaATV01\\\\Entrada.txt";
        String arquivoExecucao = "src\\\\main\\\\java\\\\entradaATV01\\\\ExecListaArvore.txt";


        try (BufferedReader br = new BufferedReader(new FileReader(arquivoEntrada))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                lista.adicionar(linha.trim()); 
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de entrada: " + e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoExecucao))) {
            String comando;
            while ((comando = br.readLine()) != null) {
                String[] partes = comando.split(",");
                switch (partes[0].trim().toUpperCase()) {
                    case "INSERIR":
                        lista.adicionar(partes[1].trim());
                        break;
                    case "REMOVER":
                        lista.remover(partes[1].trim());
                        break;
                    case "IMPRIMIR":
                        lista.imprimir();
                        break;
                    case "BUSCAR":
                        Elemento<String> elementoEncontrado = lista.buscar(partes[1].trim());
                        if (elementoEncontrado != null) {
                            System.out.println("Elemento encontrado: " + elementoEncontrado.getValor());
                        } else {
                            System.out.println("Elemento não encontrado.");
                        }
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de execução: " + e.getMessage());
        }
    }
    
}
