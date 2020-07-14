// https://leetcode-cn.com/problems/longest-common-prefix
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        } else {
            String min = strs[0];
            for (String s : strs) {
                if (s.isEmpty()) {
                    return "";
                }
                if (strs[0].charAt(0) != s.charAt(0)) {
                    return "";
                }
                if (s.length() < min.length()) {
                    min = s;
                }
            }

            for (int i = 0; i < strs.length; i++) {
                int j = 0;
                for (; j < min.length() && j < strs[i].length(); j++) {
                    if (min.charAt(j) != strs[i].charAt(j)) {
                        break;
                    }
                }
                if (j != 0) {
                    min = min.substring(0, j);
                } else {
                    return "";
                }
            }
            return min;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.longestCommonPrefix(new String[]{"aac","ab"}));
    }
}