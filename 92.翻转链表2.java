// https://leetcode-cn.com/problems/reverse-linked-list-ii
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode back = result;
        ListNode front = result.next;
        for (int i = 0; i < m - 1; i++) {
            front = front.next;
            back = back.next;
        }
        ListNode removed;
        for (int i = 0; i < n - m; i++) {
            removed = front.next;
            front.next = front.next.next;
            removed.next = back.next;
            back.next = removed;
        }
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
        ListNode param = new ListNode(-1);
        ListNode tmp = param;
        tmp.next = new ListNode(9);
        tmp = tmp.next;
        tmp.next = new ListNode(3);
        tmp = tmp.next;
        tmp.next = new ListNode(4);
        tmp = tmp.next;
        tmp.next = new ListNode(1);
        tmp = tmp.next;
        tmp.next = new ListNode(15);
        tmp = tmp.next;
        tmp.next = new ListNode(7);
        ListNode result = solution.reverseBetween(param.next, 3, 5);
        StringBuilder resultString = new StringBuilder();
        solution.toString(result, resultString);
        System.err.println("result " + resultString.toString());
    }
}