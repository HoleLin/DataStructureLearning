package com.holelin.sort;

import com.holelin.util.NumberUtils;
import com.holelin.util.TestConfig;

import java.util.Arrays;

/**
 * ClassName: BucketSortTest
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/23
 */

public class BucketSortTest {
	public static void main(String[] args) {

		long startTime = System.nanoTime();
		boolean succeed = true;
		for (int i = 0; i < TestConfig.TEST_TIME; i++) {
			// 获取随机数组
			int[] arr = NumberUtils.generateRandomArrayWithOutNegative(TestConfig.SMALL_SIZE, TestConfig.MAX_VALUE);
			// 拷贝数组数组
			int[] copyArr = NumberUtils.copyArray(arr);
			// 进行排序
            arr = Sorts.countiongSort(arr);

			// 对数器
			NumberUtils.comparator(copyArr);
			// 验证两个经过排序后的数组是否完全一样
			if (!NumberUtils.isEqual(arr, copyArr)) {
				// 不成功打印两个数组,方便查看错误
				succeed = false;
				NumberUtils.printArray(arr);
				NumberUtils.printArray(copyArr);
				break;
			}
		}
		long endTime = System.nanoTime();
		System.out.println(succeed ? "Nice~~~" + (endTime - startTime) : "Fucking fucked!");

	}
}
