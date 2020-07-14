// https://leetcode-cn.com/problems/word-break
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        int minLength = Integer.MAX_VALUE;
        for (String word : wordDict) {
            minLength = Math.min(minLength, word.length());
        }
        for (int i = minLength; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (i >= word.length() && dp[i - word.length()]) {
                    if (s.startsWith(word, i - word.length())) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.wordBreak("catsandog", Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"}));
        System.err.println("result " + result);
    }
}