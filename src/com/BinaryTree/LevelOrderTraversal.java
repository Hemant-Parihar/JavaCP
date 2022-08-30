package com.BinaryTree;

import java.util.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Definition for a binary tree node.
class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

//https://leetcode.com/problems/binary-tree-level-order-traversal/
public class LevelOrderTraversal {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ansList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ansList.add(new ArrayList<>(Arrays.asList(root.val)));
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> newQueue = new LinkedList<>();
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    newQueue.add(node.left);
                }
                if (node.right != null) {
                    newQueue.add(node.right);
                }
                list.add(node.val);
            }
            queue = newQueue;
            ansList.add(list);
        }
        return ansList;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ansList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelSize;
        TreeNode node;
        while(!queue.isEmpty()) {
            levelSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < levelSize; i++) {
                node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                list.add(node.val);
            }
            ansList.add(list);
        }
        return ansList;
    }

    // Reverse level order traversal.
    public List<List<Integer>> levelOrderRev(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ansList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelSize;
        TreeNode node;
        while(!queue.isEmpty()) {
            levelSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < levelSize; i++) {
                node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                list.add(node.val);
            }
            ansList.add(list);
        }
        Collections.reverse(ansList);
        return ansList;
    }

    // Zig-Zag level order traversal.
    public List<List<Integer>> levelOrderZigZag(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ansList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelSize;
        TreeNode node;
        int level = 0;
        while(!queue.isEmpty()) {
            levelSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < levelSize; i++) {
                node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                list.add(node.val);
            }
            if (level % 2 == 1) {
                Collections.reverse(list);
            }
            level++;
            ansList.add(list);
        }
        return ansList;
    }

    // N-ary Tree Level Order Traversal
    public List<List<Integer>> levelOrderN(Node root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ansList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int levelSize;
        Node node;
        while(!queue.isEmpty()) {
            levelSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < levelSize; i++) {
                node = queue.poll();
                List<Node> children = node.children;
                for(int j = 0; j < children.size(); j++) {
                    queue.add(children.get(j));
                }
                list.add(node.val);
            }
            ansList.add(list);
        }
        return ansList;
    }

    // Binary Tree Right Side View
    public List<Integer> levelOrderRightSide(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> ansList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelSize;
        TreeNode node;
        while(!queue.isEmpty()) {
            levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (i == levelSize - 1) {
                    ansList.add(node.val);
                }
            }

        }
        return ansList;
    }
}
