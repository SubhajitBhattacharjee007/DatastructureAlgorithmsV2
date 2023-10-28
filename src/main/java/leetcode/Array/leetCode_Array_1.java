package leetcode.Array;

public class leetCode_Array_1 {

    //1. Two Sum : https://leetcode.com/problems/two-sum/description/

    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] indexes = twoSum(new int[]{3,2,4}, 6);
        System.out.println("Indexes: [ " + indexes[0] + ", " +indexes[1] +" ]");
    }

}
