#include <stdio.h>
#include <stdlib.h>

void mostrar(int* nums, int qtd){
    printf("[ ");
    for (int i = 0 ; i < qtd; i++){
        printf("%d ", nums[i]);
    }
    printf("]\n");
}

int* merge_sort(int* nums, int qtd){
    if (qtd <= 1){
        return nums;
    }

    int la = qtd/2;
    int lb = qtd-la;

    int* na = malloc(la*sizeof(int));
    int* nb = malloc(lb*sizeof(int));

    int pos = 0;
    for (int i = 0; i < la; i++) na[i] = nums[pos++];
    for (int i = 0; i < lb; i++) nb[i] = nums[pos++];

    na = merge_sort(na, la);
    nb = merge_sort(nb, lb);

    int pa = 0, pb = 0; 
    pos = 0;
    while (pa < la && pb < lb){
        if (na[pa] <= nb[pb]){
            nums[pos++] = na[pa++];
        }
        else{
            nums[pos++] = nb[pb++];
        }
    }
    while (pa < la) nums[pos++] = na[pa++];
    while (pb < lb) nums[pos++] = nb[pb++];

    free(na);
    free(nb);

    return nums;
}

int main(){
    int numeros[] = { -14, 7, -3, 20, 0, -18, 12, -5, 19, -20, 4, -9, 15, -1, 8, -12, 2, -17, 11, 0 };
    int qtd_nums = 20;

    int* res = merge_sort(numeros, qtd_nums);
    mostrar(numeros, qtd_nums);

    return 0;
}