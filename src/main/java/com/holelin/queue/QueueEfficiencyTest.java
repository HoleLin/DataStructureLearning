package com.holelin.queue;

import com.holelin.linearlist.Array;

import java.util.Random;

/**
 * ClassName: QueueEfficiencyTest
 * 测试ArrayQueue和LoopQueue的效率
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/1/30
 */

public class QueueEfficiencyTest {
    public static void main(String[] args) {
        int opCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue time is " + time1 + " s");
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue time is " + time2 + " s");
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, opCount);
        System.out.println("LinkedListQueue time is " + time3 + " s");

//        ArrayQueue time is 2.475480353 s
//        LoopQueue time is 0.008487905 s
    }

    private static double testQueue(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }


}
