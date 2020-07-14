// https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        List<String> fuhao = new ArrayList<>(4);
        fuhao.add("+");
        fuhao.add("-");
        fuhao.add("*");
        fuhao.add("/");
        Stack<Integer> stack = new Stack<>();
        int tmp;
        for (String item : tokens) {
            if (fuhao.contains(item)) {
                switch (item) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        tmp = stack.pop();
                        stack.push(stack.pop() - tmp);
                        break;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        tmp = stack.pop();
                        stack.push(stack.pop() / tmp);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(item));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
        System.err.println("result " + result);
    }
}