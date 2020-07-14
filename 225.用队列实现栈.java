// https://leetcode-cn.com/problems/implement-stack-using-queues/
public class MyStack {
    Queue<Integer> main;
    Queue<Integer> helper;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        main = new LinkedList<>();
        helper = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        main.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int popVal = 0;
        while (main.size() > 1) {
            helper.offer(main.poll());
        }
        if (main.size() == 1) {
            popVal = main.poll();
            while (helper.size() > 0) {
                main.offer(helper.poll());
            }
        }
        return popVal;
    }

    /**
     * Get the top element.
     */
    public int top() {
        int topVal = 0;
        while (main.size() > 1) {
            helper.offer(main.poll());
        }
        if (main.size() == 1) {
            topVal = main.peek();
            helper.offer(main.poll());
            while (helper.size() > 0) {
                main.offer(helper.poll());
            }
        }
        return topVal;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return main.size() == 0;
    }
}