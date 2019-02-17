package com.holelin.set;

import com.holelin.util.FileOperation;

import java.util.ArrayList;

/**
 * ClassName: SetTest
 * Set测试类
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/11
 */

public class SetTest {
	private static double testSet(Set<String> set, String filename) {

		long startTime = System.nanoTime();

		ArrayList<String> words = new ArrayList<>();
		if (FileOperation.readFile(filename, words)) {
			System.out.println("Total words: " + words.size());

			for (String word : words) {
				set.add(word);
			}
			System.out.println("Total different words: " + set.getSize());

		}

		long endTime = System.nanoTime();

		return (endTime - startTime) / 1000000000.0;
	}

	public static void main(String[] args) {
		String path = "src/res/Pride-and-prejudice.txt";

		System.out.println("Pride and prejudice ");

		BSTSet<String> bstSet = new BSTSet<>();
		System.out.println("BSTSet :" + testSet(bstSet, path));
		System.out.println();
		LinkedListSet<String> linkedListSet = new LinkedListSet<>();
		System.out.println("LinkedListSet :" + testSet(linkedListSet, path));
		System.out.println();
		AVLSet<String> avlSet = new AVLSet<>();
		System.out.println("AVLSet :" + testSet(avlSet, path));

	}
}
