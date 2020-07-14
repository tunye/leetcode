// https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode Apointer = headA, Bpointer = headB;
        while (Apointer != Bpointer) {
            Apointer = (Apointer == null) ? headB : Apointer.next;
            Bpointer = (Bpointer == null) ? headA : Bpointer.next;
        }
        return Apointer;
    }
}