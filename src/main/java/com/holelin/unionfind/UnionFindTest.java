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
		int size = 10000000;
		int m = 10000000;
//		QuickFind quickFind = new QuickFind(size);
//		System.out.println("QuickFind: "+testUF(quickFind,m)+"s");
		QuickUnionBySize quickUnion = new QuickUnionBySize(size);
		System.out.println("QuickUnionBySize: "+testUF(quickUnion,m)+"s");
		QuickUnionByRank quickUnionByRank= new QuickUnionByRank(size);
		System.out.println("QuickUnionByRank: "+testUF(quickUnionByRank,m)+"s");
		QuickUnionByPathCompression quickUnionByPathCompression= new QuickUnionByPathCompression(size);
		System.out.println("QuickUnionByPathCompression: "+testUF(quickUnionByPathCompression,m)+"s");

		QuickUnionByPathCompression2 quickUnionByPathCompression2= new QuickUnionByPathCompression2(size);
		System.out.println("QuickUnionByPathCompression2: "+testUF(quickUnionByPathCompression2,m)+"s");


	}
}
