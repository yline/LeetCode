package com.test.base;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * 给一个数组，数组已经以升序排序；将它转换成 BST
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * 对于这个问题，高度平衡的树，定义成，每个分支，大小的差，不会超过1
 * 
 * 拓展：
 * BST --> Binary Search Tree,二叉搜索树
 * 1，若任意节点的左子树，不空；则左子树上所有节点的值小于根节点的值
 * 2，若任意节点的右子树，不空；则右子树上所有节点的值大于根节点的值
 * 3，任意节点的左、右子树也分别为二叉查找树
 * 4，没有节点值相等的节点
 * 
 * Example:
 * 
 * Given the sorted array: [-10,-3,0,5,9],
 * 
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * 
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * 
 * @author YLine
 *
 * 2018年11月26日 下午7:01:34
 */
public interface Solution
{
    public TreeNode sortedArrayToBST(int[] nums);
}
