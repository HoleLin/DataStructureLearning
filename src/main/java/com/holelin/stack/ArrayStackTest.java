package com.holelin.stack;

/**
 * ClassName: ArrayStackTest
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/1/21
 */

public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 21; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }
        arrayStack.pop();
        System.out.println(arrayStack);
    }
}
