package com.holelin.queue;

import com.holelin.array.Array;

/**
 * ClassName: ArrayQueue
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/1/21
 */

public class ArrayQueue<E> implements Queue<E> {
    private Array<E> mArray;

    public ArrayQueue(int capacity) {
        mArray = new Array<>(capacity);
    }

    public ArrayQueue() {
        mArray = new Array<>();
    }

    @Override
    public void enqueue(E e) {
        mArray.addLast(e);
    }

    @Override
    public E dequeue() {
        return mArray.removeFirst();
    }

    @Override
    public E getFront() {
        return mArray.getFirst();
    }

    @Override
    public int getSize() {
        return mArray.getSize();
    }

    @Override
    public boolean isEmpty() {
        return mArray.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\n", mArray.getSize(), mArray.getCapacity()));
        res.append("front [");
        for (int i = 0; i < mArray.getSize(); i++) {
            res.append(mArray.get(i));
            if (i != mArray.getSize() - 1) {
                res.append(",");
            }
        }
        res.append("] tail ");
        return res.toString();
    }
}
