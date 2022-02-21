package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a width maxWidth,
 * format the text such that each line has exactly maxWidth characters
 * and is fully (left and right) justified.
 * 
 * 给一串字符串，以及一个最大宽度；格式化text，使得每一行的宽度都是最大宽度；
 * 
 * You should pack your words in a greedy approach;
 * that is, pack as many words as you can in each line.
 * Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * 你需要包装你的单次，使用' '填充
 * 
 * Extra spaces between words should be distributed as evenly as possible.
 * If the number of spaces on a line do not divide evenly between words,
 * the empty slots on the left will be assigned more spaces than the slots on the right.
 * 如果空格不能均分，则左侧比右侧多一个空格
 * 
 * For the last line of text, it should be left justified and
 * no extra space is inserted between words.
 * 对于最后一行，需要左对齐
 * 
 * Note: 注意事项
 * A word is defined as a character sequence consisting of non-space characters only.
 * 字符必须由非空字符串组成
 * 
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * 每个单次的长度，0 < 大小 <= maxWidth
 * 
 * The input array words contains at least one word.
 * 输入的单词，数量大于1
 * 
 * @author YLine
 *
 * 2019年6月16日 上午11:25:54
 */
public class SolutionA
{
    public List<String> fullJustify(String[] words, int maxWidth)
    {
        List<String> result = new ArrayList<>();
        dfs(result, words, maxWidth, 0);
        return result;
    }
    
    private void dfs(List<String> result, String[] words, int maxWidth, int index)
    {
        int wordWidth = words[index].length();
        int spaceWidth = 1;

        int nextIndex = index + 1;
        while (nextIndex < words.length)
        {
            if (wordWidth + spaceWidth + words[nextIndex].length() > maxWidth)
            {
                alignSide(result, words, maxWidth, wordWidth, index, nextIndex);
                dfs(result, words, maxWidth, nextIndex);
                return;
            }
            else
            {
                wordWidth += words[nextIndex].length();
                spaceWidth++;
                nextIndex++;
            }
        }
        
        alignLeft(result, words, maxWidth, index, words.length);
    }
    
    /**
     * 左右两边对齐
     */
    private void alignSide(List<String> result, String[] words, int maxWidth, int wordWidth, int index, int nextIndex)
    {
        if (nextIndex - index == 1)
        {
            // 长度为1，则直接左对齐实现
            alignLeft(result, words, maxWidth, index, nextIndex);
        }
        else
        {
            // 长度大于1，左右对齐需要计算空格[没有末尾]
            char[] lineArray = new char[maxWidth];
            
            int spaceWidth = maxWidth - wordWidth;
            int eachSpace = spaceWidth / (nextIndex - index - 1); // 每个空格，个数
            int restSpace = spaceWidth % (nextIndex - index - 1); // 多余的空格
            
            // 字符填入
            int count = 0;
            for (int i = index; i < nextIndex; i++)
            {
                words[i].getChars(0, words[i].length(), lineArray, count);
                count += words[i].length();
                
                // 间隔
                if (i != nextIndex - 1) // 不是最后一个
                {
                    // 每个空格
                    for (int j = 0; j < eachSpace; j++)
                    {
                        lineArray[count + j] = ' ';
                    }
                    count += eachSpace;
                    
                    // 未能均分的空格
                    if (restSpace > 0)
                    {
                        lineArray[count] = ' ';
                        count += 1;
                        restSpace--;
                    }
                }
            }
            
            result.add(new String(lineArray));
        }
    }
    
    /**
     * 左边对齐
     */
    private void alignLeft(List<String> result, String[] words, int maxWidth, int index, int nextIndex)
    {
        char[] lineArray = new char[maxWidth];
        
        // 字符填入
        int width = 0;
        for (int i = index; i < nextIndex; i++)
        {
            words[i].getChars(0, words[i].length(), lineArray, width);
            width += words[i].length();
            
            // 间隔
            if (i != nextIndex - 1)
            {
                lineArray[width] = ' ';
                width += 1;
            }
        }
        
        // 末尾空格填充
        for (; width < lineArray.length; width++)
        {
            lineArray[width] = ' ';
        }
        
        result.add(new String(lineArray));
    }
}

