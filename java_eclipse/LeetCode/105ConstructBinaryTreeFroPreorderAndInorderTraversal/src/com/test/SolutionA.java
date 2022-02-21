package com.test;

import com.test.base.Solution;
import com.test.base.TreeNode;

/**
 * 递归公式：
 * f(root, preorder, inorder, preleft, inleft, length)
 * （中、左、右）
 * （左、中、右）规则
 * 
 * 左右，全部满足，左闭右开原则
 * 
 * @author YLine
 *
 * 2018年11月16日 下午2:59:01
 */
public class SolutionA implements Solution
{
    
    @Override
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        if (preorder.length == 0)
        {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[0]);
        dfs(root, preorder, 0, inorder, 0, inorder.length);
        return root;
    }
    
    private TreeNode dfs(TreeNode root, int[] preorder, int preLeft, int[] inorder, int inLeft, int length)
    {
        if (length <= 0)
        {
            return null;
        }
        
        int rootIndex = findIndex(inorder, inLeft, length, root.val); // 找到中间位置，但不靠谱，不能直接使用
        
        int leftCount = rootIndex - inLeft; // 左边的位数
        if (leftCount > 0) // 代表，左边还有数据
        {
            TreeNode left = new TreeNode(preorder[preLeft + 1]);
            root.left = dfs(left, preorder, preLeft + 1, inorder, inLeft, leftCount);
        }
        
        int rightCount = length - leftCount - 1; // 右边的位数
        if (rightCount > 0) // 代表，右边还有数据【开，所以是1】
        {
            TreeNode right = new TreeNode(preorder[preLeft + leftCount + 1]);
            root.right = dfs(right, preorder, preLeft + leftCount + 1, inorder, inLeft + leftCount + 1, rightCount);
        }
        
        return root;
    }
    
    /**
     * 找到 value的位置（不存在，则返回-1）【题意，-1不考虑】
     * @param order 数组
     * @param start 数组开始位置
     * @param end 数组结束位置
     * @param value 值
     * @return 值在数组中的位置
     */
    private int findIndex(int[] order, int start, int length, int value)
    {
        for (int i = start; i < start + length; i++)
        {
            if (order[i] == value)
            {
                return i;
            }
        }
        return -1;
    }
}
