package com.test.base;

import java.util.List;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).
 * 
 * 给定一个二叉树，返回 从下到上的数据数组
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * 
 * @author YLine
 *
 * 2018年11月26日 下午5:38:00
 */
public interface Solution
{
    public List<List<Integer>> levelOrderBottom(TreeNode root);
}
