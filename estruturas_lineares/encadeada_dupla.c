#include <stdio.h>
#include <stdlib.h>
//

typedef struct no{
    struct no* prox;
    struct no* past;
    int valor;
} no;


void mostrar_outros(no* lista, int prox){
    if (lista == NULL){
        return;
    }

    no* next = lista;
    while (next != NULL){
        printf("[%d] <-> ", next->valor, next->past);
        if (prox == 1){
            next = next->prox;
        }
        else{
            next = next->past;
        }
    }
    printf("\n");
}

void mostrar_todos(no* lista){
    printf("Proximos: ");
    mostrar_outros(lista, 1);
    
    printf("Passados: ");
    mostrar_outros(lista, 0);
}

void mostrar_si(no* no){
    if (no == NULL){
        return;
    }
    int valor_previo = 0;
    int valor_futuro = 0;
    if (no->past != NULL){
        valor_previo = no->past->valor;
    }
    if (no->prox != NULL){
        valor_futuro = no->prox->valor;
    }

    printf("[%d] <- [%d] -> [%d]\n", valor_previo, no->valor, valor_futuro);
}



void adicionar(no* lista, int valor){
    no* next = lista;
    while (next->prox != NULL){
        next = next->prox;
    }

    no* novo = malloc(sizeof(no));
    novo->valor = valor;
    novo->prox = NULL;
    novo->past = next;

    next->prox = novo;
}

void ranoicida(no* lista, int valor){
    no* next = lista;
    while (next->past != NULL){
        next = next->past;
    }

    no* novo = malloc(sizeof(no));
    novo->valor = valor;
    novo->prox = next;
    novo->past = NULL;

    next->past = novo;
}

no* criar(int valor){
    no* novo = malloc(sizeof(no));
    novo->valor = valor;
    novo->prox = NULL;
    novo->past = NULL;

    return novo;
}

void stalin(no* lista, int errados){
    if (lista == NULL) return;

    no* cur = lista->prox;
    while (cur != NULL){
        no* pp = cur->prox;

        if(cur->valor == errados){
            cur->past->prox = pp;

            if (pp != NULL) pp->past = cur->past;
            
            free(cur);
        }
        cur = pp;
    }

    cur = lista->past;
    while (cur != NULL){
        no* pp = cur->past;

        if(cur->valor == errados){
            cur->prox->past = pp;

            if (pp != NULL) pp->prox = cur->prox;
        
            free(cur);
        }
        cur = pp;
    }

    if (lista->valor == errados){
        lista->valor++;
    }

}


int main(){
    no* lista = criar(0);

    for (int i = 1 ; i < 10; i++){
        adicionar(lista, i);
        ranoicida(lista, i);
    }

    mostrar_todos(lista);
    stalin(lista, 5);
    stalin(lista, 8);
    mostrar_todos(lista);

    return 0;
}
