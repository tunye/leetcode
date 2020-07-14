// https://leetcode-cn.com/problems/palindrome-number
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        } else if (x % 10 == 0) {
            return false;
        }
        String digitString = Integer.toString(x);
        for (int i = 0, j = digitString.length() - 1; i <= j; i++, j--) {
            if (digitString.charAt(i) != digitString.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    // 非字符串方法
    public boolean IsPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        } else if (x % 10 == 0) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.isPalindrome(5235));
    }
}