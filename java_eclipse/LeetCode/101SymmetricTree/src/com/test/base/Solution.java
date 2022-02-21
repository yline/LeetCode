package com.test.base;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * 给定一个二叉树，判断是否是镜像二叉树
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *    1
 *   / \
 *  2   2
 * / \ / \
 *3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *    1
 *   / \
 *  2   2
 *   \   \
 *   3    3
 * 
 * @author YLine
 *
 * 2018年11月16日 下午2:58:37
 */
public interface Solution
{
    public boolean isSymmetric(TreeNode root);
}
