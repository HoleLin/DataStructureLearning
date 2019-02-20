package com.holelin.array;

/**
 * ClassName: ArrayTest
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/1/19
 */

public class ArrayTest {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(20);
        for (int i = 0; i < 19; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.add(1, 100);
        System.out.println(arr);
        arr.addFirst(-1);
        System.out.println(arr);
        arr.remove(2);
        System.out.println(arr);
        arr.removeElement(5);
        System.out.println(arr);
        arr.removeFirst();
        System.out.println(arr);
        arr.add(1, 100);
        System.out.println(arr);
        arr.add(1, 100);
        System.out.println(arr);
        arr.add(1, 100);
        System.out.println(arr);
        arr.add(1, 100);
        System.out.println(arr);
        arr.remove(2);
        System.out.println(arr);
        arr.remove(2);
        System.out.println(arr);
        arr.remove(2);
        System.out.println(arr);
        arr.remove(2);
        System.out.println(arr);
        arr.remove(2);
        System.out.println(arr);
        arr.remove(2);
        System.out.println(arr);
        arr.remove(2);
        System.out.println(arr);
        arr.remove(2);
        System.out.println(arr);
        arr.remove(2);
        System.out.println(arr);
        arr.remove(2);
        System.out.println(arr);
        arr.remove(2);
        System.out.println(arr);
        arr.remove(2);
        System.out.println(arr);
    }
}
