package com.test.base;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 给定，两种排序的数组，构造出二叉树
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 可以假设，数组中没有重复的数据
 * 
 * For example, given
 * 
 * inorder = [9,3,15,20,7]  （左，中，右）
 * postorder = [9,15,7,20,3]  (左，右，中)
 * 
 * Return the following binary tree:
 * 
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 
 * @author YLine
 *
 * 2018年11月23日 上午10:15:38
 */
public interface Solution
{
    public TreeNode buildTree(int[] inorder, int[] postorder);
}
