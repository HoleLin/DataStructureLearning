package com.holelin.heap;

import java.util.Random;

/**
 * ClassName: MaxHeapTest
 * 基于数组实现的大顶堆的测试类
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/13
 */

public class MaxHeapTest {
	public static void main(String[] args) {
		int n = 1000000;
		MaxHeap<Integer> maxHeap = new MaxHeap<>();
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			maxHeap.add(random.nextInt(Integer.MAX_VALUE));
		}
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = maxHeap.extractMax();
		}
		for (int i = 1; i < n; i++) {
			if (arr[i - 1] < arr[i]) {
				throw new IllegalArgumentException("Error");
			}
		}
		System.out.println("Test MaxHeap completed.");
		Integer[] testData = new Integer[n];
		for (int i = 0; i < n; i++) {
			testData[i] = random.nextInt(Integer.MAX_VALUE);
		}
		double time1 = testHeap(testData, false);

		System.out.println("Without isHeapify " + time1 + " s");
		double time2 = testHeap(testData, true);
		System.out.println("isHeapify " + time2 + " s");

	}

	private static double testHeap(Integer[] testData, boolean isHeapify) {
		long startTime = System.nanoTime();
		MaxHeap<Integer> maxHeap;
		if (isHeapify) {
			maxHeap = new MaxHeap<>(testData);
		} else {
			maxHeap = new MaxHeap<>();
			for (int num : testData
			) {
				maxHeap.add(num);
			}

		}
		int[] arr = new int[testData.length];
		for (int i = 0; i < testData.length; i++) {
			arr[i] = maxHeap.extractMax();
		}
		for (int i = 1; i < testData.length; i++) {
			if (arr[i - 1] < arr[i]) {
				throw new IllegalArgumentException("Error");
			}
		}
		System.out.println("Test MaxHeap completed.");

		long endTime = System.nanoTime();
		return (endTime - startTime) / 100000000.0;
	}
}
