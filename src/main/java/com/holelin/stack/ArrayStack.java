package com.holelin.stack;

import com.holelin.array.Array;

/**
 * ClassName: ArrayStack
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/1/21
 */

public class ArrayStack<E> implements Stack<E> {
    private Array<E> mArray;

    /**
     * 创建指定栈的容量
     *
     * @param capacity
     */
    public ArrayStack(int capacity) {
        mArray = new Array<>(capacity);
    }

    /**
     * 创建使用默认容量的栈
     */
    public ArrayStack() {
        mArray = new Array<>();
    }

    public int getCapacity() {
        return mArray.getCapacity();
    }

    @Override
    public void push(E e) {
        // 放入数组的末尾
        mArray.addLast(e);
    }

    @Override
    public E pop() {
        return mArray.removeLast();
    }

    @Override
    public E peek() {
        return mArray.getLast();
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
        res.append(String.format("Stack: size = %d, capacity = %d\n", mArray.getSize(),mArray.getCapacity()));

        res.append('[');
        for (int i = 0; i < mArray.getSize(); i++) {
            res.append(mArray.get(i));
            if (i != mArray.getSize() - 1) {
                res.append(",");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
