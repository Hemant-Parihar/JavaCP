package com.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class NodeParentLevel2 {
    Integer level;
    Integer parentValue;

    NodeParentLevel2() {
        this.level = -1;
        this.parentValue = -1;
    }
}

//https://leetcode.com/problems/cousins-in-binary-tree/
public class Cousin2 {
    NodeParentLevel2 firstNode = new NodeParentLevel2();
    NodeParentLevel2 secondNode = new NodeParentLevel2();
    boolean firstAns = false;
    boolean secondAns = false;

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.poll();
    }
}
