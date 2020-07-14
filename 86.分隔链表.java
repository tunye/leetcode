// https://leetcode-cn.com/problems/partition-list
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1);
        ListNode smallList = small;
        ListNode big = new ListNode(-1);
        ListNode bigList = big;
        while (head != null) {
            if (head.val < x) {
                smallList.next = head;
                smallList = smallList.next;
            } else {
                bigList.next = head;
                bigList = bigList.next;
            }
            head = head.next;
        }
        bigList.next = null;
        smallList.next = big.next;
        return small.next;
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
        ListNode result = solution.partition(param.next, 6);
        StringBuilder resultString = new StringBuilder();
        solution.toString(result, resultString);
        System.err.println("result " + resultString.toString());
    }
}