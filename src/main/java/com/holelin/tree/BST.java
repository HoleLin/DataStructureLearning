package com.holelin.tree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * ClassName: BST
 * 二分搜索树: Binary Search Tree
 * 注: 二分搜索树存储的元素必须有可比较性;
 * 注: 本树不包含重复元素
 * -- 左子树小于节点
 * -- 右子树大于节点
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/4
 */

public class BST<E extends Comparable<E>> {
    /**
     * 二分搜索树根节点
     */
    private Node root;
    /**
     * 树中元素的个数
     */
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    /**
     * 获取二分搜索树中元素的个数
     *
     * @return 二分搜索树中元素的个数
     */
    public int size() {
        return size;
    }

    /**
     * 判断二分搜索树是否为空
     *
     * @return 为空返回true;反之返回false;
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二分搜索树中添加新的元素e
     *
     * @param e 新添加的元素
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 向以node为根的二分搜索树中插入元素E (使用递归)
     *
     * @param node 以node为根
     * @param e    插入的元素
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.data) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.data) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 查询二分搜索树是否包含元素e
     *
     * @param e 查询元素e
     * @return 存在返回true;反之返回false
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 看以node为根的二分搜索树是否包含元素e(递归算法)
     *
     * @param node 以node为根
     * @param e    查询元素e
     * @return 存在返回true;反之返回false
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.equals(node.data)) {
            return true;
        } else if (e.compareTo(node.data) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    /**
     * 二分搜索树的前序遍历以node为根
     *
     * @param node node为根
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrderNR() {
        preOrderNR(root);
    }

    /**
     * 非递归的前序遍历
     * 使用栈来存储二叉树节点，首先将根节点压入栈中，然后不断弹出栈顶元素，
     * 并访问该节点的值，然后将右子节点压入栈中，再将左子节点压入栈中，直到栈为空为止。
     */
    private void preOrderNR(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.print(cur.data + " ");
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public void morrisPreorder() {
        morrisPreorder(root);
    }

    /**
     * Morris前序遍历
     * Morris遍历是一种空间复杂度为O(1)的二叉树遍历算法。
     * 它的基本思想是在遍历过程中，利用节点的空闲指针，将当前节点的右子树的最左节点指向当前节点，
     * 以便在遍历完当前节点的左子树后，能够返回到当前节点。
     *
     * @param node
     */
    private void morrisPreorder(Node node) {
        Node cur = node;
        while (cur != null) {
            if (cur.left == null) {
                System.out.print(cur.data + " ");
                cur = cur.right;
            } else {
                Node pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    System.out.print(cur.data + " ");
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
    }


    /**
     * 中序遍历(顺序是有序的)
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 以node为根,中序遍历
     *
     * @param node 以node为根
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public void inOrderNR() {
        inOrderNR(root);
    }

    /**
     * 非递归的中序遍历
     * 使用栈来存储二叉树节点，首先将根节点压入栈中，然后将左子节点一直压入栈中，直到没有左子节点为止。
     * 然后弹出栈顶元素，并访问该节点的值，然后将右子节点压入栈中，重复上述步骤，直到栈为空为止
     *
     * @param node 以node为根的树
     */
    private void inOrderNR(Node node) {
        if (node == null) {
            return;
        }
        final Stack<Node> stack = new Stack<>();
        // 左-中-右 入栈顺序 左-右
        Node cur = node;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.printf(cur.data + " ");
                cur = cur.right;
            }
        }
    }

    public void morrisInorder() {
        morrisInorder(root);
    }

    private void morrisInorder(Node node) {
        Node cur = node;
        while (cur != null) {
            if (cur.left == null) {
                System.out.print(cur.data + " ");
                cur = cur.right;
            } else {
                Node pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    System.out.print(cur.data + " ");
                    cur = cur.right;
                }
            }
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");

    }

    public void postOrderNR() {
        postOrderNR(root);
    }

    public void postOrderNR2() {
        postOrderNR2(root);
    }

    /**
     * 非递归后序遍历
     * 使用两个栈来存储二叉树节点，首先将根节点压入第一个栈中，然后不断弹出第一个栈顶元素，
     * 并将该节点的左子节点和右子节点分别压入第一个栈中，直到第一个栈为空为止。然后不断弹出第二个栈顶元素，并访问该节点的值，重复上述步骤，直到第二个栈为空为止。
     *
     * @param node
     */
    private void postOrderNR(Node node) {
        if (node == null) {
            return;
        }
        List<String> list = new ArrayList<>();
        final Stack<Node> stack = new Stack<>();
        stack.push(node);
        // 左 右 中 --> 中 右 左 翻转后 左中右
        while (!stack.isEmpty()) {
            final Node cur = stack.pop();
            list.add(cur.data + " ");
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        Collections.reverse(list);
        list.forEach(System.out::print);
    }

    private void postOrderNR2(Node node) {
        List<String> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node prev = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            Node temp = stack.peek();
            if (temp.right == null || temp.right == prev) {
                result.add(temp.data + " ");
                stack.pop();
                prev = temp;
            } else {
                node = temp.right;
            }
        }
        result.forEach(System.out::print);
    }


    /**
     * 层次遍历
     */
    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        ((LinkedList<Node>) q).add(root);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.print(cur.data + " ");
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    /**
     * 生成以node为根节点,深度为depth的描述二叉树的字符串
     *
     * @param node  以node为根节点
     * @param depth 深度为depth
     * @param res   接收字符串
     */
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth)).append("NULL\n");
            return;
        }
        res.append(generateDepthString(depth)).append(node.data).append("\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    /**
     * 寻找二分搜索树的最小元素
     *
     * @return 二分搜索树的最小元素
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root).data;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的结点
     *
     * @param node 以node为根的二分搜索树
     * @return 以node为根的二分搜索树的最小值所在的结点
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 寻找二分搜索树的最大元素
     *
     * @return 二分搜索树的最大元素
     */
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).data;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的结点
     *
     * @param node 以node为根的二分搜索树
     * @return 以node为根的二分搜索树的最小值所在的结点
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 从二分搜索树中删除最小值所在的节点,返回最小值
     *
     * @return 返回最小值
     */
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点
     * 返回删除节点后的新的二分搜索树的根
     *
     * @param node 以node为根的二分搜索树
     * @return 返回删除节点后的新的二分搜索树的根
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从二分搜索树中删除最大值所在的节点,返回最大值
     *
     * @return 返回最大值
     */
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最大节点
     * 返回删除节点后的新的二分搜索树的根
     *
     * @param node 以node为根的二分搜索树
     * @return 返回删除节点后的新的二分搜索树的根
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.data) < 0) {
            // 到node左子树寻找
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.data) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            // 待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            // 带删除节点左右子树均不为空的情况
            // 找到比带删除节点大的最小的节点,即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }


    private class Node {
        /**
         * 数据域
         */
        public E data;
        /**
         * 左子树地址域
         */
        public Node left;
        /**
         * 右子树地址域
         */
        public Node right;

        public Node() {
        }

        public Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


}
