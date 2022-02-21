package com.test.base;

/**
 * Given a binary tree, each node has value 0 or 1.  
 * Each root-to-leaf path represents a binary number 
 * starting with the most significant bit.  
 * 
 * 给定一个二进制数，每个节点的值为0或q;从root到leaf代表一个二进制数
 * 
 * For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, 
 * then this could represent 01101 in binary, which is 13.
 * 
 * 例如 01101代表13
 * 
 * For all leaves in the tree, consider the numbers represented 
 * by the path from the root to that leaf.
 * 
 * 考虑所有的leaf对应的值
 * 
 * Return the sum of these numbers.
 * 返回所有leaf的总和
 * 
 * @author YLine
 *
 * 2019年5月8日 上午6:53:20
 */
public interface Solution
{
    public int sumRootToLeaf(TreeNode root);
}
