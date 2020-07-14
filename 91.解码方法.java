// https://leetcode-cn.com/problems/decode-ways/
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || "0".equals(s) || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        char forTwo;
        char forOne;
        for (int i = 2; i < s.length() + 1; i++) {
            forOne = s.charAt(i - 1);
            forTwo = s.charAt(i - 2);
            if (forTwo == '1' || forTwo == '2' && (forOne >= '0' && forOne <= '6')) {
                dp[i] = dp[i - 2];
            }
            if (forOne >= '1' && forOne <= '9') {
                dp[i] += dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.numDecodings("226"));
    }
}