// https://leetcode-cn.com/problems/restore-ip-addresses/
// 变种回溯法
public class Solution {
    int inputLength;
    String input;
    LinkedList<String> segments = new LinkedList<>();
    List<String> result = new ArrayList<>();

    public boolean valid(String segment) {
        int m = segment.length();
        if (m > 3)
            return false;
        return (segment.charAt(0) != '0') ? (Integer.parseInt(segment) <= 255) : (m == 1);
    }

    public void update_output(int curPos) {
        String segment = input.substring(curPos + 1, inputLength);
        if (valid(segment)) {
            segments.add(segment);
            result.add(String.join(".", segments));
            segments.removeLast();
        }
    }

    public void backtrack(int prevPos, int dots) {
        int max_pos = Math.min(inputLength - 1, prevPos + 4);
        for (int i = prevPos + 1; i < max_pos; i++) {
            String segment = input.substring(prevPos + 1, i + 1);
            if (valid(segment)) {
                segments.add(segment);
                if (dots - 1 == 0)
                    update_output(i);
                else
                    backtrack(i, dots - 1);
                segments.removeLast();
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        inputLength = s.length();
        this.input = s;
        backtrack(-1, 3);
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.restoreIpAddresses("25525511135"));
    }
}