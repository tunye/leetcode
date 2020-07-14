// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
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
        ListNode l1 = input;
        l1.next = new ListNode(9);
        l1 = l1.next;
        l1.next = new ListNode(8);
        l1 = l1.next;
        l1.next = new ListNode(7);
        l1 = l1.next;
        l1.next = new ListNode(7);
        l1 = l1.next;
        l1.next = new ListNode(6);
        l1 = l1.next;
        l1.next = new ListNode(6);
        ListNode result = solution.deleteDuplicates(input);
        if (result == null) {
            System.err.println("result null");
        } else {
            StringBuilder resultString = new StringBuilder();
            solution.toString(result, resultString);
            System.err.println("result " + resultString.toString());
        }
    }
}