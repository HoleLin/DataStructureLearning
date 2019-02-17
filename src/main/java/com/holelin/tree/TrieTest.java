package com.holelin.tree;

import com.holelin.linearlist.Array;
import com.holelin.set.BSTSet;
import com.holelin.util.FileOperation;

import java.util.ArrayList;

/**
 * ClassName: TrieTest
 * Trie测试类
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/16
 */

public class TrieTest {
	public static void main(String[] args) {
		String path = "src/res/Pride-and-prejudice.txt";

		System.out.println("Pride-and-prejudice");
		ArrayList<String> words = new ArrayList<>();
		if (FileOperation.readFile(path, words)) {
			long startTime = System.nanoTime();
			BSTSet<String> set = new BSTSet<>();
			for (String word :
					words) {
				set.add(word);
			}
			for (String word :
					words) {
				set.contains(word);
			}

			long endTime = System.nanoTime();
			double time = (endTime - startTime) / 1000000000.0;
			System.out.println("Total different words :" + set.getSize());
			System.out.println("BSTSet: " + time + "s");
			// -----

			startTime = System.nanoTime();
			Trie trie = new Trie();
			for (String word :
					words) {
				trie.add(word);
			}
			for (String word :
					words) {
				trie.contains(word);
			}

			endTime = System.nanoTime();
			time = (endTime - startTime) / 1000000000.0;
			System.out.println("Total different words :" + trie.getSize());
			System.out.println("Trie: " + time+ "s");

		}


	}
}
