// https://leetcode-cn.com/problems/remove-linked-list-elements
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            if (head.val == val) {
                return null;
            } else {
                return head;
            }
        }
        ListNode result = new ListNode(-1);
        ListNode cur = result;
        cur.next = head;
        ListNode fast = cur.next;
        while (fast != null) {
            if (fast.val != val) {
                cur = cur.next;
                fast = fast.next;
            } else {
                fast = fast.next;
                cur.next = fast;
            }
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
        ListNode l1 = new ListNode(8);
        ListNode tmp = l1;
        tmp.next = new ListNode(8);
        tmp = tmp.next;
        tmp.next = new ListNode(7);
        tmp = tmp.next;
        tmp.next = new ListNode(6);
        tmp = tmp.next;
        tmp.next = new ListNode(6);
        tmp = tmp.next;
        tmp.next = new ListNode(8);
        tmp = tmp.next;
        ListNode result = solution.removeElements(l1, 8);
        if (result == null) {
            System.err.println("null");
        } else {
            StringBuilder resultString = new StringBuilder();
            solution.toString(result, resultString);
            System.err.println("result " + resultString.toString());
        }
    }
}