package com.holelin.bit;

import com.holelin.array.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @program: AlgorithmLearning
 * @description: 位运算
 * @author: HoleLin
 * @create: 2020-03-08 14:59
 **/
public class Bit {

    /**
     * 判断数是奇数还是偶数
     *
     * @param number
     * @return true--奇数;false--偶数
     */
    public static boolean odevity(int number) {
        return (number & 1) == 1;
    }

    /**
     * 使用异或运算实现交换操作
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 判断整数x的第y位的二进制位是0还是1
     *
     * @param number 一个整数number
     * @param palce  判断number的二进制的第几位
     */
    public static void judjeBitNumber(int number, int palce) {
        // 1. 做与运算。例如：判断x的第五位二进制是1还是0，可以与1<<4做与运算，然后将结果>>4位，判断最终结果是1还是0。
        // 如果最终结果是0，则x的第五位为0，否则第五位的二进制位1。
        System.out.printf("方案一: ");
        System.out.println(((number & (1 << palce)) >> palce) == 1 ? 1 : 0);
        // 2. 做与运算。例如：判断x的第五位二进制是1还是0，可以将x>>4位，与1做与运算，判断最终结果是1还是0。
        // 如果最终结果是0，则x的第五位为0，否则第五位的二进制位1。
        System.out.printf("方案二: ");
        System.out.println(((number >>> palce) & 1) == 1 ? 1 : 0);
    }

    /**
     * 求整型数绝对值
     *
     * @param num
     * @return
     */
    public static int absoluteVSalue(int num) {
        return (num ^ (num >> 31)) - (num >> 31);
    }

    /**
     * 1-1000这1000个数放在10001个元素的数组中，只有唯一的一个元素值重复，其他均只出现一次。
     * 每个数组元素只能访问一次，设计一个算法，将他找出来；不用辅助存储空间，能否设计一个算法实现？
     * <p>
     * 思路:
     * 利用位运算异或的性质，A^A=0;A^0=A.
     * 将1001个数一起做异或运算，会把相同的那组数去除。但是要找的数为相同的数，所以在和1-1000的每个数做异或，最后就能找到那个数。
     */
    public static void getPairingNumber() {
        // 构造数组
        int N = 1001;
        int[] arr = new int[N];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = i + 1;
        }
        arr[arr.length - 1] = new Random().nextInt(N + 1) + 1;
        int index = new Random().nextInt(N);
        swap(arr, index, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        // 进行异或 arr^(arr数组中剔除重复的那个值)
        // (1,2,3,4,1)^(1,2,3,4)
        int number = 0;
        for (int i = 1; i <= N - 1; i++) {
            number = (number ^ i);
        }
        for (int i = 0; i < N; i++) {
            number = (number ^ arr[i]);
        }
        System.out.println(number);
        // 方案二 利用辅助空间 Set扫描
        Set<Integer> helperSet = new HashSet<>(N);
        for (int i = 0; i < N; i++) {
            if (!helperSet.contains(arr[i])) {
                helperSet.add(arr[i]);
            } else {
                System.out.println(arr[i]);
            }
        }
        // 数组下标计数
        int[] helperArr = new int[N];
        for (int i = 0; i < N; i++) {
            helperArr[arr[i]]++;
        }
        for (int i = 0; i < N; i++) {
            if (helperArr[i] > 1) {
                System.out.println(i);
            }
        }
    }

    /**
     * 二进制中1的个数
     * 请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。
     * <p>
     * 例：9的二进制表示为1001，有2位是1.
     */
    public static void count1Frombit() {
        int number = new Random().nextInt(10);
        System.out.println("源数据二进制表示: " + Integer.toString(number, 2));
        int count = 0;
        for (int i = 0; i < 32; i++) {
            //   1001
            // & 0001
            // --------
            //   0001
            if ((number & (1 << i)) == (1 << i)) {
                count++;
            }
        }
        System.out.println(count);
        count = 0;
        for (int i = 0; i < 32; i++) {
            //   1001
            // & 0001
            // --------
            //   0001
            // 1001 >>> 1 ==> 0100
            //   0100            0001
            // & 0001       &    0001
            // --------  ==> ---------
            //   0000            0001
            if (((number >>> i) & 1) == 1) {
                count++;
            }
        }
        System.out.println(count);
        count = 0;
        while (number != 0) {
            //  1001
            //- 0001
            //------
            //  1000
            // 1001 & 1000 ==> 1000
            number = ((number - 1) & number);
            count++;
        }
        System.out.println(count);
    }

    /**
     * 用一条语句判断一个整数是不是2的整数次方。
     * ==> 二进制表示只有一个1
     */
    public static void is2Power(int number) {
        //  0010
        //- 0001
        //------
        //  0001
        // 0010 & 0001 ==> 0000
        if (((number - 1) & number) == 0) {
            System.out.println(Boolean.TRUE);
        } else {
            System.out.println(Boolean.FALSE);
        }
    }

    /**
     * 将一个整数的二进制位上的1与0做交换。
     * 例: 9 ==> 1001
     * 结果: 0110
     *
     * @param num
     */
    public static int changeParityBit(int num) {
        // 0xaaaaaaaa <==> 0101 0101 0101 0101 ....
        int evenNumber = num & 0xaaaaaaaa;
        // 0x55555555 <==> 1010 1010 1010 1010 ....
        int oddNumber = num & 0x55555555;
        return ((evenNumber >> 1) ^ (oddNumber << 1));
    }

    public static String doubleToBit(double num) {
        StringBuilder sb = new StringBuilder("0.");
        while (num > 0) {
            double temp = num * 2;
            if (temp >= 1) {
                sb.append("1");
                num = temp - 1;
            } else {
                sb.append("0");
                num = temp;
            }
            if (sb.length() > 34) {
                return "ERROR";
            }
        }
        return sb.toString();
    }

    public static String intToBit(int num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            if (num % 2 != 0) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            num /= 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(odevity(1));
        System.out.println(odevity(22));
        int[] arr = new int[]{1, 0};
        swap(arr, 0, 1);
        System.out.println(Arrays.toString(arr));
        judjeBitNumber(1, 0);
        judjeBitNumber(11, 0);
        System.out.println(absoluteVSalue(-11));
        getPairingNumber();
        count1Frombit();
        is2Power(1023);
        System.out.println(changeParityBit(9));
        System.out.println(doubleToBit(0.625));
        System.out.println(intToBit(2));
    }
}
