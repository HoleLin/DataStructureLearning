package com.holelin.set;

import com.holelin.tree.BST;

import java.util.ArrayList;

/**
 * ClassName: SetTest
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/11
 */

public class SetTest {
	public static void main(String[] args) {
		System.out.println("Txt one ");
		ArrayList<String> words1=new ArrayList<>();
		FileOperation.readFile("txtOne.txt",words1);
		System.out.println("Total words: "+words1.size());

		BSTSet<String> set1=new BSTSet<>();
		for (String word: words1
		     ) {
			set1.add(word);
		}
		System.out.println("Total different words: "+set1.getSize());



		System.out.println("Txt one ");
		ArrayList<String> words2=new ArrayList<>();
		FileOperation.readFile("txtOne.txt",words2);
		System.out.println("Total words: "+words2.size());

		LinkedListSet<String> set2=new LinkedListSet<>();
		for (String word: words1
		) {
			set2.add(word);
		}
		System.out.println("Total different words: "+set2.getSize());
	}
}
