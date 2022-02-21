package com.test.base;

import java.util.List;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, 
 * for example: "ACGAATTCCG". When studying DNA, 
 * it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) 
that occur more than once in a DNA molecule.

Example:
Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 * @author YLine
 *
 * 2018年12月18日 下午8:25:41
 */
public interface Solution
{
    public List<String> findRepeatedDnaSequences(String s);
}
