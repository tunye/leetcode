// https://leetcode-cn.com/problems/swap-nodes-in-pairs
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode cur = result;

        while (cur.next != null && cur.next.next != null) {
            ListNode slow = cur.next;
            ListNode fast = cur.next.next;
            slow.next = fast.next;
            fast.next = slow;
            cur.next = fast;
            cur = cur.next.next;
        }
        return result.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
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
        l1.next = new ListNode(16);
        l1 = l1.next;
        l1.next = new ListNode(23);
        l1 = l1.next;
        l1.next = new ListNode(6);
        l1 = l1.next;
        l1.next = new ListNode(12);
//        l1 = l1.next;
//        l1.next = new ListNode(7);
        ListNode result = solution.swapPairs(input);
        StringBuilder resultString = new StringBuilder();
        solution.toString(result, resultString);
        System.err.println("result " + resultString.toString());
    }
}