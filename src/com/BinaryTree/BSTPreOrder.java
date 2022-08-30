package com.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;

public class BSTPreOrder {
    public static void main(String[] args) {

    }

    public class Solution {
        public int solve(ArrayList<Integer> A) {
            ArrayList<Integer> inorder = new ArrayList<>(A);
            Collections.sort(inorder);
            return 2;
        }
    }
}
