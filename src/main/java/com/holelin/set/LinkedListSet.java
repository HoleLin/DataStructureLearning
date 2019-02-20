package com.holelin.set;

import com.holelin.linkedlist.LinkedList;

/**
 * ClassName: LinkedListSet
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/11
 */

public class LinkedListSet<E extends Comparable<E>> implements Set<E> {
	private LinkedList<E> mLinkedList;

	public LinkedListSet() {
		mLinkedList = new LinkedList<>();
	}

	@Override
	public void add(E e) {
		if (!mLinkedList.contains(e)) {
			mLinkedList.addFirst(e);
		}
	}

	@Override
	public void remove(E e) {
		mLinkedList.removeElement(e);
	}

	@Override
	public boolean contains(E e) {
		return mLinkedList.contains(e);
	}

	@Override
	public int getSize() {
		return mLinkedList.getSize();
	}

	@Override
	public boolean isEmpty() {
		return mLinkedList.isEmpty();
	}
}
