// https://leetcode-cn.com/problems/string-to-integer-atoi/
// 这题真没意思
public class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        boolean negative = false;
        int i = 0;
        if (str.length() == 0) {
            return 0;
        } else if (str.charAt(i) == '+') {
            i++;
        } else if (str.charAt(i) == '-') {
            negative = true;
            i++;
        } else if (!Character.isDigit(str.charAt(i))) {
            return 0;
        }
        int result = 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int digit = str.charAt(i) - '0';
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        return negative ? -result : result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.myAtoi("91283472332"));
    }
}