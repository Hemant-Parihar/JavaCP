package com.linklist;

public class List {
    public static void main(String[] args) {
        LinkedList LL = new LinkedList();
        LL.insertToList(5);
        LL.insertToList(6);
        LL.insertToList(14);
        LL.displayList();
        System.out.println(LL.size);
    }
}
