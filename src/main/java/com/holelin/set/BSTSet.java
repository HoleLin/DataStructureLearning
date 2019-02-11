package com.holelin.set;

import com.holelin.tree.BST;

/**
 * ClassName: BSTSet
 * 基于二分搜索树实现集合
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/11
 */

public class BSTSet<E extends Comparable<E>> implements Set<E> {

	private BST<E> mBst;

	public BSTSet() {
		mBst = new BST<>();
	}

	@Override
	public void add(E e) {
		mBst.add(e);
	}

	@Override
	public void remove(E e) {
		mBst.remove(e);
	}

	@Override
	public boolean contains(E e) {
		return mBst.contains(e);
	}

	@Override
	public int getSize() {
		return mBst.size();
	}

	@Override
	public boolean isEmpty() {
		return mBst.isEmpty();
	}
}
