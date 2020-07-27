// https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[11];
        if (n == 1) {
            return 10;
        } else {
            dp[1] = 10;
            dp[2] = 9 * 9;
            n = Math.min(n, 10);
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] * (11 - i);
            }
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += dp[i];
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.countNumbersWithUniqueDigits(12));
    }
}