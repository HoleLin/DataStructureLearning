package com.holelin.queue;

import com.holelin.heap.MaxHeap;

/**
 * ClassName: PriorityQueue
 * 基于堆的优先队列
 * ******************入队        出队(拿出最大元素)
 * -- 普通线性结构    O(1)        O(n)
 * -- 顺序线性结构    O(n)        O(1)
 * -- 堆             O(logn)     O(logn)
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/13
 */

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
	private MaxHeap<E> mMaxHeap;

	public PriorityQueue() {
		mMaxHeap = new MaxHeap<>();
	}

	@Override
	public void enqueue(E e) {
		mMaxHeap.add(e);
	}

	@Override
	public E dequeue() {
		return mMaxHeap.extractMax();
	}

	@Override
	public E getFront() {
		return mMaxHeap.findMax();
	}

	@Override
	public int getSize() {
		return mMaxHeap.size();
	}

	@Override
	public boolean isEmpty() {
		return mMaxHeap.isEmpty();
	}
}
