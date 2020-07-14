// https://leetcode-cn.com/problems/add-two-numbers
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tmp = 0;
        ListNode result = new ListNode(-1);
        ListNode cur = result;
        while (l1 != null || l2 != null) {
            cur.next = new ListNode(tmp + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val));
            cur = cur.next;
            tmp = 0;
            if (cur.val >= 10) {
                tmp = 1;
                cur.val = cur.val - 10;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (tmp != 0) {
            cur.next = new ListNode(tmp);
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
        ListNode input1 = new ListNode(-1);
        ListNode tmp = input1;
        tmp.next = new ListNode(9);
        tmp = tmp.next;
        tmp.next = new ListNode(9);
        ListNode input2 = new ListNode(-1);
        tmp = input2;
        tmp.next = new ListNode(1);
        ListNode result = solution.addTwoNumbers(input1.next, input2.next);
        StringBuilder resultString = new StringBuilder();
        solution.toString(result, resultString);
        System.err.println("result " + resultString.toString());
    }
}