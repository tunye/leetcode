//https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder result = new StringBuilder();
        result.append('[');
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode curNode;
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                curNode = queue.poll();
                if (curNode == null) {
                    result.append("null");
                } else {
                    result.append(curNode.val);
                }
                result.append(',');
                if (curNode != null) {
                    queue.offer(curNode.left);
                    queue.offer(curNode.right);
                }
            }
        }
        return result.substring(0, result.length() - 1) + "]";
    }

    public TreeNode deserialize(String data) {
        if ("[]".equals(data)) {
            return null;
        }
        String[] item = data.substring(1, data.length() - 1).split(",");
        int i = 1;
        TreeNode result = new TreeNode(Integer.parseInt(item[0]));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(result);
        TreeNode cur;
        while (!queue.isEmpty() && i < item.length) {
            cur = queue.poll();
            if (!item[i].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(item[i]));
                queue.add(cur.left);
            }
            i++;
            if (!item[i].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(item[i]));
                queue.add(cur.right);
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        TreeNode tmp = treeNode.right;
        tmp.left = new TreeNode(4);
        tmp.right = new TreeNode(5);
//        System.err.println((solution.serialize(treeNode)));
        System.err.println(solution.serialize(solution.deserialize("[]")));
    }
}