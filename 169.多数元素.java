// https://leetcode-cn.com/problems/majority-element
public class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int support = 1;
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (support == 0) {
                result = nums[i];
            }
            if (nums[i] == result) {
                support++;
            } else {
                support--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.majorityElement(new int[]{3,2,2}));
    }
}