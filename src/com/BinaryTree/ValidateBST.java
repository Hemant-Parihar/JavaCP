package com.BinaryTree;

//https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBST {
    public static void main(String[] args) {

    }
    long prev = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        return validateBST(root);
    }

    boolean validateBST(TreeNode node) {
        if (node == null) return true;
        if (validateBST(node.left) && node.val > prev) {
            prev = node.val;
            return validateBST(node.right);
        } else {
            return false;
        }
    }
}
