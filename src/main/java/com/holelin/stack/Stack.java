package com.holelin.stack;
/**
 * 栈
 * @param <E> 元素类型
 */
public interface Stack<E> {
    /**
     * 入栈 -- 将元素放入栈顶
     * @param e 入栈的元素
     */
    void push(E e);

    /**
     * 出栈 -- 将栈顶元素出栈
     * @return 栈顶元素的值
     */
    E pop();

    /**
     * 获取栈顶元素,但不出栈
     * @return 栈顶元素的值
     */
    E peek();

    /**
     * 获取栈中元素的个数
     * @return 栈中元素的个数
     */
    int getSize();

    /**
     * 判断栈是否为空
     * @return 栈为空返回true;栈不为空返回false
     */
    boolean isEmpty();

}
