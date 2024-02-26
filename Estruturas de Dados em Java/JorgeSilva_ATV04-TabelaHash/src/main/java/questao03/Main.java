/*
 Método principal com resolução da questão 3. O programa lê o arquivo de entrada e executa as funções conforme
 determinado em EXEC
 */
package questao03;

/**
 *
 * @author jorge
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import questao01.TabelaHash;

public class Main {

    public static void main(String[] args) {
        TabelaHash<Integer, Cliente> tabelaHash = new TabelaHash<>();

        // Lendo e inserindo clientes a partir do arquivo EntradaQ3.txt
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/entrada/EntradaQ3.txt"), "UTF-8"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(",");
                if (campos.length != 4) {
                    System.out.println("Linha com formato inválido: " + linha);
                    continue; // Pula para a próxima linha
                }

                try {
                    int id = Integer.parseInt(campos[0].trim());
                    Cliente cliente = new Cliente(id, campos[1].trim(), campos[2].trim(), campos[3].trim());
                    tabelaHash.inserir(id, cliente);
                } catch (NumberFormatException e) {
                    System.out.println("Erro ao converter o ID para um número na linha: " + linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro na leitura do arquivo de Entrada: " + e.getMessage());
        }

        // Processando operações do arquivo ExeqQ3.txt
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/entrada/ExecQ3.txt"), "UTF-8"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(" ");
                switch (campos[0].trim().toUpperCase()) {
                    case "INSERIR":
                        int id = Integer.parseInt(campos[1]);
                        String nome = linha.split(id + " ")[1].split(" ")[0] + " " + linha.split(id + " ")[1].split(" ")[1];
                        String email = linha.split(nome + " ")[1].split(" ")[0];
                        String cidade = linha.split(email + " ")[1];
                        Cliente cliente = new Cliente(id, nome, email, cidade);
                        tabelaHash.inserir(cliente.id, cliente);
                        break;
                    case "REMOVER":
                    try {
                        int idRemover = Integer.parseInt(campos[1]);
                        tabelaHash.remover(idRemover);
                    } catch (NumberFormatException e) {
                        System.out.println("Erro ao converter o ID para um número na operação REMOVER: " + campos[1]);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    case "BUSCAR":
                        int idBuscar = Integer.parseInt(campos[1]);
                        Cliente clienteBuscado = tabelaHash.buscar(idBuscar);
                        if (clienteBuscado != null) {
                            System.out.println(clienteBuscado);
                        } else {
                            System.out.println("Cliente com ID " + idBuscar + " não encontrado.");
                        }
                        break;
                    case "IMPRIMIR":
                        tabelaHash.imprimir();
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro na leitura do arquivo ExeqQ3.txt: " + e.getMessage());
        }
    }
}
