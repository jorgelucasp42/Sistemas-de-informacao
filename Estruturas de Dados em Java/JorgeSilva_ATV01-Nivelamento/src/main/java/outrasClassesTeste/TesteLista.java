
package outrasClassesTeste;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import questao1ABC_Lista_Pilha_Fila.Elemento;
import questao1ABC_Lista_Pilha_Fila.ListaLigada;

public class TesteLista {

    public static void main(String[] args){
        ListaLigada<String> lista = new ListaLigada<String>();
       
        String nomeArquivo = "C:\\\\Users\\\\jorge\\\\OneDrive\\\\Documentos\\\\NetBeansProjects\\\\JorgeSilva_ATV01\\\\src\\\\main\\\\java\\\\entradaATV01\\\\Entrada.txt";
        
        try ( BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                lista.adicionar(linha.trim()); 
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        
        System.out.println("Tamanho: "+lista.getTamanho());
        lista.imprimirPrimeiroEUltimo();

        
        for(int i=0; i<lista.getTamanho(); i++){
            System.out.println(lista.get(i).getValor());
        }
                
        lista.remover("CE");
        
        
        for(int i=0; i<lista.getTamanho(); i++){
            System.out.println(lista.get(i).getValor());
        }
        
       

        lista.remover("AC");
        lista.remover("BA");
        lista.remover("DF");
       
        lista.adicionar("RJ");
        
        System.out.println("Tamanho: "+lista.getTamanho());
      
   
           
        for (int i = 0; i < lista.getTamanho(); i++) {
            Elemento<String> elem = lista.get(i);
            if (elem != null) {
                System.out.println(elem.getValor());
            }
        }
        
        lista.imprimirPrimeiroEUltimo();
        
        lista.adicionar("MA");
        lista.adicionar("BA");
        lista.adicionar("SE");
        lista.adicionar("RN");
        
        lista.imprimir(); 

        lista.imprimirPrimeiroEUltimo();

      
        Elemento<String> elementoEncontrado = lista.buscar("SE");
        if (elementoEncontrado != null) {
            System.out.println("Elemento encontrado: " + elementoEncontrado.getValor());
        } else {
            System.out.println("Elemento não encontrado.");
        }

     
        elementoEncontrado = lista.buscar("PE");
        if (elementoEncontrado != null) {
            System.out.println("Elemento encontrado: " + elementoEncontrado.getValor());
        } else {
            System.out.println("Elemento não encontrado.");
        }

    }
    
}
