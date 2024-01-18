/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao1D_arvore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TesteArvoreExecTXT {
    public static void main(String[] args) {
        Arvore<String> arvore = new Arvore<>();
        
        String arquivoEntrada = "src\\\\main\\\\java\\\\entradaATV01\\\\Entrada.txt";
        String arquivoExecucao = "src\\\\main\\\\java\\\\entradaATV01\\\\ExecListaArvore.txt";



        try (BufferedReader br = new BufferedReader(new FileReader(arquivoEntrada))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                arvore.adicionar(linha.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedReader br = new BufferedReader(new FileReader(arquivoExecucao))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                switch (partes[0].trim()) {
                    case "IMPRIMIR":
                        arvore.imprimir();
                        break;
                    case "INSERIR":
                        arvore.adicionar(partes[1].trim());
                        break;
                    case "REMOVER":
                        arvore.remover(partes[1].trim());
                        break;
                    case "BUSCAR":
                        boolean encontrado = arvore.buscar(partes[1].trim());
                        System.out.println("Buscar " + partes[1].trim() + ": " + (encontrado ? "Encontrado" : "Não Encontrado"));
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

