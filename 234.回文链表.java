// https://leetcode-cn.com/problems/palindrome-linked-list/
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        int length = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            length++;
        }
        int[] data = new int[length];
        int pos = 0;
        while (head != null) {
            data[pos++] = head.val;
            head = head.next;
        }
        for (int i = 0, j = length - 1; i < j; i++, j--) {
            if (data[i] != data[j]) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = reverse(slow.next);
        slow.next = null;
        while (head != null && head2 != null) {
            if (head.val != head2.val) {
                return false;
            } else {
                head = head.next;
                head2 = head2.next;
            }
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur.next != null) {
            ListNode nex = cur.next;

            cur.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
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
        ListNode input1 = new ListNode(-1);
        ListNode tmp = input1;
        tmp.next = new ListNode(4);
        tmp = tmp.next;
        tmp.next = new ListNode(5);
        tmp = tmp.next;
        tmp.next = new ListNode(6);
        tmp = tmp.next;
        tmp.next = new ListNode(5);
        tmp = tmp.next;
        tmp.next = new ListNode(4);
        StringBuilder resultString = new StringBuilder();
        solution.toString(input1.next, resultString);
        System.err.println("result " + resultString.toString());
        System.err.println("result " + solution.isPalindrome(input1.next));
    }
}