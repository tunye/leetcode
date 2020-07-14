// https://leetcode-cn.com/problems/valid-number/
public class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        s = s.trim().toLowerCase();
        char lastChar = ' ';
        for (char item : s.toCharArray()) {
            if (item >= '0' && item <= '9') {
                numSeen = true;
            } else if (item == '.') {
                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (item == 'e') {
                if (eSeen || !numSeen) {
                    return false;
                }
                eSeen = true;
                numSeen = false;
            } else if (item == '+' || item == '-') {
                if (lastChar != ' ' && lastChar != 'e') {
                    return false;
                }
            } else {
                return false;
            }
            lastChar = item;
        }
        return numSeen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.isNumber("9"));
    }
}