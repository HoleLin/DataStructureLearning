package com.holelin.queue;

/**
 * ClassName: ArrayQueueTest
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/1/21
 */

public class LoopQueueTest {
    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 21; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }
        for (int i = 0; i < 12; i++) {
            queue.dequeue();
            System.out.println(queue);
        }

    }
}
