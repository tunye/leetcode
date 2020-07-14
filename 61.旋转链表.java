// https://leetcode-cn.com/problems/rotate-list
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 0) {
            return head;
        }
        ListNode tmp = head;
        int length = 1;
        while (tmp.next != null) {
            length++;
            tmp = tmp.next;
        }
        if (k % length == 0) {
            return head;
        }
        k = k % length;
        k = length - k;
        ListNode result = new ListNode(-1);
        tmp = head;
        for (int i = 0; i < k; i++) {
            head = head.next;
        }
        result.next = head;
        for (int i = k; i < length - 1; i++) {
            head = head.next;
        }
        head.next = tmp;
        for (int i = 0; i < k; i++) {
            head = head.next;
        }
        head.next = null;
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
        ListNode input = new ListNode(-1);
        ListNode tmp = input;
        tmp.next = new ListNode(0);
        tmp = tmp.next;
        tmp.next = new ListNode(1);
        tmp = tmp.next;
        tmp.next = new ListNode(2);
        tmp = tmp.next;
        tmp.next = new ListNode(3);
        tmp = tmp.next;
        tmp.next = new ListNode(4);
        ListNode result = solution.rotateRight(input.next, 3);
        StringBuilder stringBuilder = new StringBuilder();
        solution.toString(result, stringBuilder);
        System.err.println(stringBuilder.toString());
    }
}