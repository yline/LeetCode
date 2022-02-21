package com.test.base;

import java.util.List;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * 给定一个二叉树，返回层级，以及他的节点值（从左到右 -> 从右到左，然后重复）
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 
 * return its level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * 
 * @author YLine
 *
 * 2018年11月20日 下午1:42:46
 */
public interface Solution
{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root);
}
