// https://leetcode-cn.com/problems/count-and-say/
public class Solution {
    public String countAndSay(int n) {
        StringBuilder result = new StringBuilder();
        int previous = 0;
        int cur;
        if (n == 1) {
            return "1";
        }
        String str = countAndSay(n - 1);
        for (cur = 1; cur < str.length(); cur++) {
            if (str.charAt(previous) != str.charAt(cur)) {
                int count = cur - previous;
                result.append(count).append(str.charAt(previous));
                previous = cur;
            }
        }
        int count = cur - previous;
        result.append(count).append(str.charAt(previous));
        return result.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.countAndSay(4));
    }
}