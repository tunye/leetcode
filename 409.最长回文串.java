// https://leetcode-cn.com/problems/longest-palindrome/
public class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int result = 0;
        for (int i: count) {
            result += i / 2 * 2;
            if (i % 2 == 1 && result % 2 == 0)
                result++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.longestPalindrome("abccccdd"));
    }
}