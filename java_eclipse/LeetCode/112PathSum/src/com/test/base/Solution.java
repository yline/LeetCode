package com.test.base;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path 
 * such that adding up all the values along the path equals the given sum.
 * 
 * 有一个二叉树和目标值，判断是否有从 root-leaf的路径，满足，节点值的和等于目标值
 * 
 * @author YLine
 *
 * 2018年11月27日 下午7:36:54
 */
public interface Solution
{
    public boolean hasPathSum(TreeNode root, int sum);
}
