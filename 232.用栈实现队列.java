// https://leetcode-cn.com/problems/implement-queue-using-stacks/
public class MyQueue {
    Stack<Integer> main;
    Stack<Integer> helper;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        main = new Stack<>();
        helper = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        main.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (helper.size() == 0) {
            while (main.size() > 1) {
                helper.push(main.pop());
            }
            return main.pop();
        } else {
            return helper.pop();
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (helper.size() == 0) {
            while (main.size() > 1) {
                helper.push(main.pop());
            }
            int result = main.peek();
            helper.push(main.pop());
            return result;
        } else {
            return helper.peek();
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return main.size() == 0 && helper.size() == 0;
    }
}