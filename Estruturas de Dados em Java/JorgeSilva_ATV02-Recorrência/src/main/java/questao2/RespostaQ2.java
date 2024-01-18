package questao2;

import java.util.*;
import java.io.*;

public class RespostaQ2 {

    public static class Ponto implements Comparable<Ponto> {
        double x, y;

        public Ponto(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Ponto o) {
            return Double.compare(this.x, o.x);
        }
    }

    public static class ParPontos {
        Ponto ponto1;
        Ponto ponto2;

        public ParPontos(Ponto ponto1, Ponto ponto2) {
            this.ponto1 = ponto1;
            this.ponto2 = ponto2;
        }
    }

    public static class Resultado {
        List<ParPontos> pares = new ArrayList<>();
        double distancia;

        public void adicionarPar(Ponto p1, Ponto p2, double dist) {
            if (dist < this.distancia || this.pares.isEmpty()) {
                this.distancia = dist;
                this.pares.clear();
            }
            if (dist == this.distancia) {
                this.pares.add(new ParPontos(p1, p2));
            }
        }
    }

    public static double distancia(Ponto a, Ponto b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    public static Resultado pontosMaisProximosRec(Ponto[] pontosX, Ponto[] pontosY) {
        Resultado resultado = new Resultado();

        if (pontosX.length <= 3) {
            for (int i = 0; i < pontosX.length; i++) {
                for (int j = i + 1; j < pontosX.length; j++) {
                    double currDist = distancia(pontosX[i], pontosX[j]);
                    resultado.adicionarPar(pontosX[i], pontosX[j], currDist);
                }
            }
            return resultado;
        }

        int meio = pontosX.length / 2;
        Ponto pontoMedio = pontosX[meio];

        Ponto[] yEsquerda = new Ponto[meio];
        Ponto[] yDireita = new Ponto[pontosX.length - meio];
        int esqIdx = 0, dirIdx = 0;
        for (int i = 0; i < pontosX.length; i++) {
            if (pontosY[i].x < pontoMedio.x)
                yEsquerda[esqIdx++] = pontosY[i];
            else
                yDireita[dirIdx++] = pontosY[i];
        }

        Resultado resultadoEsquerda = pontosMaisProximosRec(Arrays.copyOfRange(pontosX, 0, meio), yEsquerda);
        Resultado resultadoDireita = pontosMaisProximosRec(Arrays.copyOfRange(pontosX, meio, pontosX.length), yDireita);

        if (resultadoEsquerda.distancia < resultadoDireita.distancia) {
            resultado = resultadoEsquerda;
        } else if (resultadoEsquerda.distancia > resultadoDireita.distancia) {
            resultado = resultadoDireita;
        } else { 
            resultado.distancia = resultadoEsquerda.distancia;
            resultado.pares.addAll(resultadoEsquerda.pares);
            resultado.pares.addAll(resultadoDireita.pares);
        }

        List<Ponto> faixa = new ArrayList<>();
        for (int i = 0; i < pontosX.length; i++) {
            if (Math.abs(pontosY[i].x - pontoMedio.x) < resultado.distancia) {
                faixa.add(pontosY[i]);
            }
        }

        for (int i = 0; i < faixa.size(); i++) {
            for (int j = i + 1; j < faixa.size() && (faixa.get(j).y - faixa.get(i).y) < resultado.distancia; j++) {
                double d = distancia(faixa.get(i), faixa.get(j));
                resultado.adicionarPar(faixa.get(i), faixa.get(j), d);
            }
        }

        return resultado;
    }

    public static Resultado pontosMaisProximos(Ponto[] pontos) {
        Ponto[] pontosPorX = pontos.clone();
        Ponto[] pontosPorY = pontos.clone();

        Arrays.sort(pontosPorX);
        Arrays.sort(pontosPorY, (a, b) -> Double.compare(a.y, b.y));

        return pontosMaisProximosRec(pontosPorX, pontosPorY);
    }

    public static void main(String[] args) throws FileNotFoundException {
        String caminhoArquivo = "C:src\\\\main\\\\java\\\\entrada\\\\Entrada2.txt";
        
        Scanner scanner = new Scanner(new File(caminhoArquivo));
        List<Ponto> pontos = new ArrayList<>();

        while (scanner.hasNext()) {
            String linha = scanner.nextLine().replace("(", "").replace(")", "");
            String[] coordenadas = linha.split(",");
            pontos.add(new Ponto(Double.parseDouble(coordenadas[0]), Double.parseDouble(coordenadas[1])));
        }

        Ponto[] arrayPontos = pontos.toArray(new Ponto[0]);
        Resultado resultado = pontosMaisProximos(arrayPontos);
        
        for (ParPontos par : resultado.pares) {
            System.out.println("Os pontos  (" + par.ponto1.x + "," + par.ponto1.y + ") e (" 
                           + par.ponto2.x + "," + par.ponto2.y + ") são os mais próximos pois a distância entre eles é de: " 
                           + resultado.distancia);
        }

        if (resultado.pares.size() > 1) {
            System.out.println("Conclui-se que há múltiplos pares de pontos equidistantes.");
        }
    }
}
