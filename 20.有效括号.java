//https://leetcode-cn.com/problems/valid-parentheses/

public class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>(4);
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
        if (s == null || "".equals(s)) {
            return true;
        }
        if (!map.containsKey(s.charAt(0))) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || map.get(stack.peek()) != c) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        Map<Character, Character> map = new HashMap<>(4);
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        if (s == null || "".equals(s)) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == map.get(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.isValid("[])"));
    }
}
