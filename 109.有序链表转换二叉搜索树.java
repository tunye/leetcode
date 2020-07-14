// https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
public class Solution {
    ListNode head;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private int findListSize() {
        ListNode pointer = this.head;
        int size = 0;
        while (pointer != null) {
            pointer = pointer.next;
            size++;
        }
        return size;
    }

    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        int size = findListSize();
        return generateNode(0, size);
    }

    public TreeNode generateNode(int start, int end) {
        if (start >= end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode left = generateNode(start, mid);
        TreeNode treeNode = new TreeNode(head.val);
        treeNode.left = left;
        head = head.next;
        treeNode.right = generateNode(mid + 1, end);
        return treeNode;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> level;
        TreeNode curNode;
        while (queue.size() != 0) {
            level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                curNode = queue.poll();
                if (curNode != null) {
                    level.add(curNode.val);
//                    System.out.print(curNode.val + "  ");
                } else {
                    continue;
                }
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            result.add(level);
        }
        return result;
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
        ListNode input = new ListNode(-10);
        ListNode l = input;
        l.next = new ListNode(-3);
        l = l.next;
        l.next = new ListNode(-0);
        l = l.next;
        l.next = new ListNode(5);
        l = l.next;
        l.next = new ListNode(9);
        StringBuilder stringBuilder = new StringBuilder();
        solution.toString(input, stringBuilder);
        System.err.println(stringBuilder.toString());
        List<List<Integer>> result = solution.levelOrder(solution.sortedListToBST(input));
        for (List<Integer> item : result) {
            System.err.println(item.toString());
        }
    }
}