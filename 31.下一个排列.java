// https://leetcode-cn.com/problems/next-permutation/
public class Solution {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    swap(nums, i, j);
                    Arrays.sort(nums, i + 1, nums.length);
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }

    void swap(int[] a, int i, int j) {
        a[i] ^= a[j];
        a[j] ^= a[i];
        a[i] ^= a[j];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = new int[]{3,2,1};
        solution.nextPermutation(input);
        System.err.println(Arrays.toString(input));
    }
}