package com.holelin.queue;

/**
 * ClassName: LinkedListQueueTest
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/1/30
 */

public class LinkedListQueueTest {
    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }
        for (int i = 0; i < 5; i++) {
            queue.dequeue();
            System.out.println(queue);
        }

    }
}
