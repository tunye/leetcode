// https://leetcode-cn.com/problems/validate-binary-search-tree/
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curNode = root;
        TreeNode tmp;
        while (curNode != null || !stack.isEmpty()) {
            if (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            } else {
                tmp = stack.pop();
                result.add(tmp.val);
//                System.err.println(tmp.val+" ");
                curNode = tmp.right;
            }
        }
        return result;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return handle(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean handle(TreeNode root, long high, long low) {
        if (root == null) {
            return true;
        }
        if (root.val <= low || root.val >= high) {
            return false;
        }
        return handle(root.left, root.val, low) && handle(root.right, high, root.val);
    }

    public boolean isValidBST2(TreeNode root) {
        List<Integer> inorder = inorderTraversal(root);
        for (int i = 0; i < inorder.size() - 1; i++) {
            if (inorder.get(i) >= inorder.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}