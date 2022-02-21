package com.test;

import com.test.base.Solution;
import com.test.base.TreeNode;

/**
 * 形成二叉搜索树
 * 
 * 方案1：一直叠加右分支，很流氓，所以算了
 * 方案2：从中间开始分离
 * 
 * @author YLine
 *
 * 2018年11月16日 下午2:59:01
 */
public class SolutionA implements Solution
{
    @Override
    public TreeNode sortedArrayToBST(int[] nums)
    {
        return dfs(nums, 0, nums.length - 1);
    }
    
    private TreeNode dfs(int[] nums, int left, int right)
    {
        if (left > right)
        {
            return null;
        }
        
        int center = (left + right) >> 1;
        TreeNode node = new TreeNode(nums[center]);
        
        node.left = dfs(nums, left, center - 1);
        node.right = dfs(nums, center + 1, right);
        
        return node;
    }
}
