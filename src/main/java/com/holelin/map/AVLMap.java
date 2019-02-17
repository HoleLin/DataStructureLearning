package com.holelin.map;

import com.holelin.tree.AVLTree;

/**
 * ClassName: AVLMap
 * 基于AVL树实现的Map
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/17
 */

public class AVLMap<K extends Comparable<K>, V> implements Map<K, V> {
	private AVLTree<K, V> mAVLTree;

	public AVLMap() {
		mAVLTree = new AVLTree<>();
	}

	@Override
	public void add(K key, V value) {
		mAVLTree.add(key, value);
	}

	@Override
	public V remove(K key) {
		return mAVLTree.remove(key);
	}

	@Override
	public boolean contains(K key) {
		return mAVLTree.contains(key);
	}

	@Override
	public V get(K key) {
		return mAVLTree.get(key);
	}

	@Override
	public void set(K key, V value) {
		mAVLTree.set(key, value);
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
