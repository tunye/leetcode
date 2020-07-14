// https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return generateNode(nums, 0, nums.length);
    }

    public TreeNode generateNode(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = generateNode(nums, start, mid);
        treeNode.right = generateNode(nums, mid + 1, end);
        return treeNode;
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
            result.add(level);
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
        List<List<Integer>> result = solution.levelOrder(solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
        for (List<Integer> item : result) {
            System.err.println(item.toString());
        }
    }
}