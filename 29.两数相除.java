// https://leetcode-cn.com/problems/divide-two-integers/submissions/
public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int result = 0;
        int tmp;
        boolean negative = dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0;
        long dividendLong = Math.abs((long) dividend);
        long divisorLong = Math.abs((long) divisor);
        while (dividendLong >= divisorLong) {
            long tmpDivisor = divisorLong;
            tmp = 1;
            while (dividendLong - tmpDivisor >= tmpDivisor) {
                tmpDivisor = tmpDivisor << 1;
                tmp = tmp << 1;
            }
            dividendLong -= tmpDivisor;
            result += tmp;
        }
        return negative ? -result : result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.divide(Integer.MIN_VALUE, 1));
    }
}