package com.test;

import java.util.ArrayList;
import java.util.List;

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
    public List<List<Integer>> levelOrderBottom(TreeNode root)
    {
        if (root == null)
        {
            return new ArrayList<>();
        }
        
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, root, 0);
        reverse(result);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, TreeNode node, int level)
    {
        List<Integer> tempList;
        if (level < result.size())
        {
            tempList = result.get(level);
        }
        else
        {
            tempList = new ArrayList<>();
            result.add(tempList);
        }
        
        tempList.add(node.val);
        if (null != node.left)
        {
            dfs(result, node.left, level + 1);
        }
        
        if (null != node.right)
        {
            dfs(result, node.right, level + 1);
        }
    }
    
    private void reverse(List<List<Integer>> result)
    {
        int left = 0, right = result.size() - 1;
        
        List<Integer> temp;
        while (left < right)
        {
            temp = result.get(left);
            result.set(left, result.get(right));
            result.set(right, temp);
            
            left++;
            right--;
        }
    }
}
