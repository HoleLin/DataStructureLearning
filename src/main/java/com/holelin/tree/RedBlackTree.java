package com.holelin.tree;

import com.sun.org.apache.regexp.internal.RE;

/**
 * ClassName: RedBlackTree
 * 红黑树
 * 性质:
 * 1. 每个节点或者是红色的,或者是黑色的
 * 2. 根节点是黑色的
 * 3. 每一个叶子节点(最后的空节点)是黑色的
 * 4. 如果一个节点是红色的,那么它的孩子节点都是黑色的
 * 5. 从任意一个节点到叶子节点,经过的黑色节点是一样多的.
 * <p>
 * 2-3树中添加一个新元素
 * 或者添加进2-节点,形成3-节点
 * 或者添加进3-节点,暂时形成一个4-节点
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/18
 */

public class RedBlackTree<K extends Comparable<K>, V> {
	private Node root;
	private int size;

	public RedBlackTree() {
		root = null;
		size = 0;
	}

	/**
	 * 判断节点的颜色
	 *
	 * @param node 带判断的节点
	 * @return 节点的颜色
	 */
	private boolean isRed(Node node) {
		if (node == null) {
			return BLACK;
		}
		return node.color;
	}

	/**
	 * 对以node为根的树进行左旋转
	 * -----node                     x
	 * ----/   \     左旋转         /  \
	 * --T1   x   --------->   node   T3
	 * -------/ \              /   \
	 * ------T2 T3            T1   T2
	 *
	 * @param node 以node为根的树
	 * @return 左旋转之后新的根节点
	 */
	private Node leftRotate(Node node) {
		Node x = node.right;
		// 左旋转
		node.right = x.left;
		x.left = node;
		x.color = node.color;
		node.color = RED;
		return x;
	}

	/**
	 * 对以node为根的树进行右旋转
	 * ---node                   x
	 * ---/   \     右旋转       /  \
	 * --x    T2   ------->   y   node
	 * -/ \                       /  \
	 * y  T1                     T1  T2
	 *
	 * @param node 以node为根的树
	 * @return 右旋转之后新的根节点
	 */
	private Node rightRotete(Node node) {
		Node x = node.left;
		// 右旋转
		node.left = x.right;
		x.right = node;
		x.color = node.color;
		node.color = RED;
		return x;
	}

	/**
	 * 对以node为根的树进行颜色翻转
	 *
	 * @param node 以node为根的树
	 */
	private void flipColors(Node node) {
		node.color = RED;
		node.left.color = BLACK;
		node.right.color = BLACK;
	}

	/**
	 * 向红黑树添加元素
	 *
	 * @param key   键
	 * @param value 值
	 */
	public void add(K key, V value) {
		root = add(root, key, value);
		// 保持根节点为黑色节点
		root.color = BLACK;
	}

	/**
	 * 向以node为根的红黑树中插入元素(key,value),递归算法
	 *
	 * @param node  以node为根的红黑树
	 * @param key   键
	 * @param value 值
	 * @return 返回插入新节点后红黑树的根
	 */
	private Node add(Node node, K key, V value) {

		if (node == null) {
			size++;
			return new Node(key, value);
		}
		if (key.compareTo(node.key) < 0) {
			node.left = add(node.left, key, value);
		} else if (key.compareTo(node.key) > 0) {
			node.right = add(node.right, key, value);
		} else {
			node.value = value;
		}
		// 右孩子为红色,左孩子不为红色 进行左旋转
		if (isRed(node.right) && !isRed(node.left)) {
			node = leftRotate(node);
		}
		// 左孩子为红色,左孩子的左孩子也为红色 进行右旋转
		if (isRed(node.left) && isRed(node.left.left)) {
			node = rightRotete(node);
		}
		// 左右孩子都为红色 进行颜色反转
		if (isRed(node.left) && isRed(node.right)) {
			flipColors(node);
		}
		return node;
	}

	private Node getNode(Node node, K key) {
		if (node == null) {
			return null;
		}
		if (node.key.compareTo(key) == 0) {
			return node;
		} else if (node.key.compareTo(key) < 0) {
			return getNode(node.left, key);
		} else {
			return getNode(node.right, key);
		}
	}

	public V remove(K key) {
		Node node = getNode(root, key);
		if (node != null) {
			root = remove(root, key);
			return root.value;
		}
		return null;
	}


	private Node remove(Node node, K key) {
		if (node == null) {
			return null;
		}
		if (key.compareTo(node.key) < 0) {
			// 到node左子树寻找
			node.left = remove(node.left, key);
			return node;
		} else if (key.compareTo(node.key) > 0) {
			node.right = remove(node.right, key);
			return node;
		} else {
			// 待删除节点左子树为空的情况
			if (node.left == null) {
				Node rightNode = node.right;
				node.right = null;
				size--;
				return rightNode;
			}
			// 待删除节点右子树为空的情况
			if (node.right == null) {
				Node leftNode = node.left;
				node.left = null;
				size--;
				return leftNode;
			}
			// 带删除节点左右子树均不为空的情况
			// 找到比带删除节点大的最小的节点,即待删除节点右子树的最小节点
			// 用这个节点顶替待删除节点的位置
			Node successor = minimum(node.right);
			successor.right = removeMin(node.right);
			successor.left = node.left;
			node.left = node.right = null;
			return successor;
		}
	}

	/**
	 * 返回以node为根的二分搜索树的最小值所在的结点
	 *
	 * @param node 以node为根的二分搜索树
	 * @return 以node为根的二分搜索树的最小值所在的结点
	 */
	private Node minimum(Node node) {
		if (node.left == null) {
			return node;
		}
		return minimum(node.left);
	}

	/**
	 * 删除掉以node为根的二分搜索树中的最小节点
	 * 返回删除节点后的新的二分搜索树的根
	 *
	 * @param node 以node为根的二分搜索树
	 * @return 返回删除节点后的新的二分搜索树的根
	 */
	private Node removeMin(Node node) {
		if (node.left == null) {
			Node rightNode = node.right;
			node.right = null;
			size--;
			return rightNode;
		}
		node.left = removeMin(node.left);
		return node;
	}


	public boolean contains(K key) {
		return getNode(root, key) != null;
	}


	public V get(K key) {
		Node node = getNode(root, key);
		return node == null ? null : node.value;
	}


	public void set(K key, V value) {
		Node node = getNode(root, key);
		if (node == null) {
			throw new IllegalArgumentException(key + "doesn't exist!");
		}
		node.value = value;
	}


	public int getSize() {
		return size;
	}


	public boolean isEmpty() {
		return size == 0;
	}

	private static final boolean RED = true;
	private static final boolean BLACK = false;

	private class Node {
		/**
		 * 键
		 */
		public K key;
		/**
		 * 值
		 */
		public V value;
		/**
		 * 左子树地址域
		 */
		public Node left;
		/**
		 * 右子树地址域
		 */
		public Node right;
		/**
		 * 标记红黑节点
		 */
		public boolean color;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
			this.color = RED;
		}
	}

}
