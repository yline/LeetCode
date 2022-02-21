package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.Solution;
import com.test.base.TreeNode;

/**
 * 递归公式：
 * root * f(root, index) = left * f(left, index + 1) + right * f(right, index + 1)
 * 
 * 1，先递归添加
 * 2，递归后，对于奇数，进行颠倒
 * 
 * @author YLine
 *
 * 2018年11月16日 下午2:59:01
 */
public class SolutionA implements Solution
{
    
    @Override
    public List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        if (null == root)
        {
            return new ArrayList<>();
        }
        
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, result, 0);
        
        // 每逢奇数就颠倒
        for (int i = 0; i < result.size(); i++)
        {
            if (i % 2 == 1)
            {
                reverse(result.get(i));
            }
        }
        
        return result;
    }
    
    private void dfs(TreeNode node, List<List<Integer>> result, int level)
    {
        List<Integer> data;
        if (result.size() == level)
        {
            data = new ArrayList<>();
            result.add(data);
        }
        else
        {
            data = result.get(level);
        }
        
        data.add(node.val);
        if (null != node.left)
        {
            dfs(node.left, result, level + 1);
        }
        
        if (null != node.right)
        {
            dfs(node.right, result, level + 1);
        }
    }
    
    private void reverse(List<Integer> dataList)
    {
        int left = 0;
        int right = dataList.size() - 1;
        
        int tempValue;
        while (left < right)
        {
            tempValue = dataList.get(left);
            dataList.set(left, dataList.get(right));
            dataList.set(right, tempValue);
            
            left++;
            right--;
        }
    }
}
