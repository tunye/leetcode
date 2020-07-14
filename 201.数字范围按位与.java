// https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        while (n > m) {
            n = n & (n - 1);
        }
        return n & m;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.rangeBitwiseAnd(5, 7));
    }
}