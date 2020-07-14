// https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        TreeNode tmp;
        while (!queue.isEmpty()) {
            depth++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                tmp = queue.pollFirst();
                if (tmp != null) {
                    if (tmp.left != null) {
                        queue.offer(tmp.left);
                    }
                    if (tmp.right != null) {
                        queue.offer(tmp.right);
                    }
                }
            }
        }
        return depth;
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
            result.add(level);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode input = new TreeNode(0);
        TreeNode tmp = input;
        tmp.left = new TreeNode(2);
        tmp.right = new TreeNode(4);
        TreeNode tmp2 = tmp.left;
        TreeNode tmp3 = tmp.right;
        tmp2.left = new TreeNode(1);
        tmp2.right = null;
        tmp3.left = new TreeNode(-3);
        tmp3.right = new TreeNode(1);
        TreeNode tmp4 = tmp2.left;
        TreeNode tmp5 = tmp3.left;
        TreeNode tmp6 = tmp3.right;
        tmp4.left = new TreeNode(5);
        tmp4.right = new TreeNode(1);
        tmp5.left = null;
        tmp5.right = new TreeNode(6);
        tmp6.left = null;
        tmp6.right = new TreeNode(8);
        System.err.println("result " + solution.maxDepth(input));
        List<List<Integer>> level = solution.levelOrder(input);
        for (List<Integer> item : level) {
            System.err.println(item);
        }
    }
}