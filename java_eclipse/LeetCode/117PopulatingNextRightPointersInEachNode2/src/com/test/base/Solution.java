package com.test.base;

/**
 * Given a binary tree
给一个二叉树
Populate each next pointer to point to its next right node. If there is no next right node, 
the next pointer should be set to NULL.
遍历，使得每一个next指向它的right节点，如果右节点没有，则指向NULL

Initially, all next pointers are set to NULL.
默认，所有next都指向NULL

Note:

You may only use constant extra space.
空间复杂度O(1)
Recursive approach is fine, implicit stack space does not count as extra space for this problem.
遍历可行，但不要引入其他的空间

Example:
案例

Given the following binary tree,

     1
   /  \
  2    3
 / \    \
4   5    7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \    \
4-> 5 -> 7 -> NULL
 * @author YLine
 *
 * 2018年12月10日 下午4:23:30
 */
public interface Solution
{
    public void connect(TreeLinkNode root);
}
