package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.Solution;
import com.test.base.TreeNode;

/**
 * 函数
 * 不能中间断开，因为可能为负数
 * 和 112基本类似
 * 
 * 坑点：末尾处理，如果 直接或递归，倒数第二个也可能会被加载
 * 
 * @author YLine
 *
 * 2018年11月26日 下午9:09:22
 */
public class SolutionA implements Solution
{
    
    @Override
    public List<List<Integer>> pathSum(TreeNode root, int sum)
    {
        if (null == root)
        {
            return new ArrayList<>();
        }
        
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, root, new ArrayList<>(), sum, 0);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, TreeNode node, List<Integer> data, int sum, int value)
    {
        value += node.val;
        
        data.add(node.val);
        if (null == node.left)
        {
            if (null == node.right)
            {
                if (sum == value)
                {
                    result.add(new ArrayList<>(data));
                }
            }
            else
            {
                dfs(result, node.right, data, sum, value);
            }
        }
        else
        {
            if (null == node.right)
            {
                dfs(result, node.left, data, sum, value);
            }
            else
            {
                dfs(result, node.left, data, sum, value);
                dfs(result, node.right, data, sum, value);
            }
        }
        data.remove(data.size() - 1);
    }
}
