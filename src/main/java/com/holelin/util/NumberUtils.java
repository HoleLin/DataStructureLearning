package com.holelin.util;

import java.util.Arrays;

/**
 * 对数器,生成随机数组
 * ClassName NumberUtils
 * @version 1.0
 * @author HoleLin
 * @date 2019/1/14
 */
public class NumberUtils {
    private NumberUtils(){

    }

    /**
     * 正确的排序
     * @param arr
     */
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }
    /**
     * 拷贝数组
     * @param arr 原始数组
     * @return 与原始数组内容相同的数组
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 打印数组内容
     * @param arr 原始数组
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    /**
     *
     * @Description: 比对方法 -- 判断两个数组是否相等
     * @param arr1 待比对的数组
     * @param arr2 待比对的数组
     * @return 判断结果
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        // 若其中一个数组为空，直接返回false
        boolean flag1=arr1 == null && arr2 != null;
        boolean flag2=arr1 != null && arr2 == null;
        if ((flag1) || (flag2)) {
            return false;
        }
        // 都为空即null也是相等,不需要数组判断直接返回true
        if (arr1 == null) {
            return true;
        }
        // 若两个数组的长度不一致,直接返回false
        if (arr1.length != arr2.length) {
            return false;
        }
        // 若两数组都不为空、数组长度一样，则进行数组内的数值判断
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                // 当数组中的有值不相等，直接返回false
                return false;
            }
        }
        // 当满足两数组都不为空、数组长度一样、数值内值也一样对应相等，返回true
        return true;
    }
    /**
     *
     * @Description: 创建一个随机包含随机数值且长度随机的数组
     * @param maxSize 数组长度最大值
     * @param maxValue 数组中数值的最大值
     * @return 一个随机包含随机数值且长度随机的数组
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // 该处使用(maxSize + 1) * Math.random()是因为Math.random()方法取值范围是[0,1) 进行加1操作后 取值范围变为[0,1]
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // 数组中的值采用一个随机数减去一个随机数，这样可以取到负值
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

}
