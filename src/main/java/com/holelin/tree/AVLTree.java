package com.holelin.tree;

import java.util.ArrayList;

/**
 * ClassName: AVLMap
 * AVL树(平衡二叉树)
 * -- 满足二分搜索树条件
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/17
 */

public class AVLTree<K extends Comparable<K>, V> {
	private Node root;
	private int size;

	public AVLTree() {
		root = null;
		size = 0;
	}

	/**
	 * 判断该二叉树是否是一颗平衡二叉树
	 *
	 * @return 是返回true;反之返回false;
	 */
	public boolean isBalanced() {
		return isBalanced(root);
	}

	/**
	 * 判断以node为根的二叉树是否是一颗平衡二叉树
	 *
	 * @param node 以node为根的二叉树
	 * @return 是返回true;反之返回false;
	 */
	private boolean isBalanced(Node node) {
		if (node == null) {
			return true;
		}
		int balanceFactor = getBalanceFactor(node);
		if (Math.abs(balanceFactor) > 1) {
			return false;
		}
		return isBalanced(node.left) && isBalanced(node.right);
	}

	/**
	 * 判断该二叉树是否是一颗二分搜索树
	 * -- 二分搜索树的前序遍历得到的序列是由低到高的升序序列
	 *
	 * @return 是返回true;不是返回false;
	 */
	public boolean isBST() {
		ArrayList<K> keys = new ArrayList<>();
		inOrder(root, keys);
		for (int i = 1; i < keys.size(); i++) {
			if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 对以node为根节点的二叉树进行前序遍历
	 *
	 * @param node 以node为根节点的二叉树
	 * @param keys 存放遍历的序列
	 */
	private void inOrder(Node node, ArrayList<K> keys) {
		if (node == null) {
			return;
		}
		inOrder(node.left, keys);
		keys.add(node.key);
		inOrder(node.right, keys);
	}

	/**
	 * 获取node的平衡因子
	 *
	 * @param node node节点
	 * @return node的平衡因子
	 */
	private int getBalanceFactor(Node node) {
		if (node == null) {
			return 0;
		}
		return getHeight(node.left) - getHeight(node.right);
	}

	/**
	 * 获得node节点的高度
	 *
	 * @param node 节点node
	 * @return node节点的高度
	 */
	private int getHeight(Node node) {
		if (node == null) {
			return 0;
		}
		return node.height;
	}

	public void add(K key, V value) {
		root = add(root, key, value);
	}

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
		// 对当前的node的height进行更新
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
		// 计算平衡因子
		int balanceFactor = getBalanceFactor(node);
		// 平衡维护
		// 若平衡因子大于1(原因为在它的左子树的左侧添加了一个元素)
		// 该树向左偏移,getBalanceFactor(node.left) >= 0 -- 表示左子树的高度大于右子树的高度
		// LL
		if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
			// 右旋转
			return rightRotate(node);
		}
		// 该树向右偏移,getBalanceFactor(node.right) <= 0 -- 表示左子树的高度小于右子树的高度
		// RR
		if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
			return leftRotate(node);
		}
		// LR
		if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
			// 对当前节点的左孩子进行左旋转 == >LL
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		// RL
		if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
			// 对当前节点的右孩子进行右旋转 == > RR
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		return node;
	}

	/**
	 * 对节点y进行向右旋转操作,返回旋转后新的根节点x
	 * ----------y                          x
	 * ---------/ \                        /  \
	 * -------x   T4   向右旋转(y)         z     y
	 * ------/ \      -------------->>   / \   / \
	 * -----z   T3                     T1  T2 T3 T4
	 * ----/ \
	 * --T1   T2
	 *
	 * @param y 对y节点操作
	 * @return 右旋转后的新的节点x
	 */
	private Node rightRotate(Node y) {
		Node x = y.left;
		Node T3 = x.right;
		// 向右旋转过程
		x.right = y;
		y.left = T3;
		// 更新height;
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

		return x;
	}

	/**
	 * 对节点y进行向左旋转操作,返回旋转后新的根节点x
	 * ----------y                          x
	 * ---------/ \                        /  \
	 * -------T1   x   向右旋转(y)         y     z
	 * -----------/ \  -------------->>  / \   / \
	 * ---------T2  z                  T1  T2 T3 T4
	 * ------------/ \
	 * ----------T3   T4
	 *
	 * @param y 对y节点操作
	 * @return 左旋转后的新的节点x
	 */
	private Node leftRotate(Node y) {
		Node x = y.right;
		Node T2 = x.left;

		// 向左旋转
		x.left = y;
		y.right = T2;
		// 更新height
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
		return x;
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
		Node retNode;
		if (key.compareTo(node.key) < 0) {
			// 到node左子树寻找
			node.left = remove(node.left, key);
			retNode = node;
		} else if (key.compareTo(node.key) > 0) {
			node.right = remove(node.right, key);
			retNode = node;
		} else {
			// 待删除节点左子树为空的情况
			if (node.left == null) {
				Node rightNode = node.right;
				node.right = null;
				size--;
				retNode = rightNode;
			} else if (node.right == null) {
				// 待删除节点右子树为空的情况
				Node leftNode = node.left;
				node.left = null;
				size--;
				retNode = leftNode;
			} else {
				// 待删除节点左右子树均不为空的情况
				// 找到比带删除节点大的最小的节点,即待删除节点右子树的最小节点
				// 用这个节点顶替待删除节点的位置
				Node successor = minimum(node.right);
				successor.right = remove(node.right, successor.key);
				successor.left = node.left;
				node.left = node.right = null;
				retNode = successor;
			}
		}
		if (retNode == null) {
			return null;
		}
		// 对当前的node的height进行更新
		retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));
		// 计算平衡因子
		int balanceFactor = getBalanceFactor(retNode);
		// 平衡维护
		// 若平衡因子大于1(原因为在它的左子树的左侧添加了一个元素)
		// 该树向左偏移,getBalanceFactor(node.left) >= 0 -- 表示左子树的高度大于右子树的高度
		// LL
		if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0) {
			// 右旋转
			return rightRotate(retNode);
		}
		// 该树向右偏移,getBalanceFactor(node.right) <= 0 -- 表示左子树的高度小于右子树的高度
		// RR
		if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0) {
			return leftRotate(retNode);
		}
		// LR
		if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
			// 对当前节点的左孩子进行左旋转 == >LL
			retNode.left = leftRotate(retNode.left);
			return rightRotate(retNode);
		}
		// RL
		if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
			// 对当前节点的右孩子进行右旋转 == > RR
			retNode.right = rightRotate(retNode.right);
			return leftRotate(retNode);
		}
		return retNode;
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
		 * 记录当前节点所处的高度值
		 */
		public int height;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
			height = 1;
		}
	}
}
