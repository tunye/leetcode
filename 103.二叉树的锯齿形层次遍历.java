// https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> level;
        TreeNode curNode;
        boolean order = true;
        while (true) {
            level = new ArrayList<>();
            int size = queue.size();
            if (size == 0) {
                return result;
            }
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
            if (order) {
                result.add(level);
            } else {
                Collections.reverse(level);
                result.add(level);
            }
            order = !order;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode input = new TreeNode(3);
        TreeNode tmp = input;
        tmp.left = new TreeNode(2);
        tmp.right = new TreeNode(0);
        tmp = tmp.left;
        tmp.left = new TreeNode(7);
        tmp.right = new TreeNode(15);
        tmp = tmp.right;
        tmp.left = new TreeNode(-4);
        tmp.right = new TreeNode(6);
        System.err.println("result ");
        List<List<Integer>> result = solution.zigzagLevelOrder(input);
        for (List<Integer> item : result) {
            System.err.println(item.toString());
        }
    }
}