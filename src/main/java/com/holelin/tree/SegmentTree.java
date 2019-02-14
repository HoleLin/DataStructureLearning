package com.holelin.tree;

/**
 * ClassName: SegmentTree
 * 基于数组的线段树
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/14
 */

public class SegmentTree<E> {
	/**
	 * 传入数组的副本
	 */
	private E[] data;
	/**
	 * 使用线段树的方式存储元素
	 */
	private E[] tree;

	private Merger<E> merger;

	public SegmentTree(E[] arr, Merger<E> merger) {
		this.merger = merger;
		data = (E[]) new Object[arr.length];
		// 将传入的数组复制一个副本
		for (int i = 0; i < arr.length; i++) {
			data[i] = arr[i];
		}
		// 存储arr.length长度的数据构建为线段树需要4*arr.length长度的数组
		tree = (E[]) new Object[4 * arr.length];
		buildSegmentTree(0, 0, data.length - 1);
	}

	/**
	 * 在treeIndex的位置创建表示区间[l...r]的线段树
	 *
	 * @param treeIndex 当前要创建的线段数根节点的索引
	 * @param l         要创建的区间的左边界
	 * @param r         要创建的区间的右边界
	 */
	private void buildSegmentTree(int treeIndex, int l, int r) {
		// 递归结束条件
		if (l == r) {
			tree[treeIndex] = data[l];
			return;
		}
		// 获取treeIndex的左孩子的索引
		int leftTreeIndex = leftChild(treeIndex);
		// 获取treeIndex的右孩子的索引
		int rightTreeIndex = rightChild(treeIndex);

		// 创建该节点的左右子树
		int mid = l + (r - l) / 2;
		// 创建左子树
		buildSegmentTree(leftTreeIndex, l, mid);
		// 创建右子树
		buildSegmentTree(rightTreeIndex, mid + 1, r);

		// 对区间设置含义(融合左右子树)
		tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
	}

	/**
	 * 返回区间[queryL,queryR]的值
	 *
	 * @param queryL 要查询区间的左边界
	 * @param queryR 要查询区间的左边界
	 * @return 区间[queryL, queryR]的值
	 */
	public E query(int queryL, int queryR) {
		// 边界检查
		if (queryL < 0 || queryL >= data.length ||
				queryR < 0 || queryR >= data.length || queryL > queryR) {
			throw new IllegalArgumentException("Index is illegal.");
		}
		return query(0, 0, data.length - 1, queryL, queryR);
	}

	/**
	 * 在当前treeIndex为根的线段树中[l,r]的范围中,搜索区间[queryL,queryR]的值
	 *
	 * @param treeIndex 当前树的根节点的索引
	 * @param l         当前节点所表示的区间的左边界
	 * @param r         当前节点所表示的区间的右边界
	 * @param queryL    要查询的区间的左边界
	 * @param queryR    要查询的区间的左边界
	 * @return 区间[queryL, queryR]的值
	 */
	private E query(int treeIndex, int l, int r, int queryL, int queryR) {
		// 递归介结束条件
		if (l == queryL && r == queryR) {
			return tree[treeIndex];
		}
		int mid = l + (r - l) / 2;
		int leftTreeIndex = leftChild(treeIndex);
		int rightTreeIndex = rightChild(treeIndex);
		if (queryL >= mid + 1) {
			// 要查询的左边界大于区间[l,r]的中间位置 -- 说明[l,mid]不需要查询
			// 直接查询[mid+1,r]区间
			return query(rightTreeIndex, mid + 1, r, queryL, queryR);
		} else if (queryR <= mid) {
			// 要查询的右边界小于区间[l,r]的中间位置 -- 说明[mid+1,r]不需要查询
			// 否则查询[l,mid]区间
			return query(leftTreeIndex, l, mid, queryL, queryR);
		} else {
			// 此时这种情况表示:要查询的区间[queryL,queryR] 一部分在[l,mid]区间中,一部分在[mid+1,r]区间中
			E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
			E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
			return merger.merge(leftResult, rightResult);
		}

	}

	/**
	 * 返回完全二叉树的数组表示中,一个索引表示的元素的左孩子节点的索引
	 * tips: 索引从0开始
	 *
	 * @param index 查找左孩子节点的索引
	 * @return 所查节点的左孩子节点的索引
	 */
	private int leftChild(int index) {
		return index * 2 + 1;
	}

	/**
	 * 返回完全二叉树的数组表示中,一个索引表示的元素的右孩子节点的索引
	 * tips: 索引从0开始
	 *
	 * @param index 查找右孩子节点的索引
	 * @return 所查节点的右孩子节点的索引
	 */
	private int rightChild(int index) {
		return index * 2 + 2;
	}

	/**
	 * 获取线段树中元素的个数
	 *
	 * @return 线段树中元素的个数
	 */
	public int getSize() {
		return data.length;
	}

	/**
	 * 获取索引为index的元素值
	 *
	 * @param index 索引为index的元素
	 * @return 索引为index的元素值
	 */
	public E get(int index) {
		if (index < 0 || index >= data.length) {
			throw new IllegalArgumentException("Index is illegal.");
		}

		return data[index];
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append('[');
		for (int i = 0; i < tree.length; i++) {
			if (tree[i] != null) {
				res.append(tree[i]);
			} else {
				res.append("null");
			}
			if (i != tree.length - 1) {
				res.append(", ");
			}
		}
		res.append(']');
		return res.toString();
	}
}
