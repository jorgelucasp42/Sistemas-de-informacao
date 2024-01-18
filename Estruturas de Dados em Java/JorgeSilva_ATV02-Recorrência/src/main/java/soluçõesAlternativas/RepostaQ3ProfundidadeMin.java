/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soluçõesAlternativas;

/**
 *
 * @author jorge
 */
public class RepostaQ3ProfundidadeMin {
    
    public static int profundidadeMinima(NoArvore raiz) {
        if (raiz == null) {
            return 0;
        }

        if (raiz.esquerda == null && raiz.direita == null) {
            return 1;
        }

        int profundidadeEsquerda = Integer.MAX_VALUE; 
        int profundidadeDireita = Integer.MAX_VALUE;  


        if (raiz.esquerda != null) {
            profundidadeEsquerda = profundidadeMinima(raiz.esquerda);
        }

        if (raiz.direita != null) {
            profundidadeDireita = profundidadeMinima(raiz.direita);
        }

        return Math.min(profundidadeEsquerda, profundidadeDireita) + 1;
    }

    public static void main(String[] args) {
        NoArvore raiz = new NoArvore(1);
        raiz.esquerda = new NoArvore(2);
        raiz.direita = new NoArvore(3);
        raiz.esquerda.esquerda = new NoArvore(4);
        raiz.esquerda.direita = new NoArvore(5);
        raiz.direita.esquerda = new NoArvore(6);  
        raiz.direita.direita = new NoArvore(7);  
        raiz.esquerda.esquerda.direita = new NoArvore(8); 
        raiz.esquerda.direita.direita = new NoArvore(9); 
        raiz.direita.direita.esquerda = new NoArvore(10);  
        raiz.direita.direita.direita = new NoArvore(11);  
        raiz.esquerda.esquerda.direita.direita = new NoArvore(12);
        
        System.out.println(profundidadeMinima(raiz));
    }
}
