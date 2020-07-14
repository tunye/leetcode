// https://leetcode-cn.com/problems/length-of-last-word
public class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && count != 0) {
                return count;
            } else if (s.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.lengthOfLastWord("Hello World"));
    }
}