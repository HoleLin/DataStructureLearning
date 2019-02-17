package com.holelin.map;

import com.holelin.util.FileOperation;

import java.util.ArrayList;
import java.util.Random;

/**
 * ClassName: MapTest
 * Map测试类
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/17
 */

public class MapTest {
	private static double testMap(Map<String, Integer> map, String filename) {

		long startTime = System.nanoTime();
		ArrayList<String> words = new ArrayList<>();
		if (FileOperation.readFile(filename, words)) {
			System.out.println("Total words: " + words.size());

			for (String word : words) {
				if (map.contains(word)) {
					map.set(word, map.get(word) + 1);
				} else {
					map.add(word, 1);
				}
			}

			System.out.println("Total different words: " + map.getSize());

		}

		long endTime = System.nanoTime();

		return (endTime - startTime) / 1000000000.0;
	}

	public static void main(String[] args) {
		String path = "src/res/Pride-and-prejudice.txt";
		BSTMap<String, Integer> bstMap = new BSTMap<>();
		double time1 = testMap(bstMap, path);
		System.out.println("BST Map: " + time1 + " s");

		System.out.println();

		LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
		double time2 = testMap(linkedListMap, path);
		System.out.println("Linked List Map: " + time2 + " s");

		System.out.println();

		AVLMap<String, Integer> avlMap = new AVLMap<>();
		double time3 = testMap(avlMap, path);
		System.out.println("AVL Map: " + time3 + " s");

	}
}
