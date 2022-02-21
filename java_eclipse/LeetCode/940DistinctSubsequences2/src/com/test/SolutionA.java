package com.test;

import java.util.HashMap;
import java.util.Set;

import com.test.base.Solution;

/**
 * 参考TreeNode 实现
 * 
 * 执行超时，但结果是对的
 * 
 * @author YLine
 *
 * 2019年5月8日 上午10:18:31
 */
public class SolutionA implements Solution
{
    
    @Override
    public int distinctSubseqII(String S)
    {
        TreeNode root = new TreeNode();
        
        int result = 0;
        for (int i = 0; i < S.length(); i++)
        {
            // 将一个数据添加到TreeNode中，并且返回添加的节点总数
            int temp = addValue(root, S.charAt(i));
            System.out.println("i = " + S.charAt(i) + ", temp = " + temp);
            result += temp;
        }
        
        System.out.println("result = " + result);
        return result;
    }
    
    private int addValue(TreeNode root, char val)
    {
        return addValueDfs(root, val);
    }
    
    private int addValueDfs(TreeNode node, char val)
    {
        int result = 0;
        for (char key : node.childKeySet())
        {
            TreeNode child = node.getChild(key);
            result += addValueDfs(child, val);
        }
        
        if (node.containChild(val))
        {
            return result;
        }
        else
        {
            node.addChild(val);
            return result + 1;
        }
    }

    public static class TreeNode
    {
        private HashMap<Character, TreeNode> child;
        
        public TreeNode()
        {
            this.child = new HashMap<>();
        }
        
        public boolean containChild(char val)
        {
            return child.containsKey(val);
        }
        
        public void addChild(char val)
        {
            child.put(val, new TreeNode());
        }
        
        public TreeNode getChild(char val)
        {
            return child.get(val);
        }
        
        public Set<Character> childKeySet()
        {
            return child.keySet();
        }
    }
}
