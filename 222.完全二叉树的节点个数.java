// https://leetcode-cn.com/problems/count-complete-tree-nodes/
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countLevel(root.left);
        int count = 0;
        while (root != null) {
            int right = countLevel(root.right);
            if (right == left) {
                count += (1 << left);
                root = root.right;
            } else {
                count += (1 << right);
                root = root.left;
            }
            left--;
        }
        return count;
    }

    public int countLevel(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 0;
        while (root != null) {
            root = root.left;
            height++;
        }
        return height;
    }

    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode tmp;
        int childCount = 0;
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            if (tmp != null) {
                childCount++;
                queue.offer(tmp.left);
                queue.offer(tmp.right);
            }
        }
        return childCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        TreeNode treeNodeL2 = treeNode.left;
        treeNodeL2.left = new TreeNode(4);
        treeNodeL2.right = new TreeNode(5);
        TreeNode treeNodeR2 = treeNode.right;
        treeNodeR2.left = new TreeNode(6);
        treeNodeR2.right = new TreeNode(7);
        TreeNode treeNodeL3 = treeNodeL2.left;
        treeNodeL3.left = new TreeNode(8);
        System.err.println(solution.countNodes(treeNode));
    }
}