// https://leetcode-cn.com/problems/add-strings/
public class Solution {
    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            return addStrings(num2, num1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        int tmp = 0;
        int i, j;
        for (i = num1.length() - 1, j = num2.length() - 1; j >= 0; i--, j--) {
            tmp += (num1.charAt(i) - '0') + (num2.charAt(j) - '0');
            stringBuilder.append(tmp % 10);
            tmp /= 10;
        }
        while (i >= 0 && tmp > 0) {
            tmp += (num1.charAt(i) - '0');
            stringBuilder.append(tmp % 10);
            tmp /= 10;
            i--;
        }
        if (i < 0 && tmp != 0) {
            stringBuilder.append(tmp);
        } else {
            while (i >= 0) {
                stringBuilder.append(num1.charAt(i));
                i--;
            }
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.addStrings("0", "0"));
    }
}