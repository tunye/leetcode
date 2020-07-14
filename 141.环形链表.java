// https://leetcode-cn.com/problems/linked-list-cycle/
public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (slow != fast && fast != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast == null) {
                return false;
            }
            fast = fast.next;
        }
        return fast != null;
    }