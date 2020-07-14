// https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            result.add(0, level);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode input = new TreeNode(1);
        input.left = new TreeNode(3);
        input.right = null;
        TreeNode tmp = input.left;
        tmp.right = new TreeNode(2);
        tmp.left = null;
        List<List<Integer>> result = solution.levelOrderBottom(input);
        for (List<Integer> item : result) {
            System.err.println(item.toString());
        }
    }
}