//https://leetcode-cn.com/problems/multiply-strings
public class Solution {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        StringBuilder result = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int sum = (res[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0'));
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }


        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.multiply("123", "456"));
    }
}