//https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int lengthMax = 0;
        Map<Character, Integer> occurs = new HashMap<>();
        char curCharacter;
        for (int start = 0, end = 0; end < s.length(); ) {
            curCharacter = s.charAt(end);
            if (occurs.containsKey(curCharacter)) {
                start = Math.max(start, occurs.get(curCharacter));
            }
            lengthMax = Math.max(lengthMax, end - start + 1);
            occurs.put(curCharacter, ++end);
        }
        return lengthMax;
    }

    //复杂解
    public int lengthOfLongestSubstring2(String s) {
        List<Character> occurs = new ArrayList<>();
        int lengthMax = 0;
        char curCharacter;
        for (int i = 0; i < s.length(); i++) {
            curCharacter = s.charAt(i);
            int containPos = occurs.indexOf(curCharacter);
            if (containPos != -1) {
                if (containPos == occurs.size() - 1) {
                    occurs.clear();
                } else {
                    occurs = new ArrayList<>(occurs.subList(containPos + 1, occurs.size()));
                }
            }
            occurs.add(curCharacter);
            lengthMax = Math.max(lengthMax, occurs.size());
        }
        return lengthMax;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.lengthOfLongestSubstring("bbbbb"));
    }
}