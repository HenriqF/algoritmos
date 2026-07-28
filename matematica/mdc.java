package matematica;

public class mdc {

    private static int calc(int a, int b){
        while (b != 0){
            int temp = a;
            a = b;
            b = temp%b;
        }

        return a;
    }

    public static void main(String[] args){
        System.out.println(calc(16, 23));
    }
}
