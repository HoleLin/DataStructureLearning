package com.holelin.tree;

import com.holelin.map.BSTMap;
import com.holelin.util.FileOperation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * ClassName: RedBlackTreeTest
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/19
 */

public class RedBlackTreeTest {
	public static void main(String[] args) {
//		testTree();
		String path = "src/res/Pride-and-prejudice.txt";
		System.out.println("Pride and prejudice ");
		ArrayList<String> words = new ArrayList<>();
		if (FileOperation.readFile(path, words)) {
			// 对words排序 使BST退化为链表
			// Collections.sort(words);
			long startTime = System.nanoTime();
			RedBlackTree<String, Integer> redBlackTree = new RedBlackTree<>();
			for (String word : words) {
				if (redBlackTree.contains(word)) {
					redBlackTree.set(word, redBlackTree.get(word) + 1);
				} else {
					redBlackTree.add(word, 1);
				}
			}
			for (String word : words) {
				redBlackTree.contains(word);
			}

			long endTime = System.nanoTime();
			double time = (endTime - startTime) / 1000000000.0;
			System.out.println("Total different words :" + redBlackTree.getSize());
			System.out.println("RedBlackTree: " + time + "s");


			startTime = System.nanoTime();
			AVLTree<String, Integer> avlTree = new AVLTree<>();
			for (String word : words) {
				if (avlTree.contains(word)) {
					avlTree.set(word, avlTree.get(word) + 1);
				} else {
					avlTree.add(word, 1);
				}
			}
			for (String word : words) {
				avlTree.contains(word);
			}
			endTime = System.nanoTime();
			time = (endTime - startTime) / 1000000000.0;
			System.out.println("AVLMap: " + time + "s");

			startTime = System.nanoTime();
			HashTable<String, Integer> hashTable = new HashTable<>();

			for (String word : words) {
				if (hashTable.contains(word)) {
					hashTable.set(word, hashTable.get(word) + 1);
				} else {
					hashTable.add(word, 1);
				}
			}
			for (String word : words) {
				hashTable.contains(word);
			}
			endTime = System.nanoTime();
			time = (endTime - startTime) / 1000000000.0;
			System.out.println("HashTable: " + time + "s");


		}
	}

	public static void testTree() {
		int n = 20000000;
		Random random = new Random();
		ArrayList<Integer> testData = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			testData.add(random.nextInt(Integer.MAX_VALUE));
//			testData.add(n);
		}
		long startTime = System.nanoTime();

		BSTMap<Integer, Integer> bstMap = new BSTMap<>();
		for (Integer x : testData
		) {
			bstMap.add(x, null);
		}
		long endTime = System.nanoTime();
		double time = (endTime - startTime) / 1000000000.0;
		System.out.println("bstMap: " + time + "s");
		startTime = System.nanoTime();

		AVLTree<Integer, Integer> avlTree = new AVLTree<>();
		for (Integer x : testData
		) {
			avlTree.add(x, null);
		}
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000000000.0;
		System.out.println("avlTree: " + time + "s");
		startTime = System.nanoTime();

		RedBlackTree<Integer, Integer> redBlackTree = new RedBlackTree<>();
		for (Integer x : testData
		) {
			redBlackTree.add(x, null);
		}
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000000000.0;
		System.out.println("redBlackTree: " + time + "s");

	}
}
