package com.holelin.set;

public interface Set<E> {
	/**
	 * 添加元素e
	 *
	 * @param e 元素e
	 */
	void add(E e);

	/**
	 * 删除元素e
	 *
	 * @param e 元素e
	 */
	void remove(E e);

	/**
	 * 查询集合中是否包含元素e
	 *
	 * @param e 元素e
	 * @return 包含则返回true, 反之返回false
	 */
	boolean contains(E e);

	/**
	 * 返回集合元素的个数
	 *
	 * @return 集合元素的个数
	 */
	int getSize();

	/**
	 * 判断集合是否为空
	 *
	 * @return 为空返回true, 反之返回false;
	 */
	boolean isEmpty();
}
