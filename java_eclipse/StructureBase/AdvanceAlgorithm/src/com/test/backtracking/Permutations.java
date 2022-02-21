package com.test.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列
 * 字典全排序，这里不适用。因为不是回溯实现的
 * 
 * LeetCode 31、46
 * 
 * @author YLine
 *
 * 2019年4月15日 下午2:32:04
 */
public class Permutations
{
    private int mIndex = -1;
    
    private boolean mIsLog = true;
    
    public int reorder(char... array)
    {
        if (null == array)
        {
            return 0;
        }
        mIndex = -1;
        reorderInnder(new ArrayList<>(), array);
        return mIndex + 1;
    }
    
    public int reorder(Boolean isLog, char... array)
    {
        if (null == array)
        {
            return 0;
        }
        mIsLog = isLog;
        mIndex = -1;
        reorderInnder(new ArrayList<>(), array);
        return mIndex + 1;
    }
    
    /**
     * 输出全排列
     * @param array 全排列
     */
    private void reorderInnder(List<Character> dataList, char... array)
    {
        if (dataList.size() == array.length)
        {
            mIndex++;
            if (mIsLog)
            {
                System.out.println(Arrays.toString(dataList.toArray()));
            }
            return;
        }
        
        for (char ch : array)
        {
            if (!dataList.contains(ch))
            {
                dataList.add(ch);
                reorderInnder(dataList, array);
                dataList.remove(Character.valueOf(ch));
            }
        }
    }
}
