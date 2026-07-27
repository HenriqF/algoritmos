package busca;

public class linear {

    public static void main(String[] args){
        int[] numeros = {4,324,52224,434,12311,111,123,1,2,3,4,5};
        int obj = 111;

        int pos = -1;
        for (int i = 0; i < numeros.length; i++){
            if (numeros[i] == obj) {
                pos = i;
                break;
            }
        }

        if (pos < 0) System.out.println("nao ta dentro");
        else System.out.printf("pos: %d\n", pos);
    }
    
}
