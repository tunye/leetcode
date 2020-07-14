// 二叉树遍历相关  144 94 145 102
package com.buaa.vr.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            if (curNode != null) {
                result.add(curNode.val);
//                System.out.print(curNode.val + "  ");
                stack.push(curNode);
                curNode = curNode.left;
            } else {
                curNode = stack.pop().right;
            }
        }
        return result;
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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            if (curNode != null) {
                result.add(curNode.val);
                System.out.print(curNode.val + "  ");
                stack.push(curNode);
                curNode = curNode.right;
            } else {
                curNode = stack.pop().left;
            }
        }
        Collections.reverse(result);
        return result;
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        doPostOrderTraversal(root, result);
        return result;
    }

    public void doPostOrderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            doPostOrderTraversal(root.left, result);
            doPostOrderTraversal(root.right, result);
            result.add(root.val);
            // System.out.print(root.val + "  ");
        }
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
        tmp = tmp.left;
        tmp.left = new TreeNode(7);
        tmp.right = new TreeNode(15);
        tmp = tmp.right;
        tmp.left = new TreeNode(-4);
        tmp.right = new TreeNode(6);
        System.err.println("result ");
        solution.postorderTraversal(input);
    }
}