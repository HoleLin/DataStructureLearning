package com.holelin.stack;

import java.util.Random;

/**
 * ClassName: QueueEfficiencyTest
 * 测试ArrayQueue和LoopQueue的效率
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/1/30
 */

public class StackEfficiencyTest {
    public static void main(String[] args) {
        int opCount = 100000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testQueue(arrayStack, opCount);
        System.out.println("ArrayStack time is " + time1 + " s");
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testQueue(linkedListStack, opCount);
        System.out.println("LinkedListStack time is " + time2 + " s");

    }

    private static double testQueue(Stack<Integer> q, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }


}
