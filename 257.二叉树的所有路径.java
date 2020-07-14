// https://leetcode-cn.com/problems/binary-tree-paths/
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<String> result = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        doHandle(result, "", root);
        return result;
    }

    private void doHandle(List<String> result, String tmp, TreeNode cur) {
        if (cur == null) {
            return;
        }
        tmp += Integer.toString(cur.val);
        if (cur.left == null && cur.right == null) {
            result.add(tmp);
        } else {
            tmp += "->";
            doHandle(result, tmp, cur.left);
            doHandle(result, tmp, cur.right);
        }
    }
}