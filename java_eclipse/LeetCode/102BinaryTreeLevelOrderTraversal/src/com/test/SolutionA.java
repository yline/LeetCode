package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.Solution;
import com.test.base.TreeNode;

/**
 * 递归公式：
 * 
 * root * f(root, index) = left * f(left, index + 1) + right * f(right, index + 1)
 * 
 * @author YLine
 *
 * 2018年11月16日 下午2:59:01
 */
public class SolutionA implements Solution
{
    
    @Override
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        if (null == root)
        {
            return new ArrayList<>();
        }
        
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }
    
    private void dfs(TreeNode node, List<List<Integer>> result, int index)
    {
        List<Integer> data;
        if (result.size() == index)
        {
            data = new ArrayList<>();
            result.add(data);
        }
        else
        {
            data = result.get(index);
        }
        
        data.add(node.val);
        
        if (null != node.left)
        {
            dfs(node.left, result, index + 1);
        }
        
        if (null != node.right)
        {
            dfs(node.right, result, index + 1);
        }
    }
    
}
