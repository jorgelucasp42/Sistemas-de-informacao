package questao1ABC_Lista_Pilha_Fila;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestePilhaExecTXT {

    public static void main(String[] args){
        Pilha pilha = new Pilha();
       
        String arquivoEntrada = "src\\\\main\\\\java\\\\entradaATV01\\\\Entrada.txt";
        String arquivoExecucao = "src\\\\main\\\\java\\\\entradaATV01\\\\ExecFilaPilha.txt";

        // Carregando os dados iniciais
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoEntrada))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                pilha.adicionar(linha.trim()); 
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de entrada: " + e.getMessage());
        }

        // Executando comandos do arquivo Exec.txt
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoExecucao))) {
            String comando;
            while ((comando = br.readLine()) != null) {
                String[] partes = comando.split(",");
                switch (partes[0].trim().toUpperCase()) {
                    case "INSERIR":
                        pilha.adicionar(partes[1].trim());
                        break;
                    case "REMOVER":
                        pilha.remover();
                        break;
                    case "IMPRIMIR":
                        pilha.imprimir();
                        break;
                    case "BUSCAR":
                        if (pilha.contem(partes[1].trim())) {
                            System.out.println("Elemento encontrado: " + partes[1].trim());
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
