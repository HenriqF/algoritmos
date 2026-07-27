package ordenacao;

public class bubbles{
    public static void main(String args[]){
        int[] numeros = {4,324,52224,434,12311,111,123,1,2,3,4,5};
        for (int i = 0; i < numeros.length; i++){
            for(int j = 0 ; j < numeros.length; j++){
                if (numeros[i] < numeros[j]){
                    int temp = numeros[j];
                    numeros[j] = numeros[i];
                    numeros[i] = temp;
                }
            }
        }

        for (int i : numeros) {
            System.err.println(i);
        }
    }
}