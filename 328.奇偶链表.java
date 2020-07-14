// https://leetcode-cn.com/problems/odd-even-linked-list/
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(-1);
        ListNode resultOper = result;
        ListNode tmp = new ListNode(-1);
        ListNode tmpOper = tmp;
        int pos = 1;
        while (head != null) {
            if (pos % 2 == 1) {
                resultOper.next = head;
                resultOper = resultOper.next;
            } else {
                tmpOper.next = head;
                tmpOper = tmpOper.next;
            }
            head = head.next;
            pos++;
        }
        tmpOper.next = null;
        resultOper.next = tmp.next;
        return result.next;
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
        tmp.next = new ListNode(1);
        tmp = tmp.next;
        tmp.next = new ListNode(2);
        tmp = tmp.next;
        tmp.next = new ListNode(3);
        tmp = tmp.next;
        tmp.next = new ListNode(4);
        tmp = tmp.next;
        tmp.next = new ListNode(5);
        ListNode res = solution.oddEvenList(input1.next);
        StringBuilder resultString = new StringBuilder();
        solution.toString(res, resultString);
        System.err.println("result " + resultString.toString());
    }
}