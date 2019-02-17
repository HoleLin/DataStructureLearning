package com.holelin.tree;

import com.holelin.map.BSTMap;
import com.holelin.util.FileOperation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * ClassName: AVLTreeTest
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/17
 */

public class AVLTreeTest {
	public static void main(String[] args) {
		String path = "src/res/Pride-and-prejudice.txt";
		System.out.println("Pride and prejudice ");
		ArrayList<String> words = new ArrayList<>();
		if (FileOperation.readFile(path, words)) {
			// 对words排序 使BST退化为链表
			Collections.sort(words);
			long startTime = System.nanoTime();
			BSTMap<String, Integer> bstMap = new BSTMap<>();
			for (String word :
					words) {
				if (bstMap.contains(word)) {
					bstMap.set(word, bstMap.get(word) + 1);
				} else {
					bstMap.add(word, 1);
				}
			}
			for (String word :
					words) {
				bstMap.contains(word);
			}

			long endTime = System.nanoTime();
			double time = (endTime - startTime) / 1000000000.0;
			System.out.println("Total different words :" + bstMap.getSize());
			System.out.println("BSTMap: " + time + "s");
			// -----

			startTime = System.nanoTime();
			AVLTree<String, Integer> avlTree = new AVLTree<>();
			for (String word : words
			) {
				if (avlTree.contains(word)) {
					avlTree.set(word, avlTree.get(word) + 1);
				} else {
					avlTree.add(word, 1);
				}
			}
			for (String word :
					words) {
				avlTree.contains(word);
			}
			for (String word :
					words) {
				avlTree.remove(word);
				if (!avlTree.isBalanced() || !avlTree.isBalanced()) {
					throw new IllegalArgumentException("Error");
				}
			}
			endTime = System.nanoTime();
			time = (endTime - startTime) / 1000000000.0;
			System.out.println("Total different words :" + avlTree.getSize());
			System.out.println("AVLMap: " + time + "s");

		}
	}
}
