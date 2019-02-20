package com.holelin.stack;

/**
 * ClassName: LinkedListStackTest
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/1/30
 */

public class LinkedListStackTest {
    public static void main(String[] args) {
        LinkedListStack<Integer> linkedList = new LinkedListStack<>();
        for (int i = 0; i <10; i++) {
            linkedList.push(i);
            System.out.println(linkedList);
        }
        linkedList.pop();
        System.out.println(linkedList);
    }
}
