package com.holelin.tree;

import java.util.TreeMap;

/**
 * ClassName: HashTable
 * 哈希表
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/19
 */

public class HashTable<K, V> {
	private final int[] capacity
			= {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
			49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
			12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};
	private TreeMap<K, V>[] hashtable;
	private int M;
	private int size;

	/**
	 * 平均每个地址承载的元素的上界
	 */
	private static final int upperTol = 10;
	/**
	 * 平均每个地址承载的元素的下界
	 */
	private static final int lowerTol = 2;
	/**
	 * 初始容量
	 */
	private int capacityIndex = 0;

	public HashTable() {
		this.M = capacity[capacityIndex];
		this.size = 0;
		hashtable = new TreeMap[M];
		for (int i = 0; i < hashtable.length; i++) {
			hashtable[i] = new TreeMap<>();
		}
	}

	/**
	 * 计算hash值
	 *
	 * @param key 传入的key
	 * @return 计算后key的hash值
	 */
	private int hash(K key) {
		//  & 0x7fffffff -- 消除负号
		return (key.hashCode() & 0x7fffffff) % M;
	}

	/**
	 * @return
	 */
	public int getSize() {
		return size;
	}

	public void add(K key, V value) {
		TreeMap<K, V> map = hashtable[hash(key)];
		if (map.containsKey(key)) {
			map.put(key, value);
		} else {
			map.put(key, value);
			size++;
		}
		if (size >= upperTol * M && capacityIndex + 1 < capacity.length) {
			capacityIndex++;
			resize(capacity[capacityIndex]);
		}
	}

	private void resize(int newM) {
		TreeMap<K, V>[] newHashTable = new TreeMap[newM];
		for (int i = 0; i < newM; i++) {
			newHashTable[i] = new TreeMap<>();
		}
		int oldM = M;
		this.M = newM;
		for (int i = 0; i < oldM; i++) {
			TreeMap<K, V> map = hashtable[i];
			for (K key : map.keySet()) {
				newHashTable[hash(key)].put(key, map.get(key));
			}
		}
		this.hashtable = newHashTable;
	}

	public V remove(K key) {
		TreeMap<K, V> map = hashtable[hash(key)];
		V ret = null;
		if (map.containsKey(key)) {
			ret = map.remove(key);
			size--;
		}
		if (size < lowerTol * M && capacityIndex - 1 >= 0) {
			capacityIndex--;
			resize(capacity[capacityIndex]);
		}
		return ret;
	}

	public void set(K key, V value) {
		TreeMap<K, V> map = hashtable[hash(key)];
		if (!map.containsKey(key)) {
			throw new IllegalArgumentException(key + "does't exist");
		}
		map.put(key, value);
	}

	public boolean contains(K key) {
		return hashtable[hash(key)].containsKey(key);
	}

	public V get(K key) {
		return hashtable[hash(key)].get(key);
	}


}
