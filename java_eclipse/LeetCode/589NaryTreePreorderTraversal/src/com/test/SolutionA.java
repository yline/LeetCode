package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.Node;

/**
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 * 给一个n叉树，返回它的先序遍历【中 - 左 - 右】
 * 
 * @author YLine
 *
 * 2019年7月22日 上午10:13:33
 */
public class SolutionA
{
    public List<Integer> preorder(Node root)
    {
        List<Integer> resultList = new ArrayList<>();
        dfs(resultList, root);
        return resultList;
    }
    
    private void dfs(List<Integer> result, Node node)
    {
        if (null != node)
        {
            result.add(node.val);
            
            if (null != node.children)
            {
                for (Node child : node.children)
                {
                    dfs(result, child);
                }
            }
        }
    }
}
