//https://leetcode-cn.com/problems/remove-palindromic-subsequences
public class Solution {
    public int removePalindromeSub(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else if (isPalindrome(s)) {
            return 1;
        } else {
            return 2;
        }
    }

    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i <= j; i++,j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.removePalindromeSub("aaba"));
    }
}