package com.holelin.map;

public interface Map<K, V> {
	/**
	 * 添加元素
	 *
	 * @param key   键
	 * @param value 值
	 */
	void add(K key, V value);

	/**
	 * 根据key移除元素
	 *
	 * @param key 键
	 * @return 删除的元素
	 */
	V remove(K key);

	/**
	 * 判断Map中是否包含key
	 *
	 * @param key 键
	 * @return 包含返回true, 反之返回false
	 */
	boolean contains(K key);

	/**
	 * 根据key获取value
	 *
	 * @param key 键
	 * @return key对应value
	 */
	V get(K key);

	/**
	 * 修改key对应的value值
	 *
	 * @param key   键
	 * @param value 值
	 */
	void set(K key, V value);

	/**
	 * 获取Map中元素的个数
	 *
	 * @return
	 */
	int getSize();

	/**
	 * 判断Map是否为空
	 *
	 * @return 为空返回true, 反之返回false;
	 */
	boolean isEmpty();

}
