package rec;

import java.util.HashMap;
import java.util.Map;

public class fib {

    public static int recursivo(int n){
        if (n <= 1) return n;

        return recursivo(n-1) + recursivo(n-2);
    }

    private static Map<Integer, Integer> memo = new HashMap<>();
    public static int memoizado(int n){
        if (n <= 1) return n;

        Integer m = memo.get(n);
        if (m != null) return m.intValue();

        int a = memoizado(n-1);
        int b = memoizado(n-2);
        int r = a+b;
        memo.put(n, r);

        return r;
    }

    public static int dp(int n){
        if (n <= 1) return n;

        int[] nums = {0, 1};
        
        for (int i = 0 ; i < n ; i++){
            int r = nums[0] + nums[1];
            nums[1] = nums[0];
            nums[0] = r;
        }


        return nums[0];
    }

    public static void main(String[] args){
        for (int i = 0 ; i < 40; i++){
            System.out.println(recursivo(i));
        }

        for (int i = 0 ; i < 40; i++){
            System.out.println(memoizado(i));
        }

        for (int i = 0 ; i < 40; i++){
            System.out.println(dp(i));
        }
    }
}
