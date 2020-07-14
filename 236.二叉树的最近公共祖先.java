// https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, TreeNode> parent = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        dfs(root, parent);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    private void dfs(TreeNode root, Map<Integer, TreeNode> parent) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left, parent);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right, parent);
        }
    }
}