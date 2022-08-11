package com.linklist;

public class LinkedList {

    private Node head;
    private Node tail;
    public int size;

    public LinkedList() {
    }

    public void insertToList(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void insertAtTail(int val) {
        Node node = new Node(val);
        if (tail != null) {
            tail.next = node;
        } else {
            head = node;
        }
        tail = node;
        size += 1;
    }

    public void displayList() {
        Node ptr = head;
        while(ptr != null) {
            System.out.print(ptr.val + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public static class Node {
        private int val;
        private Node next;
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

}
