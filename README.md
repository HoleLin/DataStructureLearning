# DataStructureLearning
数据结构学习代码笔记
<details>
<summary>目录结构</summary>
<pre>
└─java
    └─com
        └─holelin
            ├─array
            │      Array.java
            │      ArrayTest.java
            │
            ├─bit
            │      Bit.java
            │
            ├─heap
            │      MaxHeap.java
            │      MaxHeapTest.java
            │
            ├─linkedlist
            │      LinkedList.java
            │      LinkedListTest.java
            │
            ├─map
            │      AVLMap.java
            │      BSTMap.java
            │      LinkedListMap.java
            │      Map.java
            │      MapTest.java
            │
            ├─queue
            │      ArrayQueue.java
            │      ArrayQueueTest.java
            │      LinkedListQueue.java
            │      LinkedListQueueTest.java
            │      LoopQueue.java
            │      LoopQueueTest.java
            │      PriorityQueue.java
            │      Queue.java
            │      QueueEfficiencyTest.java
            │
            ├─set
            │      AVLSet.java
            │      BSTSet.java
            │      LinkedListSet.java
            │      Set.java
            │      SetTest.java
            │
            ├─sort
            │      BubbleSortTest.java
            │      BucketSortTest.java
            │      HeapSortTest.java
            │      InsertionSortTest.java
            │      MergeSortTest.java
            │      QuickSortTest.java
            │      SelectionSort.java
            │      ShellSortTest.java
            │      Sorts.java
            │
            ├─stack
            │      ArrayStack.java
            │      ArrayStackTest.java
            │      LinkedListStack.java
            │      LinkedListStackTest.java
            │      Stack.java
            │      StackEfficiencyTest.java
            │
            ├─tree
            │      AVLTree.java
            │      AVLTreeTest.java
            │      BST.java
            │      BSTTest.java
            │      HashTable.java
            │      Merger.java
            │      RedBlackTree.java
            │      RedBlackTreeTest.java
            │      SegmentTree.java
            │      SegmentTreeTest.java
            │      Trie.java
            │      TrieTest.java
            │
            ├─unionfind
            │      QuickFind.java
            │      QuickUnionByPathCompression.java
            │      QuickUnionByPathCompression2.java
            │      QuickUnionByRank.java
            │      QuickUnionBySize.java
            │      UnionFind.java
            │      UnionFindTest.java
            │
            └─util
                    FileOperation.java
                    NumberUtils.java
                    TestConfig.java

</pre>
</details>

<details>
<summary>📚日志</summary>

2019年1月14日20:18:55 
* 完成冒泡排序  
* 将所有排序函数签名写好
* 完成对数器编写

2019年1月21日14:55:22
* 修改插入排序方法
* 完成Array
* 添加动态扩容,动态缩容功能
* 在Array中添加获取第一个元素和获取最后一个元素的方法
* 添加栈的实现及栈的测试

2019年1月30日14:43:57
* 添加循环队列及测试类
* 添加ArrayQueue与LoopQueue(循环队列)的效率比较测试
* 效率测试时发现一个Bug: 使用System.arraycopy()方法时出现ArrayIndexOutOfBoundsException
* 添加LinkedListStack(基于链表实现的栈)以及测试类
* 添加ArrayStack(基于数组实现的栈)以及测试类
* 添加数组栈与链栈的效率比较
* 添加链表实现队列以及测试类
* 添加ArrayQueue、LoopQueue、LinkedListQueue的效率比较测试

2019年2月4日19:43:00
* 添加二分搜索树的实现 
* 添加二分搜索树的添加元素方法 
* 添加二分搜索树的查询元素方法 
* 添加二分搜索树的前序遍历方法(递归实现) 
* 添加二分搜索树的中序遍历方法(递归实现) 
* 添加二分搜索树的后序遍历方法(递归实现) 
* 添加二分搜索是的前序遍历方法(非递归实现,利用栈)
* 添加二分搜索是的层次遍历方法(利用队列实现)
* 添加二分搜索树的测试类

2019年2月11日17:16:27
* 添加二分搜索树查找最大最小元素方法
* 添加二分搜索树删除最大最小元素方法
* 添加二分搜索树删除任意元素方法
* 添加基于二分搜索树实现的集合类以及测试类
* 添加基于链表实现的集合类以及测试类
* 在链表类中添加删除指定元素方法
* 添加LinkedListMap(基于链表实现的映射)
* 添加BSTMap(基于二分搜索树实现的映射)

2019年2月13日15:04:27
* 在Array类中添加交换元素的方法
* 添加基于数组实现的大顶堆以及测试类
* 在Array类中添加新的构造函数(将数组转换为Array)

