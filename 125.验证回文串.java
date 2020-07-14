// https://leetcode-cn.com/problems/valid-palindrome/
public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.equals("")) {
            return true;
        }
        if (s.length() == 1) {
            return true;
        }
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (!isValid(s.charAt(i))) {
                j++;
                continue;
            }
            if (!isValid(s.charAt(j))) {
                i--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
        }
        return true;
    }

    public boolean isValid(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.isPalindrome("0P"));
    }
}