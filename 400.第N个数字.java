// https://leetcode-cn.com/problems/nth-digit/
public class Solution {
    public int findNthDigit(int n) {
        if (n <= 9) return n;
        long base = 1;
        int digit = 1;
        n--;
        while (n > 9 * base * digit) {
            n -= 9 * base * digit;
            base *= 10;
            digit++;
        }
        return String.valueOf(base + n / digit).charAt(n % digit) - '0';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.findNthDigit(11));
    }
}