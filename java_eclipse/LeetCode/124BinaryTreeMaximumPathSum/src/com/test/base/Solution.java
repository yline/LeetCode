package com.test.base;

/**
 * Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node 
in the tree along the parent-child connections. The path must contain at least one node and 
does not need to go through the root.

疑点：path指的是单向，即：不允许以下这种组合
       1
      / \
     2   3
        / \
       2   3

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
 * @author YLine
 *
 * 2018年12月11日 下午6:58:17
 */
public interface Solution
{
    public int maxPathSum(TreeNode root);
}
