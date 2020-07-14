// https://leetcode-cn.com/problems/minimum-window-substring/
public class Solution {
    public String minWindow(String s, String t) {
        // 记录最短子串的开始位置和长度
        if (s.length() < t.length()) {
            return "";
        }
        int start = 0, minLen = Integer.MAX_VALUE;
        int left = 0, right = 0;
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (needs.containsKey(c)) {
                needs.put(c, needs.get(c) + 1);
            } else {
                needs.put(c, 1);
            }
        }

        int match = 0;

        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (needs.containsKey(c1)) {
                if (window.containsKey(c1)) {
                    window.put(c1, window.get(c1) + 1);
                } else {
                    window.put(c1, 1);
                }
                if (window.get(c1).equals(needs.get(c1)))
                    match++;
            }
            right++;

            while (match == needs.size()) {
                if (right - left < minLen) {
                    // 更新最小子串的位置和长度
                    start = left;
                    minLen = right - left;
                }
                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    if (window.containsKey(c2)) {
                        window.put(c2, window.get(c2) - 1);
                    } else {
                        window.put(c2, -1);
                    }
                    if (window.get(c2) < needs.get(c2))
                        match--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.minWindow("aa", "aa"));
    }
}