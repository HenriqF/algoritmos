package ordenacao;

import java.util.Arrays;

public class quick {

    public static void mostrar(int[] porra){
        System.err.print("[");
        for (int i : porra) {
            System.err.printf(" %d", i);
        }
        System.err.println(" ]");
    }


    private static int[] quick_sort(int[] nums){
        if (nums.length <= 1){
            return nums;
        }

        int pivot = nums.length-1;
        int a = 0, b= -1;

        
        while (a < nums.length){
            if (nums[a] <= nums[pivot]){
                b++;

                if (a != b){
                    int temp = nums[a];
                    nums[a] = nums[b];
                    nums[b] = temp;

                    if (a == pivot) pivot = b;
                }
            }
            a++;
        }

        int[] antes = quick_sort( Arrays.copyOfRange(nums, 0, pivot) );
        int[] depois = quick_sort( Arrays.copyOfRange(nums, pivot+1, nums.length) );

        int i = 0;
            
        for (int j = 0; j < antes.length; j++) nums[i++] = antes[j];
        i++;
        for (int j = 0; j < depois.length; j++) nums[i++] = depois[j];


        return nums;
    }

    public static void main(String[] args){
        int[] numeros = { -14, 7, -3, 20, 0, -18, 12, -5, 19, -20, 4, -9, 15, -1, 8, -12, 2, -17, 11, 0 };
        // int[] numeros = {5, 4, 3, 2, 1};
        mostrar(numeros);

        quick_sort(numeros);

        mostrar(numeros);
    }

}
