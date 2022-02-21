package com.test.base;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 给一个二叉树，判断它是否是，高度平衡树
 * 
 * For this problem, a height-balanced binary tree is defined as:
 * 高度平衡树定义为：
 * 
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * 两个相邻二叉树左右的高度相差不超过1
 * 
 * Example 1:
 * 
 * Given the following tree [3,9,20,null,null,15,7]:
 * 
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 * 
 * Example 2:
 * 
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 * 
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 * 
 * @author YLine
 *
 * 2018年11月26日 下午9:03:06
 */
public interface Solution
{
    public boolean isBalanced(TreeNode root);
}
