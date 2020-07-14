//https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode normal = pre;
        ListNode fast = pre;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            normal = normal.next;
        }
        normal.next = normal.next.next;
        return pre.next;
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
        ListNode result = solution.removeNthFromEnd(param.next, 3);
        StringBuilder resultString = new StringBuilder();
        solution.toString(result, resultString);
        System.err.println("result " + resultString.toString());
    }
}