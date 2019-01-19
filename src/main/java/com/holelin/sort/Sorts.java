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
     * -- 擂台法
     *
     * @param arr 待排序的数组
     */
    static void selectionSort(int[] arr) {
        if (checkArray(arr)) {
            return;
        }
        int k;
        int j;
        for (int i = 0; i < arr.length; i++) {
            // 设置擂主 k
            k = i;
            for (j = i + 1; j < arr.length; j++) {
                if (arr[k] > arr[j]) {
                    k = j;
                }
            }
            // 当擂主改变进行交换 减少交换次数
            if (k != i) {
                swap(arr, k, i);
            }
        }
    }

    /**
     * 插入排序
     *
     * @param arr 待排数组
     */
    static void insertionSort(int[] arr) {
        if (checkArray(arr)) {
            return;
        }
        // 插入排序
        // i作为指针作用遍历整个数组
        for (int i = 1; i < arr.length; i++) {
            // 先比较arr[j] 与 arr[j+1]
            // 当满足arr[j] > arr[j + 1] 说明顺序不对，则进行交换 j向前移动一位 继续判断是否满足arr[j] > arr[j + 1]
            // 满足就进行交换 直至j<0或者不满足arr[j] > arr[j + 1]
            // 当不满足arr[j] > arr[j + 1] 说明顺序是对的，则直接判断下一个位置
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
            // 或者写成这样
//            for (int j = i; j > 0 && arr[j-1] > arr[j]; j--) {
//                swap(arr, j, j - 1);
//            }

        }
    }

    /**
     * 改进后的插入排序
     * -- 减少交换次数
     *
     * @param arr 待排数组
     */
    static void insertionSort2(int[] arr) {
        if (checkArray(arr)) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            // 寻找元素arr[i]合适的插入位置
            int e = arr[i];
            // j保存元素e应该插入的位置
            int j;
            for (j = i; j > 0 && arr[j - 1] > e; j--) {
                // 前一位数向后移动一位
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

    /**
     * 随机快速排序
     *
     * @param arr 待排数组
     */
    static void quickSort(int[] arr) {
        if (checkArray(arr)) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * @param arr 待排数组
     * @param l   待排序左边界(小于区域)
     * @param r   待排序右边界(大于区域)
     * @Description: 随机快速排序
     */
    private static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            // 进行随机交换
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            //
            int[] p = partition(arr, l, r);
            // 对左边区域进行快排
            quickSort(arr, l, p[0] - 1);
            // 对右边区域进行快排
            quickSort(arr, p[1] + 1, r);
        }
    }

    /**
     * @param arr 待分区的数组
     * @param l   左边界
     * @param r   右边界
     * @return 包含相等区域边界值的数组
     * @description: 将数组分为三个区域(> x, = x, < x)
     */
    private static int[] partition(int[] arr, int l, int r) {
        // 记录小于区域的边界
        int less = l - 1;
        // 记录大于区域的边界
        int more = r;
        // L作为游标向有移动,当L>=more时说明不需要进行分区了
        while (l < more) {
            if (arr[l] < arr[r]) {
                // 将最后一个数即arr[R]作为参照数
                // 当arr[L]<arr[R],时说明arr[L]属于小于区域,将小于区域边界的下一个值arr[++less]的值与arr[L]的值进行交换,
                // 并将小于区域向右移动一格(小于区域进行扩大),因为arr[R]已经进行了区域划分,所有游标也向右移动一格(L++).
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                // 当arr[L]>arr[R]时,说明arr[L]属于大于区域,将arr[-more]的值与arr[L]的值进行交换
                // 并将大于区域向左移动一格(大于区域进行扩大),因为交换的arr[L]并没有进行区域划分,所有游标L不动,等待下次进行区域划分
                swap(arr, --more, l);
            } else {
                // 相等区域
                // 进行移动游标,判断下一个数
                l++;
            }
        }
        // 上述操作中没有将参照数进行划分
        // 所以最后将参数和大于区域的边界进行交换
        swap(arr, more, r);
        // 最后返回包含相等区域边界的数组
        return new int[]{less + 1, more};
    }

    /**
     * 归并排序
     *
     * @param arr 待排数组
     */
    static void mergeSort(int[] arr) {

    }

    /**
     * TimSort排序
     *
     * @param arr 待排数组
     */
    static void timSort(int[] arr) {

    }

    /**
     * @param arr 待排数组
     */
    static void heapSort(int[] arr) {

    }

    /**
     * @param arr
     */
    static void treeSort(int[] arr) {

    }

    /**
     * 希尔排序
     *
     * @param arr 待排数组
     */
    static void shellSort(int[] arr) {

    }

    /**
     * 桶排序
     *
     * @param arr 待排数组
     */
    static void bucketSort(int[] arr) {

    }

    /**
     * 基数排序
     *
     * @param arr 待排数组
     */
    static void radixSort(int[] arr) {

    }

    /**
     * 基数排序
     *
     * @param arr 待排数组
     */
    static void countiongSort(int[] arr) {

    }

    /**
     * Cubesort是一种并行排序算法
     *
     * @param arr 待排数组
     */
    static void cubeSort(int[] arr) {

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
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        // 使用异或运算实现交换操作
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
    }


}
