package com.holelin.unionfind;

/**
 * ClassName: QuickUnion
 * 基于size优化
 * @author HoleLin
 * @version 2.0
 * @date 2019/2/16
 */

public class QuickUnion implements UnionFind {
	private int[] parent;
	/**
	 * sz[i] 表示以i为根的集合中元素个数
	 */
	private int[] sz;

	public QuickUnion(int size) {
		parent = new int[size];
		sz = new int[size];
		for (int i = 0; i < size; i++) {
			parent[i] = i;
			sz[i] = 1;
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
		// 将元素个数较少的集合指向元素个数多的集合
		if (sz[pRoot] < sz[qRoot]) {
			// pRoot的根节点指向qRoot
			parent[pRoot] = qRoot;
			// 将以pRoot为根的树中元素个数加到以qRoot为根的树
			sz[qRoot] += sz[pRoot];

		} else {
			parent[qRoot] = pRoot;
			sz[pRoot] += sz[qRoot];
		}


	}

	@Override
	public int getSize() {
		return parent.length;
	}
}
