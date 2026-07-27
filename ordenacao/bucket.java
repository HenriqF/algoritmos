package ordenacao;

import java.util.Arrays;

public class bucket {
    public static int max(int[] a){
        int max = a[0];
        for (int i : a) {
            if (i > max) max = i;
        }

        return max;
    }

    public static int min(int[] a){
        int min = a[0];
        for (int i : a) {
            if (i < min) min = i;
        }

        return min;
    }

    public static void mostrar(int[] porra){
        System.err.print("[");
        if (porra == null){
            System.err.println(" ]");
            return;
        }

        for (int i : porra) {
            System.err.printf(" %d", i);
        }
        System.err.println(" ]");
    }


    public static void main(String args[]){
        int[] numeros = { -14, 7, -3, 20, 0, -18, 12, -5, 19, -20, 4, -9, 15, -1, 8, -12, 2, -17, 11, 0 };

        int teto = max(numeros);
        int chao = min(numeros);

        int range = teto-chao+1;
        int qtd_baldes = 8;

        int[][] baldes = new int[qtd_baldes][];

        for (int n : numeros) {
            int pos = ((n-chao)*qtd_baldes)/range;

            int[] balde = baldes[pos];
            if (balde == null){
                baldes[pos] = new int[]{n};
            }
            else{
                int[] novo = Arrays.copyOf(balde, balde.length+1);
                novo[novo.length-1] = n;
                baldes[pos] = novo;
            }
        }

        int pos = 0;
        for (int[] b : baldes) {
            if (b == null){
                continue;
            }

            for (int i = 1; i < b.length; i++){
                int atual = b[i];
                int previo = i-1;

                while (previo >= 0 && b[previo] > atual){
                    b[previo + 1] = b[previo];
                    previo--;
                }
                b[previo+1]= atual;
            }

            for (int i = 0; i < b.length; i++){
                numeros[pos++] = b[i];
            }
        }
        mostrar(numeros);


    }
}
