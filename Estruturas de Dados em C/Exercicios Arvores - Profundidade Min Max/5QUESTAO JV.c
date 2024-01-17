#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <locale.h>
#include <unistd.h>

#define MAX 10
#define REP 5

typedef struct {
    int data;
} elemento;

#include "tad_tree.h"

int comparaelementos(elemento item1, elemento item2) {
    return 0;
}

tree incluir(tree arv, int numero) {

    elemento e_numero;
    e_numero.data = numero;

    if (vazia(arv)) {
        criaRaiz(&arv, e_numero);
        printf("Criou o no raiz com %d\n",e_numero.data);
    } else {
        ptrNodo pai = arv;
        ptrNodo atual = arv;
        int esq;

        while (atual != NULL) {
            pai = atual;
            if (e_numero.data < atual->info.data) {
                atual = atual->esq;
                esq = 1;
            } else {
                atual = atual->dir;
                esq = 0;
            }

        }
        printf("esq e igual %d\n", esq);

        if (esq) {
            criarNodoEsq(pai, e_numero);
        } else {
            criarNodoDir(pai, e_numero);
        }
    }
    return arv;
}

int min(int a, int b) {
    return (a < b)? a : b;
}

int minNivel(tree t) {
    if (t == NULL)
        return 0;

    if (t->esq == NULL && t->dir == NULL)
        return 1;

    if (t->esq == NULL)
        return minNivel(t->dir) + 1;

    if (t->dir == NULL)
        return minNivel(t->esq) + 1;

    return min(minNivel(t->esq), minNivel(t->dir)) + 1;
}

int maxNivel(tree t) {
    if (t == NULL)
        return 0;
    else {
        int esqNivel = maxNivel(t->esq);
        int dirNivel = maxNivel(t->dir);

        if (esqNivel > dirNivel)
            return(esqNivel + 1);
        else return(dirNivel + 1);
    }
}


int main(){

    int vetorContadorDiferenca[MAX] = {0};  // inicializando o array de contagem de diferenças

    int i, j, num;

    setlocale(LC_ALL, "");
    srand(time(0));  // seed para a geração de números aleatórios

    for (i = 0; i < REP; i++) {

        tree arv;
        define(&arv);

        for (j = 0; j < MAX; j++) {
            num = rand() % MAX;  // inserindo número aleatório na árvore
            printf("%d\n",num);
            arv =incluir(arv, num);
        }

        int min = minNivel(arv);
        int max = maxNivel(arv);

        printf("[Repetição %d]\n", i+1);
        printf("Mínima Profundidade: %d\n", min);
        printf("Máxima Profundidade: %d\n", max);
        printf("\n");
        sleep(1);

        // Incrementa a contagem da diferença entre profundidades máxima e mínima
        vetorContadorDiferenca[max-min]++;

    }

    printf("\nDiferença | Contagem\n");
    printf("--------------------\n");
    for (int i = 0; i < MAX; i++) {
        if (vetorContadorDiferenca[i] != 0) {
            printf("%9d | %7d\n", i, vetorContadorDiferenca[i]);
        }
    }
    getchar();
    return 0;

}
