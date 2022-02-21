package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.Solution;
import com.test.base.TreeNode;

/**
 * 
 * 简单的就是，直接使用缓存
 * 
 * @author YLine
 *
 * 2019年9月24日 下午5:09:28
 */
public class SolutionA implements Solution
{
    @Override
    public void recoverTree(TreeNode root)
    {
        List<TreeNode> cacheList = new ArrayList<>();
        inorder(cacheList, root);
        
        TreeNode first = null, second = null;
        for (int i = 1; i < cacheList.size(); i++)
        {
            if (cacheList.get(i - 1).val > cacheList.get(i).val)
            {
                if (null == first)
                {
                    first = cacheList.get(i - 1);
                    second = cacheList.get(i);
                }
                else
                {
                    second = cacheList.get(i);
                    break;
                }
            }
        }
        
        swapValue(first, second);
    }
    
    private void inorder(List<TreeNode> cache, TreeNode node)
    {
        if (null == node)
        {
            return;
        }
        
        inorder(cache, node.left);
        cache.add(node);
        inorder(cache, node.right);
    }
    
    private void swapValue(TreeNode a, TreeNode b)
    {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}
