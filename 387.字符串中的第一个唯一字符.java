// https://leetcode-cn.com/problems/first-unique-character-in-a-string/
public class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        } else if (s.length() == 1) {
            return 0;
        }
        int[] pos = new int[26];
        char[] sArray = s.toCharArray();
        for (char c : sArray) {
            pos[c - 'a']++;
        }
        for (int i = 0; i < sArray.length; i++) {
            if (pos[sArray[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.firstUniqChar("leetcode"));
    }
}