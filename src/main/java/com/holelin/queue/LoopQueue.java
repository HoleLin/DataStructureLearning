package com.holelin.queue;

/**
 * ClassName: LoopQueue
 * 循环队列
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/1/27
 */

public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    /**
     * 队头元素指针
     */
    private int front;
    /**
     * 队尾元素指针
     */
    private int tail;
    /**
     * 队列中元素的个数
     */
    private int size;

    /**
     * 设置指定容量的构造函数
     *
     * @param capacity 指定容量
     */
    public LoopQueue(int capacity) {
        // 需要浪费一个空间
        this.data = (E[]) new Object[capacity + 1];
        this.front = 0;
        this.tail = 0;
        this.size = 0;
    }

    /**
     * 默认容量的构造函数
     */
    public LoopQueue() {
        // 需要浪费一个空间
        this(10);
    }

    /**
     * 获取队列的容量
     *
     * @return
     */
    public int getCapcity() {
        return data.length - 1;
    }

    /**
     * 入队
     *
     * @param e 需入队的元素
     */
    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            // 队列是满的
            resize(getCapcity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 扩容
     *
     * @param newCapacity 扩大的容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            // data中第一个元素的位置可能不是0下标位置
            // 此处使用(front+i)%data.length来将data中元素复制到newData中
            newData[i] = data[(front + i) % data.length];
        }
        this.data = newData;
        front = 0;
        tail = size;
    }

    /**
     * 出队
     *
     * @return 出队元素的值
     */
    @Override
    public E dequeue() {
        // 判断队列中是否为空
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue form an empty queue");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapcity()/ 4 && getCapcity() / 2 != 0) {
            resize(getCapcity() / 2);
        }
        return ret;

    }

    /**
     * 获取对首元素的值
     *
     * @return 对首元素的值
     */
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return data[front];
    }

    /**
     * 获取队列中元素的个数
     *
     * @return 队列中元素的个数
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 判断队列是否非空
     *
     * @return 为空, 返回true;反之返回false;
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        res.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapcity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i+1)%data.length!=tail) {
                res.append(", ");
            }
        }
        res.append("] tail ");
        return res.toString();
    }
}
