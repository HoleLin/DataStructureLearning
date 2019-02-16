package com.holelin.unionfind;

/**
 * ClassName: QuickUnion
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/16
 */

public class QuickUnion implements UnionFind {
	private int[] parent;

	public QuickUnion(int size) {
		parent = new int[size];
		for (int i = 0; i < size; i++) {
			parent[i] = i;
		}
	}

	/**
	 * 查询元素p所对应的集合编号
	 * O(h) h为树的高度
	 *
	 * @param p 元素p
	 * @return 元素p所对应的集合编号
	 */
	private int find(int p) {
		if (p < 0 || p >= parent.length) {
			throw new IllegalArgumentException("p is out of bound");
		}
		// p == parent[p] -- p指向自己,此时p为根节点
		while (p != parent[p]) {
			p = parent[p];
		}
		return p;
	}

	@Override
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}

	@Override
	public void unionElements(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (qRoot == pRoot) {
			return;
		}
		parent[pRoot] = qRoot;
	}

	@Override
	public int getSize() {
		return parent.length;
	}
}
