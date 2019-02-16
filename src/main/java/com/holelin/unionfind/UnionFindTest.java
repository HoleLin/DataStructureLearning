package com.holelin.unionfind;

import java.util.Random;

/**
 * ClassName: UnionFindTest
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/16
 */

public class UnionFindTest {
	private static double testUF(UnionFind uf, int m) {
		int size = uf.getSize();
		Random random = new Random();
		long startTime = System.nanoTime();

		for (int i = 0; i < m; i++) {
			int a = random.nextInt(size);
			int b = random.nextInt(size);
			uf.unionElements(a, b);
		}
		for (int i = 0; i < m; i++) {
			int a = random.nextInt(size);
			int b = random.nextInt(size);
			uf.isConnected(a, b);
		}
		long endTime = System.nanoTime();
		return (endTime - startTime) / 100000000.0;
	}

	public static void main(String[] args) {
		int size = 1000000;
		int m = 1000000;
		QuickFind quickFind = new QuickFind(size);
		System.out.println("QuickFind: "+testUF(quickFind,m)+"s");
		QuickUnion quickUnion = new QuickUnion(size);
		System.out.println("QuickUnion: "+testUF(quickUnion,m)+"s");
		QuickUnionByRank quickUnionByRank= new QuickUnionByRank(size);
		System.out.println("QuickUnionByRank: "+testUF(quickUnionByRank,m)+"s");


	}
}
