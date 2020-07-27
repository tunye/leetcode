// https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/
public class Solution {
    public String toHex(int num) {
        char[] hex = "0123456789abcdef".toCharArray();
        StringBuilder str = new StringBuilder();
        while (num != 0) {
            int end = num & 15;
            str.append(hex[end]);
            num >>>= 4;
        }
        if (str.length() == 0) {
            str.append("0");
        }

        return str.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.toHex(254));
    }
}