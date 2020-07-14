// https://leetcode-cn.com/problems/linked-list-cycle-ii
// 备注 本地无法直接执行验证。他使用的指针方式。也不需要直接判断值。
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode findCycleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode entrance = findCycleNode(head);
        if (entrance == null) {
            return null;
        }
        ListNode point1 = head;
        ListNode point2 = entrance;
        while (point1 != point2) {
            point1 = point1.next;
            point2 = point2.next;
        }
        return point1;
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
        ListNode input = new ListNode(3);
        ListNode tmp = input;
        tmp.next = new ListNode(2);
        tmp = tmp.next;
        tmp.next = new ListNode(0);
        tmp = tmp.next;
        tmp.next = new ListNode(-4);
        tmp = tmp.next;
        tmp.next = new ListNode(2);
        ListNode result = solution.detectCycle(input);
//        StringBuilder resultString = new StringBuilder();
//        solution.toString(result, resultString);
        System.err.println("result " + (result == null ? "null" : result.val));
    }
}