// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/submissions/
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }
        int i = 0;
        int j = 0;
        int pointer = 0
        for (; j < nums.length; j++) {
            while (j < nums.length && nums[pointer] == nums[j]) {
                j++;
            }
            nums[i] = nums[j - 1];
            pointer = j;
            i++;
        }
        if (j > nums.length) {
            return i;
        } else {
            nums[i] = nums[nums.length - 1];
            return i + 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.removeDuplicates(new int[]{0, 0, 0, 1, 1});
        System.err.println("result " + result);
    }
}