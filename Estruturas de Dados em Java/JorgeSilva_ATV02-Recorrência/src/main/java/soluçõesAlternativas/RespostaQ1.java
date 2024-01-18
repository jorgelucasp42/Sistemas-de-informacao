
package soluçõesAlternativas;

public class RespostaQ1 {

    public static int contaUm(int[] numeros, int inicio, int fim)
    {
        
        if (numeros == null || numeros.length == 0) {
            return 0;
        }
 
        if (numeros[fim] == 0) {
            return 0;
        }
 
        if (numeros[inicio] == 1) {
            return (fim - inicio + 1);
        }

        int meio = (inicio + fim) / 2;
        return contaUm(numeros, inicio, meio) + contaUm(numeros, meio + 1, fim);
    }
 
    public static void main(String[] args)
    {
        int[] numeros = { 0, 0, 0, 0, 1, 1, 1 };
 
        System.out.println("O total de 1's presente é "
                                    + contaUm(numeros, 0, numeros.length - 1));
    }
}
