package questao01;

/**
 *
 * @author jorge
 */
import java.util.Random;

public class QuickInsertionSort {

    private static final int LIMIAR_ORDENACAO_INSERCAO = 10;
    public static void ordenar(int[] vetor) {
        ordenacaoRapidaInsercao(vetor, 0, vetor.length - 1);
    }
    private static void ordenacaoRapidaInsercao(int[] vetor, int inicio, int fim) {
        int tamanho = fim - inicio + 1;

        if (tamanho < LIMIAR_ORDENACAO_INSERCAO) {
            ordenacaoInsercao(vetor, inicio, fim);
        } else {
            if (inicio < fim) {
                int pivo = particionar(vetor, inicio, fim);
                ordenacaoRapidaInsercao(vetor, inicio, pivo - 1);
                ordenacaoRapidaInsercao(vetor, pivo + 1, fim);
            }
        }
    }

    private static void ordenacaoInsercao(int[] vetor, int inicio, int fim) {
        for (int i = inicio + 1; i <= fim; i++) {
            int chave = vetor[i];
            int j = i - 1;
            while (j >= inicio && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = chave;
        }
    }
    private static int particionar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[fim];
        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            if (vetor[j] <= pivo) {
                i++;
                trocar(vetor, i, j);
            }
        }
        trocar(vetor, i + 1, fim);
        return i + 1;
    }

    private static void trocar(int[] vetor, int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }
    public static void main(String[] args) {
        int[] vetor = new int[15];
        Random random = new Random();
        // Preenchendo o vetor com valores aleatórios entre 1 e 100
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(100) + 1;
        }
        // Imprimindo o vetor original
        System.out.println("Vetor original:");
        for (int valor : vetor) {
            System.out.print(valor + " ");
        }
        System.out.println();
        ordenar(vetor);
        // Imprimindo o vetor ordenado
        System.out.println("Vetor ordenado:");
        for (int valor : vetor) {
            System.out.print(valor + " ");
        }
    }
}
