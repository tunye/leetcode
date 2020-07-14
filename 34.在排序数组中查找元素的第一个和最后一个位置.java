// https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int first = nums.length;
        int last = -1;
        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            if (nums[i] == target) {
                if (i < first) {
                    first = i;
                }
                if (i > last) {
                    last = i;
                }
            }
            if (nums[j] == target) {
                if (j > last) {
                    last = j;
                }
                if (j < first) {
                    first = j;
                }
            }
        }
        if (first == nums.length) {
            first = -1;
        }
        return new int[]{first, last};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.searchRange(new int[]{1, 4}, 1);
        System.err.println("result " + result[0] + " " + result[1]);
    }
}