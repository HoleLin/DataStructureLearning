package com.holelin.tree;

/**
 * ClassName: SegmentTreeTest
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/14
 */

public class SegmentTreeTest {
	public static void main(String[] args) {
		Integer[] nums = {-2, 0, 3, -5, 2, -1};
		SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, new Merger<Integer>() {
			@Override
			public Integer merge(Integer a, Integer b) {
				return a + b;
			}
		});
		System.out.println(segmentTree);
		System.out.println(segmentTree.query(0, 2));
		System.out.println(segmentTree.query(2, 5));
		System.out.println(segmentTree.query(0, 5));
	}

}
