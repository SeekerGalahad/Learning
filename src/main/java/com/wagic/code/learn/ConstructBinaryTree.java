package com.wagic.code.learn;

/**
 * 重建二叉树
 * 问题描述：输入某二叉树的前序遍历和中序遍历结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不包含重复的数字。
 * 例如输入前序遍历序列:{1,2,4,7,3,5,6,8} 和 中序遍历{4,7,2,1,5,3,8,6},
 * 则重建出图中所示二叉树并且输出它的头结点。
 */

public class ConstructBinaryTree {

    /**
     * 二叉树节点类
     */
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode leftNode;
        BinaryTreeNode rightNode;
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * @param preorder 前序遍历
     * @param inorder  中序遍历
     * @return 树的根结点
     */
    public static BinaryTreeNode construct(int[] preorder, int[] inorder) {
        // 输入的合法性判断，两个数组都不能为空，并且都有数据，而且数据的数目相同
        if (preorder == null || inorder == null || preorder.length != inorder.length || inorder.length < 1) {
            return null;
        }
        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * @param preOrder 前序遍历
     * @param ps       前序遍历的开始位置
     * @param pe       前序遍历的结束位置
     * @param inOrder  中序遍历
     * @param is       中序遍历的开始位置
     * @param ie       中序遍历的结束位置
     * @return 树的根结点
     */
    public static BinaryTreeNode construct(int[] preOrder, int ps, int pe,
                                           int[] inOrder, int is, int ie) {
        // 开始位置大于结束位置说明已经没有需要处理的元素了
        if (ps > pe) {
            return null;
        }
/*        // 头结点的值
        int rootValue = preOrder[is];

        // 构建一个只有一个根节点的二叉树
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = rootValue;

        // 只有一个元素的情况下：
        if (ps == pe) {
            if (is == ie && preOrder[is] == inOrder[ie]) {
                System.out.println("只有一个元素");
                return root;
            } else {
                throw new RuntimeException("Invalid input");
            }

        }*/

        // 取前序遍历的第一个数字，就是当前的根结点
        int value = preOrder[ps];
        int index = is;
        // 在中序遍历的数组中找根结点的位置
        while (index <= ie && inOrder[index] != value) {
            index++;
        }

        // 如果在整个中序遍历的数组中没有找到，说明输入的参数是不合法的，抛出异常
        if (index > ie) {
            throw new RuntimeException("Invalid input");
        }

        // 创建当前的根结点，并且为结点赋值
        BinaryTreeNode node = new BinaryTreeNode();
        node.value = value;
        // 递归构建当前根结点的左子树，左子树的元素个数：index-is+1个
        // 左子树对应的前序遍历的位置在[ps+1, ps+index-is]
        // 左子树对应的中序遍历的位置在[is, index-1]
        node.leftNode = construct(preOrder, ps + 1, ps + index - is,
                                inOrder, is, index - 1);
        // 递归构建当前根结点的右子树，右子树的元素个数：ie-index个
        // 右子树对应的前序遍历的位置在[ps+index-is+1, pe]
        // 右子树对应的中序遍历的位置在[index+1, ie]

        node.rightNode = construct(preOrder, ps + index - is + 1, pe,
                                            inOrder, index + 1, ie);
        // 返回创建的根结点
        return node;
    }

    // 中序遍历二叉树
    private static void printTree(BinaryTreeNode root) {
        if (root != null) {
            printTree(root.leftNode);
            System.out.print(root.value + " ");
            printTree(root.rightNode);
        }
    }

    // 普通二叉树
    //              1
    //           /     \
    //          2       3
    //         /       / \
    //        4       5   6
    //         \         /
    //          7       8
    private static void commonBTree() {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // 所有结点都没有右子结点
    //            1
    //           /
    //          2
    //         /
    //        3
    //       /
    //      4
    //     /
    //    5
    private static void onlyleftBTree() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {5, 4, 3, 2, 1};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // 所有结点都没有左子结点
    //            1
    //             \
    //              2
    //               \
    //                3
    //                 \
    //                  4
    //                   \
    //                    5
    private static void onlyRightBTree() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {1, 2, 3, 4, 5};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // 树中只有一个结点
    private static void oneNode() {
        int[] preorder = {1};
        int[] inorder = {1};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // 完全二叉树
    //              1
    //           /     \
    //          2       3
    //         / \     / \
    //        4   5   6   7
    private static void fullBTree() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // 输入空指针
    private static void nullInput() {
        construct(null, null);
    }

    // 输入的两个序列不匹配
    private static void lengthNotEquals() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 8, 1, 6, 3, 7};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    public static void main(String[] args) {
        System.out.println("\ncommonBTree: ");
        commonBTree();
        System.out.println("\nonlyleftBTree: ");
        onlyleftBTree();
        System.out.println("\nonlyRightBTree: ");
        onlyRightBTree();
        System.out.println("\noneNode: ");
        oneNode();
        System.out.println("\nfullBTree: ");
        fullBTree();
        System.out.println("\nnullInput: ");
        nullInput();
        System.out.println("\nlengthNotEquals: ");
        lengthNotEquals();
    }
}