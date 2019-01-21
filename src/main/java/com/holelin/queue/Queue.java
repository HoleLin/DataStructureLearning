package com.holelin.queue;

/**
 * ClassName: Queue
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/1/21
 */

public interface Queue<E> {
    /**
     * 将元素添加至队尾
     *
     * @param e 需入队的元素
     */
    void enqueue(E e);

    /**
     * 将队头元素出队
     *
     * @return 队头元素的值
     */
    E dequeue();

    /**
     * 获得队头元素
     *
     * @return 队头元素
     */
    E getFront();

    /**
     * 获得队中元素的个数
     *
     * @return 队中元素的个数
     */
    int getSize();

    /**
     * 判断队是否为空
     *
     * @return 若为空则返回true;反之返回false;
     */
    boolean isEmpty();
}
