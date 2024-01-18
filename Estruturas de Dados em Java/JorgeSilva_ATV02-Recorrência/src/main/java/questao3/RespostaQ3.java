/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao3;

/**
 *
 * @author jorge
 */
public class RespostaQ3 {


    public static void main(String[] args) {
        Arvore<Integer> minhaArvore = new Arvore<>();
        
        minhaArvore.adicionar(5);
        minhaArvore.adicionar(2);
        minhaArvore.adicionar(3);
        minhaArvore.adicionar(4);
        minhaArvore.adicionar(1);
        minhaArvore.adicionar(6);
        minhaArvore.adicionar(7);
        minhaArvore.adicionar(8);
        minhaArvore.adicionar(13);
       
        
        System.out.println("A profundidade da árvore é: " + minhaArvore.profundidade());
    }

}

//Observação: considerando que a estrutura abstrata ordena por comparação os números na árvore, se o números fornecidos forem sequenciais a arvore ficará desbalanceada
//podendo tomar forma até mesmo de uma lista ligada. Solução alternativa apresentada em outro pacote. 