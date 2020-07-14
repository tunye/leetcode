// https://leetcode-cn.com/problems/word-pattern/
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        String[] item = str.split(" ");
        char[] pArray = pattern.toCharArray();
        if (pArray.length != item.length) {
            return false;
        }
        for (int i = 0; i < pArray.length; i++) {
            if (map.containsKey(pArray[i])) {
                if (!item[i].equals(map.get(pArray[i]))) {
                    return false;
                }
            } else {
                if (map.containsValue(item[i])) {
                    return false;
                } else {
                    map.put(pArray[i], item[i]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.wordPattern("abba", "dog cat cat dog"));
    }
}