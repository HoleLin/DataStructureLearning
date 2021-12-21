package com.holelin.skiptable;

/**
 * @Description: 极客时间<< 数据结构与算法之美>>
 * 跳表实现
 * 跳表中存储的是正整数，并且存储的是不重复的。
 * @Author: HoleLin
 * @CreateDate: 2020/7/16 16:22
 * @UpdateUser: HoleLin
 * @UpdateDate: 2020/7/16 16:22
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class SkipList {

    private static final float SKIP_LIST_P = 0.5f;

    private static final int MAX_LEVEL = 16;

    private int levelCount = 1;
    /**
     * 带头结点链表
     */
    private Node head = new Node();

    public Node find(int value) {
        Node p = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            while (null != p.forwards[i] && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
        }
        if (null != p.forwards[0] && p.forwards[0].data == value) {
            return p.forwards[0];
        } else {
            return null;
        }
    }

    public void insert(int value) {
        int level = randomLevel();
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;
        Node[] update = new Node[level];
        for (int i = 0; i < level; i++) {
            update[i] = head;
        }
        // record every level largest value which smaller than insert value in update[]
        Node p = head;
        for (int i = level - 1; i >= 0; i--) {
            while (null != p.forwards[i] && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            // record every level largest value which smaller than insert value in update[]
            update[i] = p;
        }
        // in search path node next node become new node forwords(next)
        for (int i = 0; i < level; i++) {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }
        // update node hight
        if (levelCount < level) {
            levelCount = level;
        }
    }

    public void delete(int value) {
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            while (null != p.forwards[i] && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }
        if (null != p.forwards[0] && p.forwards[0].data == value) {
            for (int i = levelCount - 1; i >= 0; i--) {
                if (null != update[i].forwards[i] && update[i].forwards[i].data == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }
        while (levelCount > 1 && null == head.forwards[levelCount]) {
            levelCount--;
        }
    }

    // 理论来讲，一级索引中元素个数应该占原始数据的 50%，二级索引中元素个数占 25%，三级索引12.5% ，一直到最顶层。
    // 因为这里每一层的晋升概率是 50%。对于每一个新插入的节点，都需要调用 randomLevel 生成一个合理的层数。
    // 该 randomLevel 方法会随机生成 1~MAX_LEVEL 之间的数，且 ：
    //        50%的概率返回 1
    //        25%的概率返回 2
    //      12.5%的概率返回 3 ...
    private int randomLevel() {
        int level = 1;
        while (Math.random() < SKIP_LIST_P && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    public void printAll() {
        Node p = head;
        while (null != p.forwards[0]) {
            System.out.println(p.forwards[0] + "  ");
            p = p.forwards[0];
        }
        System.out.println();
    }

    /**
     * @Description:
     * @Author: HoleLin
     * @CreateDate: 2020/7/16 18:33
     * @UpdateUser: HoleLin
     * @UpdateDate: 2020/7/16 18:33
     * @UpdateRemark: 修改内容
     * @Version: 1.0
     */
    public class Node {

        private int data = -1;

        private Node[] forwards = new Node[MAX_LEVEL];

        private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");
            return builder.toString();
        }
    }
}
