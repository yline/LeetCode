package com.test;

import java.util.HashSet;

/**
 * International Morse Code defines a standard encoding
 * where each letter is mapped to a series of dots and dashes, as follows:
 * "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 * 摩尔斯电码，有一一对应的关系
 * 
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 * 给一下26个对应关系
 * 
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..",
 * "--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * 
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter.
 * 给一串字符，可被写成摩尔斯电码
 * 
 * For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-").
 *  We'll call such a concatenation, the transformation of a word.
 * 例如，cba, 转换而成的结果
 * 
 * Return the number of different transformations among all words we have.
 * 返回，给定的所有值，对应摩尔斯电码不同的结果
 * 
 * @author YLine
 *
 * 2019年8月30日 上午10:13:14
 */
public class SolutionA
{
    private static final String[] lETTER_MORSE = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
        "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
        "--.."};
    
    public int uniqueMorseRepresentations(String[] words)
    {
        HashSet<String> wordSet = new HashSet<>();
        for (int i = 0; i < words.length; i++)
        {
            String temp = transWords(words[i]);
            wordSet.add(temp);
        }
        return wordSet.size();
    }
    
    private String transWords(String word)
    {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++)
        {
            sBuilder.append(lETTER_MORSE[word.charAt(i) - 'a']);
        }
        return sBuilder.toString();
    }
}
