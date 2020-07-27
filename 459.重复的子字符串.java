// https://leetcode-cn.com/problems/repeated-substring-pattern/
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.repeatedSubstringPattern("abcabcabcabc"));
    }
}