package matematica;

import java.util.ArrayList;

public class crivo {

    public static void mostrar(int[] porra){
        System.err.print("[");
        for (int i : porra) {
            System.err.printf(" %d", i);
        }
        System.err.println(" ]");
    }


    public static int[] get_primos(int n){
        if (n == 0){
            return new int[]{};
        }

        ArrayList<Integer> primos = new ArrayList<>();
        primos.add(2);
        int c = 3;

        while(primos.size() < n){
            Boolean status = true;
            for (int p : primos) {
                if (p*p > c){
                    break;
                }
                if (c%p == 0){
                    status = false;
                    break;
                }
            }

            if (status){
                primos.add(c);
            }
            c+=2;
        }

        int[] res = new int[primos.size()];
        int pos = 0;

        for (int p : primos) {
            res[pos++] = p;
        }

        return res;
    }

    public static void main(String[] args){
        mostrar(get_primos(7));
    }
}
