// https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) return null;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }

    public TreeNode helper(int[] preorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = map.get(root.val);
        int leftChildLen = inRoot - inStart;
        root.left = helper(preorder, preStart + 1, preStart + leftChildLen, inStart, inRoot - 1, map);
        root.right = helper(preorder, preStart + leftChildLen + 1, preEnd, inRoot + 1, inEnd, map);

        return root;
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
        TreeNode input = solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.err.println("result ");
        List<List<Integer>> result = solution.levelOrder(input);
        for (List<Integer> item : result) {
            System.err.println(item.toString());
        }
    }
}