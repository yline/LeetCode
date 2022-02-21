package com.test;

import java.util.ArrayDeque;
import java.util.HashMap;

import com.test.base.Solution;

/**
 * 1，构建Tree树
 * 2，放入数据
 * 3，Tree树遍历一次
 * 
 * Tree树，不适合该案例，运算超时
 * 
 * @author YLine
 *
 * 2019年11月20日 下午5:24:25
 */
public class SolutionA implements Solution
{
    @Override
    public String longestDupSubstring(String S)
    {
        TreeStruct root = new TreeStruct(null, '/', 0);
        
        // 添加char，构建一个Tree树
        for (int i = 0; i < S.length(); i++)
        {
            addString(root, S, i, S.length() - 1);
        }
        
        // Tree树遍历
        ArrayDeque<TreeStruct> queue = new ArrayDeque<>();
        for (TreeStruct childStruct : root.valueMap.values())
        {
            if (childStruct.isKeyOverlap)
            {
                queue.add(childStruct);
            }
        }
        
        TreeStruct targetStruct = null;
        while (!queue.isEmpty())
        {
            TreeStruct pollStruct = queue.pollFirst();

            // 如果，当前的层级比之前高；则赋值
            if (null == targetStruct || pollStruct.keyLevel > targetStruct.keyLevel)
            {
                targetStruct = pollStruct;
            }
            
            // 加入所有满足条件的子
            for (TreeStruct childStruct : pollStruct.valueMap.values())
            {
                if (childStruct.isKeyOverlap)
                {
                    queue.add(childStruct);
                }
            }
        }
        
        // 获取结果
        if (null == targetStruct)
        {
            return "";
        }
        
        // 从下往上遍历
        StringBuilder sBuilder = new StringBuilder();
        TreeStruct temp = targetStruct;
        while (null != temp.parent)
        {
            sBuilder.append(temp.key);
            temp = temp.parent;
        }
        
        return sBuilder.reverse().toString();
    }
    
    private void addString(TreeStruct root, String S, int start, int end)
    {
        TreeStruct temp = root;
        for (int i = start; i <= end; i++)
        {
            temp = temp.addChild(S.charAt(i));
        }
    }
    
    /**
     * 它代表了一个点 + 点对应的子结构
     */
    public static class TreeStruct
    {
        private TreeStruct parent;  // 子结构的上层结构
        
        private char key; // 当前点，内容
        
        private int keyLevel; // 当前点，所在的层级
        
        private boolean isKeyOverlap; // 当前点，是否被重复访问
        
        private HashMap<Character, TreeStruct> valueMap; // 当前子结构，所有的内容
        
        public TreeStruct(TreeStruct parent, char key, int keyLevel)
        {
            this.parent = parent;
            this.key = key;
            this.keyLevel = keyLevel;
            this.isKeyOverlap = false;
        }
        
        private TreeStruct addChild(char childKey)
        {
            if (null == valueMap)
            {
            	valueMap = new HashMap<>();
            }
            
            TreeStruct childStruct = valueMap.get(childKey);
            if (null == childStruct)
            {
            	childStruct = new TreeStruct(this, childKey, keyLevel + 1);
            	valueMap.put(childKey, childStruct);
            }
            else
            {
            	childStruct.isKeyOverlap = true;
            }
            
            return childStruct;
        }
    }
}
