// https://leetcode-cn.com/problems/remove-element
public class Solution {
    public int removeElement(int[] nums, int val) {
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length && nums[i] == val) {
                i++;
            }
            if (i < nums.length) {
                nums[pointer] = nums[i];
                pointer++;
            }
        }
        return pointer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }
}