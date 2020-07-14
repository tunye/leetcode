// https://leetcode-cn.com/problems/power-of-two
public class Solution {
    public boolean isPowerOfTwo(int num) {
        return num > 0 && (num & (num - 1)) == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.isPowerOfTwo(2));
    }
}