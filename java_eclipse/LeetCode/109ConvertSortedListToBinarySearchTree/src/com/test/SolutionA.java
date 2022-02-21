package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.ListNode;
import com.test.base.Solution;
import com.test.base.TreeNode;

/**
 * 形成二叉搜索树
 * 
 * 方案1：先转成数组，然后，中序一下
 * 
 * 算法复杂度：
 * n + n(每次只调用一次) = n
 * 空间复杂度：
 * O(n)
 * 
 * @author YLine
 *
 * 2018年11月16日 下午2:59:01
 */
public class SolutionA implements Solution
{
    @Override
    public TreeNode sortedListToBST(ListNode head)
    {
        List<Integer> data = new ArrayList<>();
        while (null != head)
        {
            data.add(head.val);
            head = head.next;
        }
        
        return dfs(data, 0, data.size() - 1);
    }
    
    private TreeNode dfs(List<Integer> data, int left, int right)
    {
        if (left > right)
        {
            return null;
        }
        
        int center = (left + right) >> 1;
        TreeNode node = new TreeNode(data.get(center));
        
        node.left = dfs(data, left, center - 1);
        node.right = dfs(data, center + 1, right);
        
        return node;
    }
}
