package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.Solution;

/**
 * 使用非常暴力的手段
 * 先分首位两段，然后，修改成：是否依次存在在 S中
 * 
 * 耗时：42ms
 * 
 * @author YLine
 *
 * 2018年11月22日 下午5:47:40
 */
public class SolutionD implements Solution
{
    private static final char SINGLE = '?';
    
    private static final char MULTIFY = '*';
    
    @Override
    public boolean isMatch(String s, String p)
    {
        if (p.length() == 0) // 长度为0，则入口处理
        {
            return s.isEmpty();
        }
        
        List<String> pList = splitToArray(p);
        if (pList.size() == 1) // 长度为1
        {
            if (MULTIFY == pList.get(0).charAt(0)) // 如果p = *，则直接通过
            {
                return true;
            }
            
            String pSegment = pList.get(0);
            if (s.length() == pSegment.length())
            {
                return isContain(s, 0, pSegment);
            }
            else
            {
                return false;
            }
        }
        else // 长度大于等于2的处理
        {
            String pFirst = pList.get(0);
            boolean isFirstSpecial = (MULTIFY != pFirst.charAt(0)); // 首个，不为*，特殊处理
            
            // 字符串首部，不符合条件，排除
            if (isFirstSpecial && !isContain(s, 0, pFirst))
            {
                return false;
            }
            
            String pLast = pList.get(pList.size() - 1);
            boolean isLastSpecial = (MULTIFY != pLast.charAt(0)); // 尾部，不为*，特殊处理
            
            // 字符串尾部，不符合条件，排除
            if (isLastSpecial && s.length() >= pLast.length() && !isContain(s, s.length() - pLast.length(), pLast))
            {
                return false;
            }
            
            // 中间的状态了；不需要全等，只需要p的片段，全部依次存在在s中即可
            int sLeft = isFirstSpecial ? pFirst.length() : 0;
            int sRight = isLastSpecial ? s.length() - pLast.length() : s.length();
            int pLeft = isFirstSpecial ? 1 : 0;
            int pRight = isLastSpecial ? pList.size() - 1 : pList.size();
            return isMatch(s, sLeft, sRight, pList, pLeft, pRight);
        }
    }
    
    /**
     * p片段是否全部，依次存在在s中
     * @return true(是)
     */
    private boolean isMatch(String s, int sLeft, int sRight, List<String> pArray, int pLeft, int pRight)
    {
        int pIndex = pLeft + 1; // 开始第一个，一定是 *；
        
        for (int i = sLeft; i <= sRight;) // 默认加校验一次
        {
            if (pIndex >= pRight) // 如果遍历完成
            {
                return true;
            }
            else
            {
                String pSegment = pArray.get(pIndex);
                boolean isContain = isContain(s, i, pSegment);
                if (isContain)
                {
                    pIndex += 2;
                    i += pSegment.length();
                }
                else
                {
                    i++;
                }
            }
        }
        return false;
    }
    
    /**
     * s是否从 start位置，开始，与pSegment相等
     * @param s s字符串
     * @param start 开始位置
     * @param pSegment pSegment
     * @return true 相等
     */
    private boolean isContain(String s, int start, String pSegment)
    {
        if (start + pSegment.length() > s.length())
        {
            return false;
        }
        
        for (int i = 0; i < pSegment.length(); i++)
        {
            if (s.charAt(i + start) != pSegment.charAt(i) && pSegment.charAt(i) != SINGLE)
            {
                return false;
            }
        }
        return true;
    }
    
    /**
     * @param p 输入的格式参数； such as : {**a*a*a*a**}
     * @return 将内容与 * 进行分离；such as : {[*, a, *, a, *, a, *, a, *]}
     */
    private List<String> splitToArray(String p)
    {
        List<String> segmentList = new ArrayList<String>();
        
        int lastIndex = 0;
        for (int i = 0; i < p.length(); i++)
        {
            if (i == 0 && MULTIFY == p.charAt(i)) // 若 首个为 *
            {
                while (i + 1 < p.length() && MULTIFY == p.charAt(i + 1)) // 去除重复的 *
                {
                    i++;
                }
                
                segmentList.add(String.valueOf(MULTIFY));
                lastIndex = i + 1;
                continue;
            }
            
            if (MULTIFY == p.charAt(i)) // 若中途为 *
            {
                if (lastIndex != i)
                {
                    segmentList.add(p.substring(lastIndex, i));
                }
                
                while (i + 1 < p.length() && MULTIFY == p.charAt(i + 1)) // 去除重复的 *
                {
                    i++;
                }
                segmentList.add(String.valueOf(MULTIFY));
                lastIndex = i + 1;
                
                continue;
            }
            
            if (i == p.length() - 1) // 最后，结算一次
            {
                segmentList.add(p.substring(lastIndex, p.length()));
            }
        }
        return segmentList;
    }
}
