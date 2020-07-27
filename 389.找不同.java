// https://leetcode-cn.com/problems/find-the-difference/
public class Solution {
    public char findTheDifference(String s, String t) {
        int result = 0;
        String target = s + t;
        for (char c : target.toCharArray()) {
            result ^= c;
        }
        return (char) result;
    }

    public char findTheDifference2(String s, String t) {
        Map<Character, Integer> dict = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (dict.containsKey(c)) {
                dict.put(c, dict.get(c) + 1);
            } else {
                dict.putIfAbsent(c, 1);
            }
        }

        for (char c : t.toCharArray()) {
            int count = dict.getOrDefault(c, 0);
            if (count <= 0) {
                return c;
            } else {
                dict.put(c, count - 1);
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.findTheDifference("abc", "abce"));
    }
}