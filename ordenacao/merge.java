package ordenacao;

import java.util.Arrays;


public class merge {

    public static void mostrar(int[] porra){
        System.err.print("[");
        for (int i : porra) {
            System.err.printf(" %d", i);
        }
        System.err.println(" ]");
    }

    public static int[] merge_sort(int[] nums){
        if (nums.length <= 1){
            return nums;
        }
        if (nums.length == 2){
            if (nums[0] > nums[1]) return new int[]{nums[1], nums[0]};
            return nums;
        }

        int la = nums.length/2;

        int[] na = merge_sort(Arrays.copyOfRange(nums, 0, la));
        int[] nb = merge_sort(Arrays.copyOfRange(nums, la, nums.length));

        int[] ns = new int[nums.length];
        int pa = 0, pb = 0, ps = 0;

        while(pb < nb.length && pa < na.length){
            if (na[pa] <= nb[pb]){
                ns[ps++] = na[pa++];
            }
            else{
                ns[ps++] = nb[pb++];
            }
        }
        while ( pa < na.length ){ ns[ps++] = na[pa++]; }
        while ( pb < nb.length ){ ns[ps++] = nb[pb++]; }


        return ns;
    }

    public static void main(String args[]){
        int[] numeros = {4,324,52224,434,12311,111,123,1,2,3,4,5};

        int[] res = merge_sort(numeros);
        mostrar(res);
    }
}
