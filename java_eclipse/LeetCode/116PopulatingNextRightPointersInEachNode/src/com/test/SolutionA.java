package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.Solution;
import com.test.base.TreeLinkNode;

/**
 *  记录最左侧的内容，然后指向下一个，空间复杂度: O(log2(n)) 忽略为O(1)
 * @author YLine
 *
 * 2018年12月10日 下午4:16:42
 */
public class SolutionA implements Solution
{
    
    @Override
    public void connect(TreeLinkNode root)
    {
        dfs(root, new ArrayList<>(), 0);
    }
    
    private void dfs(TreeLinkNode node, List<TreeLinkNode> lastList, int level)
    {
        if (null == node)
        {
            return;
        }
        
        if (lastList.size() > level)
        {
            TreeLinkNode lastNode = lastList.get(level);
            lastNode.next = node;
            lastList.set(level, node);
        }
        else
        {
            lastList.add(node);
        }
        
        dfs(node.left, lastList, level + 1);
        dfs(node.right, lastList, level + 1);
    }
}
