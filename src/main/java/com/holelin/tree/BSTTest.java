package com.holelin.tree;

import java.util.ArrayList;
import java.util.Random;

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
        System.out.println(bst);

        System.out.println("递归前序遍历");
        bst.preOrder();
        System.out.println();

        System.out.println("非递归前序遍历");
        bst.preOrderNR();
        System.out.println();

        System.out.println("Morris前序遍历");
        bst.morrisPreorder();
        System.out.println();

        System.out.println("递归中序遍历");
        bst.inOrder();
        System.out.println();

        System.out.println("非递归中序遍历");
        bst.inOrderNR();
        System.out.println();

        System.out.println("Morris中序遍历");
        bst.morrisInorder();
        System.out.println();

        System.out.println("递归后序遍历");
        bst.postOrder();
        System.out.println();

        System.out.println("非递归后序遍历");
        bst.postOrderNR();
        System.out.println();
        System.out.println("非递归后序遍历2");
        bst.postOrderNR2();
        System.out.println();

        System.out.println();

        System.out.println("层序遍历");
        bst.levelOrder();
        System.out.println();

        System.out.println("==========遍历结束============");
        BST<Integer> bst1 = new BST<>();
        int n = 10000;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            bst1.add(random.nextInt(10000));
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!bst1.isEmpty()) {
            list.add(bst1.removeMin());
        }
        System.out.println();
        System.out.println(list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i)) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("removeMin is completed");
        for (int i = 0; i < n; i++) {
            bst1.add(random.nextInt(10000));
        }
        ArrayList<Integer> list2 = new ArrayList<>();
        while (!bst1.isEmpty()) {
            list2.add(bst1.removeMax());
        }
        System.out.println();
        System.out.println(list2);
        for (int i = 1; i < list2.size(); i++) {
            if (list2.get(i - 1) < list2.get(i)) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("removeMax is completed");

    }
}
