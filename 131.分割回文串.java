// https://leetcode-cn.com/problems/palindrome-partitioning
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        handle(s, new ArrayList<>(), result, 0);
        return result;
    }

    private void handle(String s, List<String> tmp, List<List<String>> result, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(tmp));
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                tmp.add(s.substring(start, i + 1));
            } else {
                continue;
            }
            handle(s, tmp, result, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    private boolean isPalindrome(String tmp, int start, int end) {
        if (start == end) {
            return true;
        }
        for (int i = start, j = end; i <= j; i++, j--) {
            if (tmp.charAt(i) != tmp.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> result = solution.partition("aab");
        for (List<String> item : result) {
            System.err.println(item.toString());
        }
    }
}