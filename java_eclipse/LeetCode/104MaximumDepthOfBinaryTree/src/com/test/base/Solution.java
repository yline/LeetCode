package com.test.base;

/**
 * Given a binary tree, find its maximum depth.
 * 给定一个二叉树，计算它的最大深度
 * 
 * The maximum depth is the number of nodes along the longest path 
 * from the root node down to the farthest leaf node.
 * 最大深度，是子节点次数最多的个数
 * 
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 *     3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 *
 * return its depth = 3.
 * 
 * @author YLine
 *
 * 2018年11月23日 上午9:57:15
 */
public interface Solution
{
    public int maxDepth(TreeNode root);
}
