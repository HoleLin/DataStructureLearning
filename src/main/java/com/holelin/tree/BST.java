package com.holelin.tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * ClassName: BST
 * 二分搜索树: Binary Search Tree
 * 注: 二分搜索树存储的元素必须有可比较性;
 * 注: 本树不包含重复元素
 * -- 左子树小于节点
 * -- 右子树大于节点
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/4
 */

public class BST<E extends Comparable<E>> {
	/**
	 * 二分搜索树根节点
	 */
	private Node root;
	/**
	 * 树中元素的个数
	 */
	private int size;

	public BST() {
		root = null;
		size = 0;
	}

	/**
	 * 获取二分搜索树中元素的个数
	 *
	 * @return 二分搜索树中元素的个数
	 */
	public int size() {
		return size;
	}

	/**
	 * 判断二分搜索树是否为空
	 *
	 * @return 为空返回true;反之返回false;
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 向二分搜索树中添加新的元素e
	 *
	 * @param e 新添加的元素
	 */
	public void add(E e) {
		root = add(root, e);
	}

	/**
	 * 向以node为根的二分搜索树中插入元素E (使用递归)
	 *
	 * @param node 以node为根
	 * @param e    插入的元素
	 */
	private Node add(Node node, E e) {
		if (node == null) {
			size++;
			return new Node(e);
		}
		if (e.compareTo(node.data) < 0) {
			node.left = add(node.left, e);
		} else if (e.compareTo(node.data) > 0) {
			node.right = add(node.right, e);
		}
		return node;
	}

	/**
	 * 查询二分搜索树是否包含元素e
	 *
	 * @param e 查询元素e
	 * @return 存在返回true;反之返回false
	 */
	public boolean contains(E e) {
		return contains(root, e);
	}

	/**
	 * 看以node为根的二分搜索树是否包含元素e(递归算法)
	 *
	 * @param node 以node为根
	 * @param e    查询元素e
	 * @return 存在返回true;反之返回false
	 */
	private boolean contains(Node node, E e) {
		if (node == null) {
			return false;
		}
		if (e.equals(node.data)) {
			return true;
		} else if (e.compareTo(node.data) < 0) {
			return contains(node.left, e);
		} else {
			return contains(node.right, e);
		}
	}

	public void preOrder() {
		preOrder(root);
	}

	/**
	 * 二分搜索树的前序遍历以node为根
	 *
	 * @param node node为根
	 */
	private void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	/**
	 * 非递归的前序遍历
	 */
	public void preOrderNR() {
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			System.out.print(cur.data + " ");
			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}

		}
	}

	/**
	 * 中序遍历(顺序是有序的)
	 */
	public void inOrder() {
		inOrder(root);
	}

	/**
	 * 以node为根,中序遍历
	 *
	 * @param node 以node为根
	 */
	private void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}

	/**
	 * 后序遍历
	 */
	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");

	}

	/**
	 * 层次遍历
	 */
	public void levelOrder() {
		Queue<Node> q = new LinkedList<>();
		((LinkedList<Node>) q).add(root);
		while (!q.isEmpty()) {
			Node cur = q.remove();
			System.out.print(cur.data + " ");
			if (cur.left != null) {
				q.add(cur.left);
			}
			if (cur.right != null) {
				q.add(cur.right);
			}
		}

	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		generateBSTString(root, 0, res);
		return res.toString();
	}

	/**
	 * 生成以node为根节点,深度为depth的描述二叉树的字符串
	 *
	 * @param node  以node为根节点
	 * @param depth 深度为depth
	 * @param res   接收字符串
	 */
	private void generateBSTString(Node node, int depth, StringBuilder res) {
		if (node == null) {
			res.append(generateDepthString(depth)).append("NULL\n");
			return;
		}
		res.append(generateDepthString(depth)).append(node.data).append("\n");
		generateBSTString(node.left, depth + 1, res);
		generateBSTString(node.right, depth + 1, res);


	}

	private String generateDepthString(int depth) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			res.append("--");

		}
		return res.toString();
	}

	/**
	 * 寻找二分搜索树的最小元素
	 *
	 * @return 二分搜索树的最小元素
	 */
	public E minimum() {
		if (size == 0) {
			throw new IllegalArgumentException("BST is empty");
		}
		return minimum(root).data;
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
	 * 寻找二分搜索树的最大元素
	 *
	 * @return 二分搜索树的最大元素
	 */
	public E maximum() {
		if (size == 0) {
			throw new IllegalArgumentException("BST is empty");
		}
		return maximum(root).data;
	}

	/**
	 * 返回以node为根的二分搜索树的最小值所在的结点
	 *
	 * @param node 以node为根的二分搜索树
	 * @return 以node为根的二分搜索树的最小值所在的结点
	 */
	private Node maximum(Node node) {
		if (node.right == null) {
			return node;
		}
		return maximum(node.right);
	}

	/**
	 * 从二分搜索树中删除最小值所在的节点,返回最小值
	 *
	 * @return 返回最小值
	 */
	public E removeMin() {
		E ret = minimum();
		root = removeMin(root);
		return ret;
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

	/**
	 * 从二分搜索树中删除最大值所在的节点,返回最大值
	 *
	 * @return 返回最大值
	 */
	public E removeMax() {
		E ret = maximum();
		root = removeMax(root);
		return ret;
	}

	/**
	 * 删除掉以node为根的二分搜索树中的最大节点
	 * 返回删除节点后的新的二分搜索树的根
	 *
	 * @param node 以node为根的二分搜索树
	 * @return 返回删除节点后的新的二分搜索树的根
	 */
	private Node removeMax(Node node) {
		if (node.right == null) {
			Node leftNode = node.left;
			node.left = null;
			size--;
			return leftNode;
		}
		node.right = removeMax(node.right);
		return node;
	}

	public void remove(E e) {
		root = remove(root, e);
	}

	private Node remove(Node node, E e) {
		if (node == null) {
			return null;
		}
		if (e.compareTo(node.data) < 0) {
			// 到node左子树寻找
			node.left = remove(node.left, e);
			return node;
		} else if (e.compareTo(node.data) > 0) {
			node.right = remove(node.right, e);
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


	private class Node {
		/**
		 * 数据域
		 */
		public E data;
		/**
		 * 左子树地址域
		 */
		public Node left;
		/**
		 * 右子树地址域
		 */
		public Node right;

		public Node(E data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}


}
