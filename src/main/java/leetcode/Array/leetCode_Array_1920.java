package leetcode.Array;

public class leetCode_Array_1920 {

    //1920. Build Array from Permutation

    public static int[] buildArray(int[] nums) {

        int[] arr = new int[nums.length];
        for(int i = 0; i<arr.length; i++) {
            arr[i] = nums[nums[i]];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = buildArray(new int[]{2,3,0,1,4});
        for(int i = 0; i<arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }
}
