// https://leetcode-cn.com/problems/path-sum-ii/submissions/
public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return result;
        }
        handle(root, sum);
        return result;
    }

    private void handle(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        tmp.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            result.add(new ArrayList<>(tmp));
        }
        handle(root.left, sum);
        handle(root.right, sum);
        tmp.remove(tmp.size() - 1);
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
        TreeNode input = new TreeNode(5);
        TreeNode tmp = input;
        tmp.left = new TreeNode(4);
        tmp.right = new TreeNode(8);
        TreeNode tmp1 = tmp.left;
        tmp1.left = new TreeNode(11);
        tmp1.right = null;
        TreeNode tmp2 = tmp.right;
        tmp2.left = new TreeNode(13);
        tmp2.right = new TreeNode(4);
        TreeNode tmp3 = tmp1.left;
        tmp3.left = new TreeNode(7);
        tmp3.right = new TreeNode(2);
        TreeNode tmp4 = tmp2.right;
        tmp4.left = new TreeNode(5);
        tmp4.right = new TreeNode(1);
        System.err.println("result ");
        List<List<Integer>> result = solution.pathSum(input, 22);
        for (List<Integer> item : result) {
            System.err.println(item.toString());
        }
    }
}
