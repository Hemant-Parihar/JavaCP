package com.BinaryTree;

class NodeParentLevel {
    Integer level;
    Integer parentValue;

    NodeParentLevel() {
        this.level = -1;
        this.parentValue = -1;
    }
}

//https://leetcode.com/problems/cousins-in-binary-tree/
public class Cousin {
    NodeParentLevel firstNode = new NodeParentLevel();
    NodeParentLevel secondNode = new NodeParentLevel();
    boolean firstAns = false;
    boolean secondAns = false;

    public boolean isCousins(TreeNode root, int x, int y) {
        solve(root, x, y, 0, -1);
        if (firstNode.level == secondNode.level && firstNode.parentValue != secondNode.parentValue) {
            return true;
        } else {
            return false;
        }
    }

    public void solve(TreeNode node, int x, int y, int level, int parent) {
        if (node == null) return;
        if (node.val == x || node.val == y) {
            if (firstAns == false) {
                firstNode.level = level;
                firstNode.parentValue = parent;
                firstAns = true;
            } else {
                secondNode.level = level;
                secondNode.parentValue = parent;
                secondAns = true;
                return;
            }
        }
        solve(node.left, x, y, level + 1, node.val);
        solve(node.right, x, y, level + 1, node.val);
    }

    public static void main(String[] args) {

    }
}
