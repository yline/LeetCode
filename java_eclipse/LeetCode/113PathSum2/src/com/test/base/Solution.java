package com.test.base;

import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths 
 * where each path's sum equals the given sum.
 * 
 * 有一个二叉树和目标值，有从 root-leaf的路径，满足，节点值的和等于目标值；全部找到
 * 
 * @author YLine
 *
 * 2018年11月27日 下午7:36:54
 */
public interface Solution
{
    public List<List<Integer>> pathSum(TreeNode root, int sum);
}
