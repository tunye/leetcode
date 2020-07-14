// https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
public class Solution {
    public char firstUniqChar(String s) {
        LinkedList<Character> queue = new LinkedList<>();
        boolean[] removed = new boolean[26];
        for (char c : s.toCharArray()) {
            if (queue.contains(c)) {
                queue.remove((Character) c);
                removed[c - 'a'] = true;
            } else if (!removed[c - 'a']) {
                queue.add(c);
            }
        }
        if (queue.isEmpty()) {
            return ' ';
        } else {
            return queue.poll();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println((solution.firstUniqChar("abadklasdjlasjd")));
    }
}