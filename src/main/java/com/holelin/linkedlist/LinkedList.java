package com.holelin.linkedlist;

/**
 * ClassName: LinkedList
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/1/30
 */

public class LinkedList<E> {
	/**
	 * 设置虚拟头结点
	 */
	private Node dummyHead;
	/**
	 * 链表元素的个数
	 */
	private int size;

	public LinkedList() {
		dummyHead = new Node(null, null);
		size = 0;
	}

	/**
	 * 在链表的index(0-based)位置添加新的元素data
	 *
	 * @param data  新元素的值
	 * @param index 新元素的位置
	 */
	public void add(E data, int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Add failed .Illeal index.");
		}

		Node prev = dummyHead;
		// 找到index位置的前一位
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}
		prev.next = new Node(data, prev.next);
		// Node node =new Node(e);
		// node.next=prev.next;
		// prev.next=node;
		size++;

	}

	/**
	 * 在链表头添加元素
	 *
	 * @param data 新元素的值
	 */
	public void addFirst(E data) {
		add(data, 0);
	}

	/**
	 * 在链表尾部添加元素
	 *
	 * @param data 新元素的值
	 */
	public void addLast(E data) {
		add(data, size);
	}

	/**
	 * 获取链表元素的个数
	 *
	 * @return 链表元素的个数
	 */
	public int getSize() {
		return size;
	}

	/**
	 * 判断链表是否为空
	 *
	 * @return 为空返回true;反之返回false;
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 获取链表的第index位置上的元素
	 *
	 * @param index 指定的位置
	 * @return index位置上的值
	 */
	public E get(int index) {

		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Get failed. Illegal index.");
		}
		Node cur = dummyHead.next;
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		return cur.data;
	}

	/**
	 * 获取链表中第一个元素的值
	 *
	 * @return
	 */
	public E getFirst() {
		return get(0);
	}

	/**
	 * 获取链表中最后一个元素的值
	 *
	 * @return
	 */
	public E getLast() {
		return get(size - 1);
	}

	/**
	 * 修改链表的第index个位置的元素为data
	 *
	 * @param data  新的值
	 * @param index 第index位置
	 */
	public void set(E data, int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Set failed. Illegal index.");
		}
		Node cur = dummyHead.next;
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		cur.data = data;
	}

	public boolean contains(E data) {
		Node cur = dummyHead.next;
		while (cur != null) {
			if (cur.data.equals(data)) {
				return true;
			}
			cur = cur.next;
		}
		return false;
	}

	/**
	 * 删除第index位置的元素
	 *
	 * @param index 第index位置
	 * @return 删除元素的值
	 */
	public E remove(int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Remove failed. Illegal index.");
		}
		Node prev = dummyHead;
		// 找到待删除元素的前一位
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}
		Node delNode = prev.next;
		prev.next = delNode.next;
		delNode.next = null;
		size--;
		return delNode.data;
	}

	/**
	 * 删除第一个元素
	 *
	 * @return 第一个元素的值
	 */
	public E removeFirst() {
		return remove(0);
	}

	/**
	 * 删除最后一个元素
	 *
	 * @return 最后一个元素的值
	 */
	public E removeLast() {
		return remove(size - 1);
	}

	/**
	 * 删除链表中元素e
	 * @param e 元素e
	 */
	public void removeElement(E e) {
		Node prev = dummyHead;
		while (prev.next != null) {
			if (prev.next.data.equals(e)) {
				break;
			}
			prev = prev.next;
		}
		if (prev.next != null) {
			Node delNode = prev.next;
			prev.next = delNode.next;
			delNode.next = null;
		}
	}

	@Override
	public String toString() {

		StringBuilder res = new StringBuilder();
		Node cur = dummyHead.next;
		while (cur != null) {
			res.append(cur).append("->");
			cur = cur.next;
		}
		res.append("NULL");
		return res.toString();
	}

	private class Node {
		/**
		 * 数据域
		 */
		E data;
		/**
		 * 指针域
		 */
		Node next;

		/**
		 * 将传入的参数 连接到this指向的结点的后面
		 *
		 * @param data 后面的结点数据域
		 * @param next 后面的结点指针域
		 */
		public Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}

		public Node(E data) {
			this.data = data;
			this.next = null;
		}

		public Node() {
			this(null, null);
		}

		@Override
		public String toString() {
			return data.toString();
		}
	}


}
