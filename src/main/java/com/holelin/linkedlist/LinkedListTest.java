package com.holelin.linkedlist;

/**
 * ClassName: LinkedListTest
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/1/30
 */

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(99, 3);
        System.out.println(linkedList);

        linkedList.remove(3);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
