// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode cur = result;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                ListNode temp = cur.next;
                while (temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                cur.next = temp.next;
            } else {
                cur = cur.next;
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
        StringBuilder resultString = new StringBuilder();
        solution.toString(result, resultString);
        System.err.println("result " + resultString.toString());
    }
}