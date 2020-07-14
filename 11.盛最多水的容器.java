// https://leetcode-cn.com/problems/container-with-most-water
public class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int start = 0, end = height.length - 1;
        while (start < end) {
            result = Math.max(Math.min(height[end], height[start]) * (end - start), result);
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}