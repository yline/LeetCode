package com.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.test.base.Solution;
import com.test.base.TreeNode;

/**
 * 递归公式：
 * root * f(root, index) = left * f(left, index + 1) + right * f(right, index + 1)
 * 
 * 利用双向链表特点，添加
 * 
 * @author YLine
 *
 * 2018年11月20日 下午6:56:40
 */
public class SolutionB implements Solution
{
    
    @Override
    public List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        List<List<Integer>> list = new ArrayList<>();
        recurse(list, root, 0);
        return list;
    }
    
    private void recurse(List<List<Integer>> list, TreeNode n, int level)
    {
        if (n == null)
            return;
        if (list.size() == level)
        {
            list.add(new LinkedList<Integer>());
        }
        if (level % 2 == 0)
        {
            ((LinkedList<Integer>)list.get(level)).addLast(n.val);
        }
        else
        {
            ((LinkedList<Integer>)list.get(level)).addFirst(n.val);
        }
        recurse(list, n.left, level + 1);
        recurse(list, n.right, level + 1);
    }
    
}
