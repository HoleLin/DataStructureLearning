package com.holelin.sort;

/**
 * 排序类
 * ClassName: Sorts
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/1/14
 */
class Sorts {
    private Sorts() {
    }

    /**
     * 冒泡排序
     *
     * @param arr 待排数组
     */
    static void bubbleSort(int[] arr) {
        if (checkArray(arr)) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 选择排序
     *
     * @param arr 待排序的数组
     */
    static void selectionSort(int[] arr) {

    }

    /**
     * 插入排序
     *
     * @param arr
     */
    static void insertionSort(int[] arr) {

    }

    /**
     * 快速排序
     * @param arr
     */
    static void quickSort(int[] arr) {

    }

    /**
     * 归并排序
     * @param arr
     */
    static void mergeSort(int[] arr) {

    }

    /**
     * TimSort排序
     * @param arr
     */
    static void timSort(int[] arr) {

    }

    /**
     *
     * @param arr
     */
    static void heapSort(int[] arr) {

    }

    /**
     *
     * @param arr
     */
    static void treeSort(int[] arr) {

    }

    /**
     * 希尔排序
     * @param arr
     */
    static void shellSort(int[] arr) {

    }

    /**
     * 桶排序
     * @param arr
     */
    static void bucketSort(int[] arr) {

    }

    /**
     * 基数排序
     * @param arr
     */
    static void radixSort(int[] arr) {

    }

    /**
     * 基数排序
     * @param arr
     */
    static void countiongSort(int[] arr) {

    }

    /**
     * Cubesort是一种并行排序算法
     * @param arr
     */
    static void cubeSort(int[] arr){

    }


    /**
     * 数组长度校验
     *
     * @param arr 待校验的数组
     * @return 当数组为空或者数组长度小于2时, 不用排序, 直接返回
     */
    private static boolean checkArray(int[] arr) {
        // 当数组为空或者数组长度小于2时,不用排序
        return arr == null || arr.length < 2;
    }

    /**
     * 交换数据 -- 数组
     *
     * @param arr 数组
     * @param i   待交换的值
     * @param j   待交换的值
     */
    private static void swap(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
        // 使用异或运算实现交换操作
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


}
