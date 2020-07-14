// https://leetcode-cn.com/problems/reverse-bits
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i <= 31; i++) {
            result ^= (n & (1 << i)) != 0 ? 1 << (31 - i) : 0;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.reverseBits(4));
    }
}