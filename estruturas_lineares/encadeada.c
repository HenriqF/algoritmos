#include <stdio.h>
#include <stdlib.h>

typedef struct no{
    struct no* prox;
    int valor;
} no;


void mostrar(no* lista){
    if (lista == NULL){
        return;
    }

    no* next = lista;
    while (next != NULL){
        printf("%d -> ", next->valor);
        next = next->prox;
    }
    printf("\n");
}

void adicionar(no* lista, int valor){
    no* next = lista;
    while (next->prox != NULL){
        next = next->prox;
    }

    no* novo = malloc(sizeof(no));
    novo->valor = valor;
    novo->prox = NULL;

    next->prox = novo;
}

void matar(no* lista, int profundidade){
    no* next = lista;
    profundidade--;

    while (next->prox != NULL && profundidade > 0){
        next = next->prox;
        profundidade--;
    }
    if (profundidade > 0){
        return;
    }

    no* sep = next;
    next = next->prox;
    sep->prox = NULL;

    while(next != NULL){
        no* aura = next;
        next = next->prox;
        free(aura);
    }
}

void inverter(no** lista){
    no* temp = NULL;
    no* resto = NULL;

    while((*lista) != NULL){
        resto = (*lista)->prox;
        (*lista)->prox = temp;
        temp = (*lista);
        (*lista) = resto;
    }

    (*lista) = temp;

}

no* criar(int valor){
    no* novo = malloc(sizeof(no));
    novo->valor = valor;
    novo->prox = NULL;

    return novo;
}

int main(){
    no* lista = criar(0);
    for (int i = 1; i <= 10; i++){
        adicionar(lista, i);
    }

    mostrar(lista);

    matar(lista, 5);

    mostrar(lista);

    inverter(&lista);

    mostrar(lista);
    return 0;
}
