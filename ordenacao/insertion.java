package ordenacao;

public class insertion {
    public static void main(String args[]){
        int[] numeros = {4,324,52224,434,12311,111,123,1,2,3,4,5};

        if (numeros.length == 1){
            System.err.println(numeros[0]);
            return;
        } 

        for (int i = 1; i < numeros.length; i++){
            int atual = numeros[i];
            int previo = i-1;

            while (previo >= 0 && numeros[previo] > atual){
                numeros[previo + 1] = numeros[previo];
                previo--;
            }
            numeros[previo+1]= atual;

        }

        for (int i : numeros) {
            System.err.println(i);
        }
    }
}