package com.holelin.array;

/**
 * ClassName: Array
 * 实现动态数组
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/1/19
 */

public class Array<E> {
	/**
	 * 数组
	 */
	private E[] data;
	/**
	 * 数组中元素是个数
	 */
	private int size;

	/**
	 * 将数组转换为Array
	 *
	 * @param arr 待转换的数组
	 */
	public Array(E[] arr) {
		data = (E[]) new Object[arr.length];
		for (int i = 0; i < arr.length; i++) {
			data[i] = arr[i];
		}
		size = arr.length;
	}

	/**
	 * 根据用户指定容量来创建数组初始容量
	 *
	 * @param capacity 用户指定容量
	 */
	public Array(int capacity) {
		data = (E[]) new Object[capacity];
		size = 0;
	}

	/**
	 * 默认设置数组长度为20
	 */
	public Array() {
		this(20);
	}

	/**
	 * 获得数组中元素的个数
	 *
	 * @return 数组中元素的个数
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * 获得数组的容量
	 *
	 * @return 数组的容量
	 */
	public int getCapacity() {
		return data.length;
	}

	/**
	 * 判断数组是否为空
	 *
	 * @return 数组是否为空, 非空返回false, 空返回true
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 在末尾添加元素
	 * 时间复杂度 : O(1)
	 *
	 * @param element 待添加的元素
	 */
	public void addLast(E element) {
		add(size, element);
	}

	/**
	 * 在开头插入元素
	 * 时间复杂度 : O(n)
	 *
	 * @param element 待添加的元素
	 */
	public void addFirst(E element) {
		add(0, element);
	}

	/**
	 * 根据用户指定位置插入元素
	 * 时间复杂度 : O(n)
	 *
	 * @param index   元素插入的位置
	 * @param element 带插入的元素
	 */
	public void add(int index, E element) {
		// 当数组满了则不能添加元素
		if (size == data.length) {
			resize(2 * data.length);
//            throw new IllegalArgumentException("Add failed . Array is full .");
		}
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Add failed . Require index >=0 and index < size.");
		}
		// 将index位置后的数向后移动一个位置 空出index位置
//        for (int i = size - 1; i >= index; i--) {
//            data[i + 1] = data[i];
//        }
		if (size - index >= 0) {
			System.arraycopy(data, index, data, index + 1, size - index);
		}
		// 将待插入元素插入index位置上
		data[index] = element;
		// 数组元素个数加一
		size++;
	}

	private void resize(int newCapacity) {
		// 创建新的大容量数组
		E[] newData = (E[]) new Object[newCapacity];
		// 将旧数组中元素全部拷贝到新数组中
		System.arraycopy(data, 0, newData, 0, size);
		// 将新数组赋给data
		data = newData;
	}

	/**
	 * 获取index索引位置的元素
	 * 时间复杂度 : O(1)
	 *
	 * @param index 元素的位置
	 * @return index索引位置的元素
	 */
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Get failed. Index is illegal");
		}
		return data[index];
	}

	/**
	 * 获取数组中第一个元素的值
	 *
	 * @return 数组中第一个元素的值
	 */
	public E getFirst() {
		return get(0);
	}

	/**
	 * 获取数组中最后一个元素的值
	 *
	 * @return 数组中最后一个元素的值
	 */
	public E getLast() {
		return get(size - 1);
	}

	/**
	 * 将index位置上的元素修改为element
	 * 时间复杂度 : O(1)
	 *
	 * @param index   要修改元素的位置
	 * @param element 修改后元素的值
	 */
	public void set(int index, E element) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Get failed. Index is illegal");
		}
		data[index] = element;
	}

	/**
	 * 判断数组中是否包含element元素
	 * 时间复杂度 : O(n)
	 *
	 * @param element 待判断的元素
	 * @return 当数组中包含element返回true
	 */
	public boolean contains(E element) {
		for (int i = 0; i < size; i++) {
			if (data[i] == element) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 查询数组中是否包含element
	 * 时间复杂度 : O(n)
	 *
	 * @param element 待查找的元素
	 * @return 包含返回element所在的索引, 不包含则返回-1
	 */
	public int find(E element) {
		for (int i = 0; i < size; i++) {
			if (data[i] == element) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 删除index位置上的元素,返回删除的元素
	 * 时间复杂度 : O(n)
	 *
	 * @param index
	 */
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Remove failed. index >=0 and index < size");
		}
		E element = data[index];
		// 将index位置后的元素向前移动一位

		for (int i = index + 1; i < size; i++) {
			data[i - 1] = data[i];
		}
        /*
         Otherwise, if any of the following is true, an IndexOutOfBoundsException is thrown and the destination is not modified:
            The srcPos argument is negative.    srcPos参数为负数。
            The destPos argument is negative.   destPos参数是负数。
            The length argument is negative.   长度参数是负数。
            srcPos+length is greater than src.length, the length of the source array.   srcPos + length大于src.length，即源数组的长度。
            destPos+length is greater than dest.length, the length of the destination array.   destPos + length大于dest.length，即目标数组的长度。
         */
        /*
        使用System.arraycopy()方法出现异常
        Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException
                at com.holelin.array.Array.remove(Array.java:235)
                at com.holelin.array.Array.removeFirst(Array.java:253)
                at com.holelin.queue.ArrayQueue.dequeue(ArrayQueue.java:31)
                at com.holelin.queue.QueueEfficiencyTest.testQueue(QueueEfficiencyTest.java:34)
                at com.holelin.queue.QueueEfficiencyTest.main(QueueEfficiencyTest.java:20)
         */
//        if (size - index + 1 >= 0) {
//            //public static void (Object src,
//                                  int srcPos,
//                                  Object dest,
//                                  int destPos,
//                                  int length)
//            //src:源数组；	srcPos:源数组要复制的起始位置；
//            //dest:目的数组；	destPos:目的数组放置的起始位置；	length:复制的长度。
//            //注意：src and dest都必须是同类型或者可以进行转换类型的数组．
//            System.arraycopy(data, index + 1, data, index, size - index + 1);
//        }
		size--;
		data[size] = null;
		// 当数组中元素个数等于容量的4分之一时,进行缩容
		if (size == data.length / 4 && data.length / 2 != 0) {
			resize(data.length / 2);
		}
		return element;
	}

	/**
	 * 删除数组中第一个元素,并返回元素的值
	 * 时间复杂度 : O(n)
	 *
	 * @return 返回删除元素的值
	 */
	public E removeFirst() {
		return remove(0);
	}

	/**
	 * 删除数组最后一个元素,并返回元素的值
	 * 时间复杂度 : O(1)
	 *
	 * @return 返回删除元素的值
	 */
	public E removeLast() {
		return remove(size - 1);
	}

	/**
	 * 删除指定的元素
	 *
	 * @param element 指定的元素
	 */
	public void removeElement(E element) {
		int index = find(element);
		if (index != -1) {
			remove(index);
		}

	}

	/**
	 * 交换数组中i所在元素和j所在元素的值
	 *
	 * @param i i所在的元素
	 * @param j j所在的元素
	 */
	public void swap(int i, int j) {
		if (i < 0 || i >= size || j < 0 || j >= size) {
			throw new IllegalArgumentException("Index is Illegal.");
		}
		E t = data[i];
		data[i] = data[j];
		data[j] = t;
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
		res.append('[');
		for (int i = 0; i < size; i++) {
			res.append(data[i]);
			if (i != size - 1) {
				res.append(",");
			}
		}
		res.append(']');
		return res.toString();
	}
}
