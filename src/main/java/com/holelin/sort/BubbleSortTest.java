package com.holelin.sort;

import com.holelin.TestConfig;
import com.holelin.util.NumberUtils;

import java.util.Arrays;

/**
 * 冒泡排序测试类
 *
 * @author HoleLin
 */
public class BubbleSortTest {
    public static void main(String[] args) {
        boolean succeed = true;
        for (int i = 0; i < TestConfig.testTime; i++) {
            // 获取随机数组
            int[] arr = NumberUtils.generateRandomArray(TestConfig.maxSize, TestConfig.maxValue);
            // 拷贝数组数组
            int[] copyArr = NumberUtils.copyArray(arr);
            // 进行排序
            Sorts.bubbleSort(arr);
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
        System.out.println(succeed?"Nice~~~":"Fucking fucked!");

    }
}
