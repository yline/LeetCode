package com.test.base;

import java.util.Arrays;
import java.util.List;

public class ListUtils
{
    public static void printOne(List<String> dataList)
    {
        System.out.println(Arrays.toString(dataList.toArray()));
    }
    
    public static void printTwo(List<List<String>> array)
    {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append('{');
        sBuilder.append('\n');
        for (int i = 0; i < array.size(); i++)
        {
            sBuilder.append(Arrays.toString(array.get(i).toArray()));
            sBuilder.append('\n');
        }
        sBuilder.append('}');
        System.out.println(sBuilder.toString());
    }
}
