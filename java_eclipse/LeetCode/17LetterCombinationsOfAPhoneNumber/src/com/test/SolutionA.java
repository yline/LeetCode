package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    @Override
    public List<String> letterCombinations(String digits)
    {
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < digits.length(); i++)
        {
            result = compileLetter(result, getContent(digits.charAt(i)));
            System.out.println(result.toString());
        }
        
        return result;
    }
    
    private List<String> compileLetter(List<String> tempList, String str)
    {
        List<String> result = new ArrayList<>();
        
        if (tempList.size() == 0)
        {
            for (int j = 0; j < str.length(); j++)
            {
                result.add(str.charAt(j) + "");
            }
        }
        else
        {
            for (int i = 0; i < tempList.size(); i++)
            {
                for (int j = 0; j < str.length(); j++)
                {
                    result.add(tempList.get(i) + str.charAt(j));
                }
            }
        }
        
        return result;
    }
    
    private String getContent(char c)
    {
        String result = "";
        switch (c)
        {
            case '2':
                result = "abc";
                break;
            case '3':
                result = "def";
                break;
            case '4':
                result = "ghi";
                break;
            case '5':
                result = "jkl";
                break;
            case '6':
                result = "mno";
                break;
            case '7':
                result = "pqrs";
                break;
            case '8':
                result = "tuv";
                break;
            case '9':
                result = "wxyz";
                break;
            default:
                break;
        }
        return result;
    }
}
