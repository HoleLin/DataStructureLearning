package com.holelin.tree;

/**
 * ClassName: BSTTest
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/4
 */

public class BSTTest {
	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		int[] nums = {5, 3, 6, 8, 4, 2};
		for (int num : nums) {
			bst.add(num);
		}
		bst.preOrder();
		System.out.println();
		bst.preOrderNR();
		System.out.println();
		System.out.println(bst);
		bst.inOrder();
		System.out.println();
		bst.postOrder();
		System.out.println();
		bst.levelOrder();
	}
}
