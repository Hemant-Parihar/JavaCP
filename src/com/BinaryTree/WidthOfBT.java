package com.BinaryTree;

import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/maximum-width-of-binary-tree/
public class WidthOfBT {
    int width = Integer.MIN_VALUE;
    public int widthOfBinaryTree(TreeNode root) {
        solve(root, 1);
        return width;
    }

    void solve(TreeNode root, int index) {
        Deque<Pair<TreeNode, Integer>> queue = new LinkedList<Pair<TreeNode, Integer>>();
        queue.add(new Pair(root, index));
        queue.getFirst()
        int size;
        while(!queue.isEmpty()) {
            size = queue.size();
            int first = 0, last = 0;
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.peek().getKey();
                int nodeIndex = queue.poll().getValue();
                if (node.left != null) {
                    queue.add(new Pair(node.left, (2*nodeIndex)));
                }
                if (node.right != null) {
                    queue.add(new Pair(node.right, (2*nodeIndex + 1)));
                }
                if (i == 0) {
                    first = nodeIndex;
                }
                if (i == size - 1) {
                    last = nodeIndex;
                }
            }
            width = Math.max(width, last - first + 1);
        }
    }


}
