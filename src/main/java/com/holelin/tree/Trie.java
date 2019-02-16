package com.holelin.tree;

import java.util.TreeMap;

/**
 * ClassName: Trie
 * 字典树(前缀树)
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/16
 */

public class Trie {
	private Node root;
	private int size;

	public Trie() {
		root = new Node();
		size = 0;
	}

	/**
	 * 查询在Trie中是否有以单词prefix为前缀
	 *
	 * @param prefix 前缀
	 * @return 存在返回true;反之返回false;
	 */
	public boolean isPrefix(String prefix) {
		Node cur = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (cur.next.get(c) == null) {
				return false;
			}
			cur = cur.next.get(c);
		}
		return true;
	}


	/**
	 * 查询Trie中是否包含word这个单词
	 * (非递归写法)
	 *
	 * @param word 待查询的单词
	 * @return 存在返回true;反之返回false;
	 */
	public boolean contains(String word) {
		Node cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.next.get(c) == null) {
				return false;
			}
			cur = cur.next.get(c);
		}
		return cur.isWord;
	}


	/**
	 * 向Trie中添加新的单词
	 * (非递归写法)
	 *
	 * @param word 新的单词
	 */
	public void add(String word) {
		Node cur = root;
		// 对word进行拆分
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			// 判断cur的下一个节点的Map中是否存在c
			// 不存在c则创建新节点
			if (cur.next.get(c) == null) {
				cur.next.put(c, new Node());
			}
			cur = cur.next.get(c);
		}
		// 判断到最后,发现当前位置的isWord==false,则表示该word为新的单词,改变isWord的值,增加size
		// 若isWord==true,则表示该word已经存在,则不需要进行其他操作
		if (!cur.isWord) {
			cur.isWord = true;
			size++;
		}
	}

	/**
	 * 获取Trie中元素的个数
	 *
	 * @return Trie中元素的个数
	 */
	public int getSize() {
		return size;
	}

	/**
	 * 判断Trie是否为空
	 *
	 * @return 为空返回true;反之返回false
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	private class Node {
		/**
		 * 标识从根到当前节点的组成的字符串是否为单词
		 */
		public boolean isWord;
		/**
		 * 指向下一(多)个节点
		 */
		public TreeMap<Character, Node> next;

		public Node(boolean isWord) {
			this.isWord = isWord;
			next = new TreeMap<>();
		}

		public Node() {
			this(false);
		}
	}


}
