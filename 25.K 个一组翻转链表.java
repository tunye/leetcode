// https://leetcode-cn.com/problems/reverse-nodes-in-k-group
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode start = head, end = head;
        for (int i = 0; i < k; i++) {
            if (end != null) {
                end = end.next;
            } else {
                return head;
            }
        }
        ListNode result = reverse(start, end);
        start.next = reverseKGroup(end, k);
        return result;
    }

    public ListNode reverse(ListNode head, ListNode end) {
        ListNode pre = null, cur = head, next = head;
        while (next != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
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
        ListNode input = new ListNode(9);
        ListNode l = input;
        l.next = new ListNode(8);
        l = l.next;
        l.next = new ListNode(7);
        l = l.next;
        l.next = new ListNode(6);
        l = l.next;
        l.next = new ListNode(5);
        ListNode result = solution.reverseKGroup(input, 3);
        StringBuilder resultString = new StringBuilder();
        solution.toString(result, resultString);
        System.err.println("result " + resultString.toString());
    }
}