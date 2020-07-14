// https://leetcode-cn.com/problems/bulls-and-cows/
public class Solution {
    public String getHint(String secret, String guess) {
        int aCount = 0;
        int bCount = 0;
        int[] bucket = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                aCount++;
                continue;
            }
            bucket[secret.charAt(i) - '0']++;
            bucket[guess.charAt(i) - '0']--;
        }
        for (int num : bucket) {
            if (num > 0) {
                bCount++;
            }
        }
        bCount = secret.length() - bCount - aCount;
        return aCount + "A" + bCount + "B";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.getHint("1123", "3113"));
    }
}