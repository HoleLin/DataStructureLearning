package com.holelin.unionfind;

/**
 * 并查集接口
 */
public interface UnionFind {
	/**
	 * p,q是否属于同一集合
	 *
	 * @param p p表示的元素
	 * @param q q表示的元素
	 * @return 是返回tue;反之返回false;
	 */
	boolean isConnected(int p, int q);

	/**
	 * 合并两个元素所属的集合
	 *
	 * @param p p表示的元素
	 * @param q q表示的元素
	 */
	void unionElements(int p, int q);

	/**
	 * 返回并查集中元素的个数
	 *
	 * @return 并查集中元素的个数
	 */
	int getSize();
}
