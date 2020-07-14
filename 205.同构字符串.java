// https://leetcode-cn.com/problems/isomorphic-strings
public class Solution {
    public boolean isIsomorphic2(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        if (sArray.length != tArray.length) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < sArray.length; i++) {
            if (map.containsKey(sArray[i])) {
                continue;
            }
            if (map.containsValue(tArray[i])) {
                return false;
            }
            map.put(sArray[i], tArray[i]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : sArray) {
            stringBuilder.append(map.get(c));
        }
        return stringBuilder.toString().equals(t);
    }

    public boolean isIsomorphic(String s, String t) {
        int[] s1 = new int[128];
        int[] s2 = new int[128];
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        for (int i = 0; i < sArray.length; i++) {
            if (s1[sArray[i]] != s2[tArray[i]]) {
                return false;
            } else if (s1[sArray[i]] == 0) {
                s1[sArray[i]] = i + 1;
                s2[tArray[i]] = i + 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.isIsomorphic("aa", "ab"));
    }
}