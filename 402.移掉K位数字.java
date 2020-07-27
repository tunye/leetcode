// https://leetcode-cn.com/problems/remove-k-digits/
public class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int count = 0;
        for (char c : num.toCharArray()) {
            count = c - '0';
            while (k > 0 && !stack.isEmpty() && count < stack.peekLast()) {
                stack.pollLast();
                k--;
            }
            stack.offer(count);
        }
        while (k-- > 0) {
            stack.pollLast();
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            count = stack.poll();
            if (result.length() == 0 && count == 0) {
                continue;
            }
            result.append(count);
        }
        return result.length() == 0 ? "0" : result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.removeKdigits("1234567890", 9));
    }
}