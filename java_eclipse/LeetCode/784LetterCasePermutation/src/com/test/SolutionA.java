package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create.
 * 
 * 给一个字符串，可以将其中的某个字符，大写或小写；
 * 返回一个列表，包含所有可能的类型
 * 
 * S will be a string with length between 1 and 12.
 * S will consist only of letters or digits.
 * 
 * 思路：递归，最后一次添加
 * 
 * @author YLine
 *
 * 2019年7月1日 上午11:31:32
 */
public class SolutionA
{
    public List<String> letterCasePermutation(String S)
    {
        List<String> resultList = new ArrayList<>();
        char[] letterArray = new char[S.length()];
        
        dfs(resultList, S, letterArray, 0);
        return resultList;
    }
    
    private void dfs(List<String> resultList, String s, char[] letterArray, int index)
    {
        if (index == s.length())
        {
            resultList.add(new String(letterArray));
            return;
        }
        
        char value = s.charAt(index);
        
        // 小写
        if (value >= 'a' && value <= 'z')
        {
            letterArray[index] = value;
            dfs(resultList, s, letterArray, index + 1);
            
            letterArray[index] = Character.toUpperCase(value);
            dfs(resultList, s, letterArray, index + 1);
            return;
        }
        
        // 大写
        if (value >= 'A' && value <= 'Z')
        {
            letterArray[index] = value;
            dfs(resultList, s, letterArray, index + 1);
            
            letterArray[index] = Character.toLowerCase(value);
            dfs(resultList, s, letterArray, index + 1);
            return;
        }
        
        // 其他
        letterArray[index] = value;
        dfs(resultList, s, letterArray, ++index);
    }
}
