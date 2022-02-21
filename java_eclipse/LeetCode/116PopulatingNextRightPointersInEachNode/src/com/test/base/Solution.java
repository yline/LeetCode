package com.test.base;

/**
 * Given a binary tree
给一个二叉树组
Populate each next pointer to point to its next right node. If there is no next right node, 
the next pointer should be set to NULL.
遍历，使得每一个next，指向他的右分支；如果右侧没有，则指向NUlLL

Initially, all next pointers are set to NULL.
初始化，所有的next都指向NULL

Note:

You may only use constant extra space.
空间复杂度O(1)
Recursive approach is fine, implicit stack space does not count as extra space for this problem.
可以使用递归，但不要使用额外的空间
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
Example:
可以假设，他为平衡二叉树

案例：
Given the following perfect binary tree,

     1
   /  \
  2    3
 / \  / \
4  5  6  7

After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL

 * @author YLine
 *
 * 2018年12月10日 下午3:48:32
 */
public interface Solution
{
    public void connect(TreeLinkNode root);
}
