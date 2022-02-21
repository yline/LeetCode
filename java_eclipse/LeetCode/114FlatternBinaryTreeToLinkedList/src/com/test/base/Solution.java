package com.test.base;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 将二叉树，转换成链表形状的 root (中序)
 * 
 * For example, given the following tree:
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 
 * The flattened tree should look like:
 * 
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * 
 * @author YLine
 *
 * 2018年11月29日 上午9:20:32
 */
public interface Solution
{
    public void flatten(TreeNode root);
}
