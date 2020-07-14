// https://leetcode-cn.com/problems/reorder-list/
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }

        ListNode reverse = reverse(slow);

        ListNode result = new ListNode(-1);
        ListNode cur = result;
        while (head != null && reverse != null) {
            cur.next = head;
            head = head.next;
            cur = cur.next;

            cur.next = reverse;
            reverse = reverse.next;
            cur = cur.next;
        }
        if (head != null) {
            cur.next = head;
            cur = cur.next;
        }
        cur.next = null;
        head = result.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode tmp;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
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
        tmp.next = new ListNode(1);
        tmp = tmp.next;
        tmp.next = new ListNode(2);
        tmp = tmp.next;
        tmp.next = new ListNode(3);
        tmp = tmp.next;
        tmp.next = new ListNode(4);
//        tmp = tmp.next;
//        tmp.next = new ListNode(5);
        solution.reorderList(input1.next);
        StringBuilder resultString = new StringBuilder();
        solution.toString(input1.next, resultString);
        System.err.println("result " + resultString.toString());
    }
}