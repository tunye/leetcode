// https://leetcode-cn.com/problems/add-two-numbers-ii/
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> num1 = new Stack<>();
        Stack<Integer> num2 = new Stack<>();
        ListNode tmp = l1;
        while (tmp != null) {
            num1.push(tmp.val);
            tmp = tmp.next;
        }
        tmp = l2;
        while (tmp != null) {
            num2.push(tmp.val);
            tmp = tmp.next;
        }
        ListNode pre = null;
        ListNode cur;
        int carry = 0;
        int sum = 0;
        while (!num1.isEmpty() || !num2.isEmpty() || carry != 0) {
            sum = (num1.isEmpty() ? 0 : num1.pop()) + (num2.isEmpty() ? 0 : num2.pop()) + carry;
            if (sum >= 10) {
                carry = 1;
                sum %= 10;
            } else {
                carry = 0;
            }
            cur = new ListNode(sum);
            cur.next = pre;
            pre = cur;
        }
        return pre;
    }


    private void toString(ListNode listNode, StringBuilder stringBuilder) {
        stringBuilder.append(listNode.val);
        if (listNode.next != null) {
            stringBuilder.append(" -> ");
            toString(listNode.next, stringBuilder);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode input1 = new ListNode(-1);
        ListNode tmp = input1;
        tmp.next = new ListNode(8);
        tmp = tmp.next;
        tmp.next = new ListNode(9);
        ListNode input2 = new ListNode(-1);
        tmp = input2;
        tmp.next = new ListNode(1);
        ListNode result = solution.addTwoNumbers(input1.next, input2.next);
        StringBuilder resultString = new StringBuilder();
        solution.toString(result, resultString);
        System.err.println("result " + resultString.toString());
    }
}