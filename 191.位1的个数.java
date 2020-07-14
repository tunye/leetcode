//https://leetcode-cn.com/problems/number-of-1-bits
public class Solution {
    // you need treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0)
                result++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.hammingWeight(3));
    }
}