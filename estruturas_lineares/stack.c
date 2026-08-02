#include <stdio.h>
#include <stdlib.h>

#define TAMANHO_SIG 20

typedef struct {
    int* itens;
    size_t tamanho;
    size_t topo;
} int_stack;

void mostrar(int_stack* stack){
    printf("(%zu %zu)[ ", stack->topo, stack->tamanho);

    for (size_t i = 0 ; i < stack->topo; i++){
        printf("%d ", stack->itens[i]);
    }
    printf("]\n");

}

int_stack* novo_stack(){
    int_stack* stack = malloc(sizeof(int_stack));
    stack->itens = malloc(TAMANHO_SIG*sizeof(int));
    stack->tamanho = TAMANHO_SIG;
    stack->topo = 0;
    return stack;
}

int crescer(int_stack* stack){

    int* re = realloc(stack->itens, (stack->tamanho*2) * sizeof(int));
    if (re == NULL){
        return -1;
    }

    stack->itens = re;
    stack->tamanho *= 2;

    return 0;
}

int add(int_stack* stack, int num){
    if (stack->topo >= stack->tamanho-1){
        int res = crescer(stack);
        if (res == -1) return res;
            
    }

    stack->itens[stack->topo++] = num;
    return 0;
}

int pop(int_stack* stack){
    if (stack->topo <= 0) return 0;

    return(stack->itens[--stack->topo]);
}

int ver(int_stack* stack){
    if (stack->topo <= 0) return 0;

    return(stack->itens[stack->topo-1]);
}

int main(){

    int_stack* stack = novo_stack();

    add(stack, 10);
    add(stack, 11);
    mostrar(stack);

    printf("%d\n", pop(stack));
    printf("%d\n", pop(stack));
    printf("%d\n", pop(stack));

    add(stack, 6);
    add(stack, 7);
    mostrar(stack);

    printf("%d\n", ver(stack));


    return 0;
}