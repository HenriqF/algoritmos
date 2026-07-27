package busca;

public class binaria {
    public static void main(String[] args){
        int[] numeros = {1, 2, 3, 5, 6, 7, 8, 10, 11, 12, 13, 15, 16, 17, 19, 20, 21, 23, 24, 25, 27, 28, 29, 30};
        int obj = 15;
        int pos = -1;

        int i = 0, j = numeros.length-1;

        while (i <= j){
            int meio = (j-i)/2 + i;

            if(numeros[meio] == obj){
                pos = meio;
                break;
            }

            if (numeros[meio] > obj){
                j=meio-1;
                continue;
            }

            i=meio+1;
        }


        
        if (pos < 0) System.out.println("nao ta dentro");
        else System.out.printf("pos: %d\n", pos);
    }
}
