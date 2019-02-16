package com.holelin.unionfind;

/**
 * ClassName: QuickFind
 * 并查集第一版 (Quick Find)
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/16
 */

public class QuickFind implements UnionFind {
	private int[] id;

	public QuickFind(int size) {
		id = new int[size];
		// 设置每个元素的集合编号
		for (int i = 0; i < size; i++) {
			id[i] = i;
		}
	}

	/**
	 * 查询元素p所对应的集合编号
	 *
	 * @param p 元素p
	 * @return 元素p所对应的集合编号
	 */
	private int find(int p) {
		if (p < 0 || p >= id.length) {
			throw new IllegalArgumentException("p is out of bound");
		}
		return id[p];
	}

	/**
	 * O(1)
	 */
	@Override
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}

	/**
	 * O(n)
	 */
	@Override
	public void unionElements(int p, int q) {
		int pID = find(p);
		int qID = find(q);

		if (pID == qID) {
			return;
		}
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pID) {
				id[i] = qID;
			}
		}
	}

	@Override
	public int getSize() {
		return id.length;
	}
}
