package com.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Find the minimum length word from a given dictionary words,
 * which has all the letters from the string licensePlate.
 * Such a word is said to complete the given string licensePlate
 * 
 * Here, for letters we ignore case. For example,
 * "P" on the licensePlate still matches "p" on the word.
 * 忽略大小写
 * 
 * It is guaranteed an answer exists.
 * If there are multiple answers, return the one that occurs first in the array.
 * 多个相同，返回靠前的
 * 
 * The license plate might have the same letter occurring multiple times.
 * For example, given a licensePlate of "PP", the word "pair"
 * does not complete the licensePlate, but the word "supper" does.
 * 重复的需要重复出现
 * 
 * Example 1:
 * Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * Output: "steps"
 * 
 * Example 2:
 * Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * Output: "pest"
 * 
 * Note:
 * licensePlate will be a string with length in range [1, 7]. // 1-7
 * licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
 * words will have a length in the range [10, 1000]. // words长度10-1000
 * Every words[i] will consist of lowercase letters, and have length in range [1, 15].
 * 
 * @author YLine
 *
 * 2019年9月2日 下午1:41:31
 */
public class SolutionA
{
    public String shortestCompletingWord(String licensePlate, String[] words)
    {
        // 排序，小的在前面
        Arrays.sort(words, new Comparator<String>()
        {
            
            @Override
            public int compare(String o1, String o2)
            {
                return o1.length() - o2.length();
            }
        });
        
        // 生成hashMap
        int total = 0;
        HashMap<Character, Integer> plateMap = new HashMap<>();
        for (int i = 0; i < licensePlate.length(); i++)
        {
            char temp = licensePlate.charAt(i);
            if (temp >= 'A' && temp <= 'Z') // 大写
            {
                temp = Character.toLowerCase(temp);
                attachMap(plateMap, temp);
                
                total++;
            }
            else if (temp >= 'a' && temp <= 'z') // 小写
            {
                attachMap(plateMap, temp);
                
                total++;
            }
        }
        
        // 校验words
        for (int i = 0; i < words.length; i++)
        {
            HashMap<Character, Integer> cloneMap = cloneMap(plateMap);
            int rest = total;
            for (int j = 0; j < words[i].length(); j++)
            {
                char temp = words[i].charAt(j);
                
                Integer value = cloneMap.get(temp);
                if (null != value && value > 0)
                {
                    rest--;
                    if (rest == 0)
                    {
                        return words[i];
                    }
                    cloneMap.put(temp, value - 1);
                }
            }
        }
        
        return "";
    }
    
    private HashMap<Character, Integer> cloneMap(HashMap<Character, Integer> plateMap)
    {
        HashMap<Character, Integer> result = new HashMap<>(plateMap.size());
        for (Character ch : plateMap.keySet())
        {
            result.put(ch, plateMap.get(ch));
        }
        return result;
    }
    
    private void attachMap(HashMap<Character, Integer> plateMap, char temp)
    {
        Integer value = plateMap.get(temp);
        if (null == value)
        {
            plateMap.put(temp, 1);
        }
        else
        {
            plateMap.put(temp, value + 1);
        }
    }
}
