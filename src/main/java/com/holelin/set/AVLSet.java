package com.holelin.set;

import com.holelin.tree.AVLTree;

/**
 * ClassName: AVLSet
 * 基于AVL树实现的Set
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/17
 */

public class AVLSet<E extends Comparable<E>> implements Set<E> {
	private AVLTree<E, Object> mAVLTree;

	public AVLSet() {
		mAVLTree = new AVLTree<>();
	}

	@Override
	public void add(E e) {
		mAVLTree.add(e, null);
	}

	@Override
	public void remove(E e) {
		mAVLTree.remove(e);
	}

	@Override
	public boolean contains(E e) {
		return mAVLTree.contains(e);
	}

	@Override
	public int getSize() {
		return mAVLTree.getSize();
	}

	@Override
	public boolean isEmpty() {
		return mAVLTree.isEmpty();
	}
}
