package com.BinaryTree;

//https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBST2 {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        return validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean validateBST(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val > min && node.val < max) {
            return validateBST(node.left, min, node.val) && validateBST(node.right, node.val, max);
        } else {
            return false;
        }
    }
}
