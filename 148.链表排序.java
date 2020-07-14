//https://leetcode-cn.com/problems/sort-list
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode first = head;
        ListNode mid = getMid(head);
        ListNode second = mid.next;
        mid.next = null;
        first = sortList(first);
        second = sortList(second);
        return merge(first, second);
    }

    private ListNode merge(ListNode first, ListNode second) {
        if (first == null) {
            return second;
        }
        if ((second == null)) {
            return first;
        }
        ListNode result = new ListNode(-1);
        ListNode tmp = result;
        while (first != null && second != null) {
            if (first.val < second.val) {
                tmp.next = first;
                tmp = tmp.next;
                first = first.next;
            } else {
                tmp.next = second;
                tmp = tmp.next;
                second = second.next;
            }
        }
        if (first != null) {
            tmp.next = first;
        }
        if (second != null) {
            tmp.next = second;
        }
        return result.next;
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
        ListNode tmp = input;
        tmp.next = new ListNode(15);
        tmp = tmp.next;
        tmp.next = new ListNode(2);
        tmp = tmp.next;
        tmp.next = new ListNode(16);
        tmp = tmp.next;
        tmp.next = new ListNode(8);
        ListNode result = solution.sortList(input);
        StringBuilder resultString = new StringBuilder();
        solution.toString(result, resultString);
        System.err.println("result " + resultString.toString());
    }
}