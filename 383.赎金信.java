// https://leetcode-cn.com/problems/ransom-note/
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] dict = new int[26];
        for (char c : magazine.toCharArray()) {
            dict[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            dict[c - 'a']--;
            if (dict[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        } else {
            Map<Character, Integer> dict = new HashMap<>();
            char[] mArray = magazine.toCharArray();
            for (char c : mArray) {
                dict.put(c, dict.getOrDefault(c, 0) + 1);
            }
            char[] rArray = ransomNote.toCharArray();
            for (char c : rArray) {
                int count = dict.getOrDefault(c, 0);
                if (count <= 0) {
                    return false;
                } else {
                    dict.put(c, count - 1);
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.canConstruct("aa", "aab"));
    }
}