package com.test;

import com.test.base.TreeNode;

/**
 * Given a binary tree, determine if it is a complete binary tree.
 * 给一个二叉树，判断是否是完全二叉树
 * 
 * 方案：计算左分支和右分支的个数；只要所有的节点，都满足左右分支数，则满足
 * 
 * left=1 ==> right = 0、1 // 左边，是满二叉树；left/2 =< right <= left
 * left=2 ==> right = 1 // 左边，不是满二叉树；
 * left=3 ==> right = 1、2、3 // 左边，是满二叉树；
 * left=4、5、6 ==> right = 3
 * left=7 ==> right = 3、4、5、6、7 // 左边，是满二叉树；
 * 
 * left >= right
 * 
 * 
 * 即：n > 0
 * 当left == 2^n - 1时；right = [2^(n-1)-1, 2^n-1]
 * 当2^(n-1) - 1 < left < 2^n - 1时；right = 2^(n-1) - 1
 * 
 * The tree will have between 1 and 100 nodes.
 * 
 * 问题：如何计算n
 * 答案：不用计算n，而是通过，左右函数区分，返回不同的递归值，即可【分支数 + 是否是满二叉树】
 * 
 * @author YLine
 *
 * 2019年5月29日 下午7:34:10
 */
public class SolutionA
{
    public boolean isCompleteTree(TreeNode root)
    {
        if (null == root)
        {
            return true;
        }
        
        return findNode(root, new ChildInfo());
    }
    
    /**
     * 
     * @param node
     * @return 是否是完全二叉树
     */
    private boolean findNode(TreeNode node, ChildInfo info)
    {
        if (null == node.left)
        {
            if (null == node.right)
            {
                info.isFull = true;
                info.total = 1;
                info.minRight = 0;
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            if (null == node.right) // 左分支有，右分支没有了
            {
                TreeNode leftNode = node.left;
                if (null != leftNode.left || null != leftNode.right) // 左分支还有分支，则直接结束
                {
                    return false;
                }
                else
                {
                    info.isFull = false; // 非满二叉树
                    info.minRight = 1; // 如果为左侧，右侧的最小值
                    info.total = 2; // 节点 + 子节点，总数
                    return true;
                }
            }
            else
            {
                // 左边的内容
                TreeNode leftNode = node.left;
                boolean isLeftMatch = findNode(leftNode, info);
                if (!isLeftMatch)
                {
                    return false;
                }
                
                int leftSize = info.total;
                int minRight = info.minRight;
                boolean isLeftFull = info.isFull;
                
                // 右边的内容
                TreeNode rightNode = node.right;
                boolean isRightMatch = findNode(rightNode, info);
                if (!isRightMatch)
                {
                    return false;
                }

                if (isLeftFull) // 左边是满二叉树
                {
                    // 两边个数相等，则说明是一个新的满二叉树
                    if (leftSize == info.total)
                    {
                        info.isFull = true;
                        info.minRight = leftSize;
                        info.total = (leftSize << 1) + 1;
                        return true;
                    }
                    
                    // 两边个数不等，但右侧，符合要求；则说明是一个完全二叉树
                    if (leftSize > info.total && info.total >= minRight)
                    {
                        info.isFull = false;
                        info.minRight = leftSize;
                        info.total = info.total + leftSize + 1; // 这个赋值，应该用不到了
                        return true;
                    }
                    
                    return false;
                }
                else // 左边是一个完全二叉树，则右边必须是满二叉树，并且大小必须等于最小值
                {
                    if (info.isFull && info.total == minRight)
                    {
                        info.isFull = false;
                        info.minRight = (minRight << 1) + 1;
                        info.total = info.total + leftSize + 1; // 这个赋值，应该用不到了
                        return true;
                    }
                    
                    return false;
                }
            }
        }
    }
    
    public static class ChildInfo
    {
        public int total; // 该节点以及其子节点的总数
        
        public int minRight; // 如果该节点为左侧，则当它是满二叉树时，minRight <= right <= left; 不是，right == minRight
        
        public boolean isFull; // 是否是，满二叉树
    }
}
