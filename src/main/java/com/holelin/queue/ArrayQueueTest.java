package com.holelin.queue;

/**
 * ClassName: ArrayQueueTest
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/1/21
 */

public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 21; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }
        for (int i = 0; i < 11; i++) {
            queue.dequeue();
            System.out.println(queue);
        }

    }
}
