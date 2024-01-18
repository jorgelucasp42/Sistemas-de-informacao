/*
 * Clique em nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para alterar esta licença
 * Clique em nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar este modelo
 */
package questao05;

/**
 *
 * @author jorge
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class MesclarEOrdenar {
    public static void main(String[] args) {
        try {
            BufferedReader leitor = new BufferedReader(new FileReader("src\\\\main\\\\java\\\\entrada\\\\EntradaQ5.txt"));
            int[] X = converterParaVetor(leitor.readLine());
            int[] Y = converterParaVetor(leitor.readLine());

            mesclar(X, Y);

            ordenacaoRapida(X, 0, X.length - 1);

            for (int i : X) {
                System.out.print(i + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] converterParaVetor(String linha) {
        StringTokenizer st = new StringTokenizer(linha, ",");
        int[] vetor = new int[st.countTokens()];
        int idx = 0;
        while (st.hasMoreTokens()) {
            vetor[idx++] = Integer.parseInt(st.nextToken().trim());
        }
        return vetor;
    }

    public static void mesclar(int[] X, int[] Y) {
        int idx = 0;
        for (int i = 0; i < X.length; i++) {
            if (X[i] == 0) {
                X[i] = Y[idx++];
            }
        }
    }

    public static void ordenacaoRapida(int[] vetor, int baixo, int alto) {
        if (baixo < alto) {
            int indicePivo = particionar(vetor, baixo, alto);
            ordenacaoRapida(vetor, baixo, indicePivo - 1);
            ordenacaoRapida(vetor, indicePivo + 1, alto);
        }
    }

    public static int particionar(int[] vetor, int baixo, int alto) {
        int pivo = vetor[alto];
        int i = (baixo - 1);
        for (int j = baixo; j < alto; j++) {
            if (vetor[j] < pivo) {
                i++;
                trocar(vetor, i, j);
            }
        }
        trocar(vetor, i + 1, alto);
        return i + 1;
    }

    public static void trocar(int[] vetor, int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }
}
