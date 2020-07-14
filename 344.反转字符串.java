// https://leetcode-cn.com/problems/reverse-string/
public class Solution {
    public void reverseString(char[] s) {
        char tmp;
        for (int i = 0, j = s.length - 1; i <= j; i++, j--) {
            if (s[i] == s[j]) {
                continue;
            }
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] s = new char[]{'h', 'a', 'n', 'n', 'a','h'};
        solution.reverseString(s);
        System.err.println(Arrays.toString(s));
    }
}