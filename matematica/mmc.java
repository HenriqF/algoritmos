package matematica;

public class mmc {
    
    private static int calc(int a, int b){
        int mdc = a;
        int y = b;
        while (y != 0){
            int temp = mdc;
            mdc = y;
            y = temp%y;
        }


        return Math.abs(a*b)/mdc;
    }

    public static void main(String[] args){

        System.out.println(calc(20, 13));

    }
}