2019年2月14日19:57:55
* 修改MaxHeap(基于数组实现的大顶堆)获取左右孩子索引方法的注释
* 添加SegmentTree(基于数组实现的线段树)以及测试类

2019年2月16日13:13:30
* 添加SegmentTree更新方法
* 添加Trie(字典树/前缀树)以及测试类
* 添加并查集QuickFind实现
* 添加并查集QuickUnion实现
* 添加QuickFind与QuickUnion性能测试类
* 添加对QuickUnion实现基于size的优化QuickUnionBySize
* 添加对QuickUnion实现基于rank的优化类QuickUnionByRank
* 添加对QuickUnion实现基于路径压缩的优化类QuickUnionByPathCompression
* 添加对QuickUnion实现基于路径压缩的优化类QuickUnionByPathCompression2(递归实现)

2019年2月17日11:48:19
* 添加AVLTree(平衡二叉树)
* 对AVLTree添加右旋转,左旋转方法
* 对AVLTree的LL,RR,LR,RL进行处理
* 对AVLTree添加删除节点方法(对平衡进行处理)
* 添加Map测试类(对BSTMap,LinkedListMap,AVLMap测试)
* 添加对AVLSet测试

2019年2月18日19:54:57
* 添加红黑树的辅助操作左旋转
* 添加红黑树的辅助操作右旋转和颜色翻转
* 添加RedBlackTree(红黑树)的实现以及测试

2019年2月19日20:47:11
* 添加HashTable(哈希表)及测试

2019年2月23日13:43:39
* 添加归并排序及测试
* 添加堆排序及测试
* 添加桶排序

2020年3月8日19:10:12
* 位运算
    * 待补充 使用位运算进行加减乘除
* 添加希尔排序实现并测试
</details>

<details>
<summary>📚待补充</summary>
----

1. 队列部分
    * 不浪费一个空间的循环队列
    * 没有size成员变量的循环队列
2. 链表部分
    * 单链表的递归实现
    * 双链表
    * 循环双链表
    * 数组链表
3. 树部分
    * 二叉树前中后序非递归遍历的经典实现
    * 模拟系统栈前中后序遍历的非递归实现
    * 二叉树Morris遍历前中后序实现
    * 二分搜索树其他方法的非递归实现
    * 前驱和后继操作
    * floor和ceil操作
    * 节点内维护size的二分搜索树
    * rank和select操作
    * 节点内维护depth的二分搜索树
    * 节点内维护count的二分搜索树(支持重复元素的二分搜索树)
    * 有重复元素节点的二分搜索树(另一种支持重复元素的二分搜索树实现)
4. 集合和映射部分
    * 更完整的基于二分搜索树的有序集合
    * 不同底层实现的有序集合对比
    * 更完整的基于二分搜索树的有序映射
    * 不同底层实现的有序映射对比
    * 多重集合
    * 多重映射
    * 基于映射实现的集合
5. 堆和优先队列部分
    * 普通线性结构和顺序线性结构实现的优先队列
    * 最小堆
    * 堆排序
    * 索引堆
    * 双向优先队列
    * 多叉堆
    * 二项堆
    * 斐波那契堆
    * 基于事件堆的粒子检测碰撞
6. 线段树部分
    * 使用节点表示的线段树
    * 链式存储的线段树
    * 动态线段树
    * 线段树的懒惰传播
    * 二维线段树
    * 树状数组(Binary Index Tree)
    * RMQ问题
7. Trie部分
    * Trie的递归实现
    * 使用Trie删除元素
    * TrieSet和TrieMap
    * 压缩字典树
    * 三分搜索Trie (Ternary Search Trie)
    * 子串查询算法
    * 文件压缩算法
    * 模式匹配算法
8. 并查集部分
9. 平衡树和AVL部分
    * AVL树的优化
10. 红黑树部分
    * 红黑树中的删除最大元素
    * 红黑树中的删除最小元素
    * 红黑树中的删除任意元素
    * 基于红黑树的集合和映射
    * 右倾红黑树
    * 《算法导论》中红黑树的实现
    * 2-3 树的实现
    * 伸展树 Splay Tree
11. 哈希表
    * 每个地址存储链表的哈希表
    * 每个地址可以从链表转换到红黑树的哈希表
    * 基于哈希表的无序映射和无序集合
    * 开放地址线性探测解决哈希冲突
    * 开放地址二次探测解决哈希冲突
    * 开放地址双重哈希解决哈希冲突
    * 再哈希法解决哈希冲突
    * Coalesced Hashing
12. B类树
</details>

