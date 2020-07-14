// https://leetcode-cn.com/problems/invert-binary-tree
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        TreeNode curNode;
        TreeNode left, right;
        while ((curNode = stack.poll()) != null) {
            left = curNode.left;
            right = curNode.right;
            curNode.right = left;
            curNode.left = right;
            if (left != null) {
                stack.offer(left);
            }
            if (right != null) {
                stack.offer(right);
            }
        }
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
        TreeNode input = new TreeNode(3);
        TreeNode tmp = input;
        tmp.left = new TreeNode(2);
        tmp.right = new TreeNode(0);
        TreeNode tmp1 = tmp.left;
        tmp1.left = new TreeNode(7);
        tmp1.right = new TreeNode(15);
        TreeNode tmp2 = tmp.right;
        tmp2.left = new TreeNode(-4);
        tmp2.right = new TreeNode(6);
        System.err.println("result ");
        solution.invertTree(input);
        List<List<Integer>> output=solution.levelOrder(input);
        for (List<Integer> item:output){
            System.err.println(item.toString());
        }
    }
}