// https://leetcode-cn.com/problems/sort-colors/
public class Solution {
    public void sortColors(int[] nums) {
        int i = 0, start = 0, end = nums.length - 1;
        int swap;
        for (; i <= end; i++) {
            if (nums[i] == 0) {
                swap = nums[start];
                nums[start] = nums[i];
                nums[i] = swap;
                start++;
            } else if (nums[i] == 2) {
                swap = nums[end];
                nums[end] = nums[i];
                nums[i] = swap;
                end--;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = new int[]{2, 1, 0, 0, 1, 2};
        solution.sortColors(input);
        System.err.println(Arrays.toString(input));
    }
}