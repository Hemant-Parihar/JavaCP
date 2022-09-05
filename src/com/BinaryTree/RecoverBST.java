package com.BinaryTree;

public class RecoverBST {

    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    TreeNode first = null;
    TreeNode second = null;
    boolean find = false;

    public void recoverTree(TreeNode root) {
        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (find == false && root.val < prev.val) {
            // we got our first and second node.
            first = prev;
            second = root;
            find = true;
        } else if (find == true && root.val < prev.val) {
            second = root;
            return;
        }
        prev = root;
        inOrder(root.right);
    }

    public static void main(String[] args) {

    }
}
