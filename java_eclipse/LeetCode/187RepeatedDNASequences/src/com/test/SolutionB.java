package com.test;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.test.base.Solution;

/**
 * 4ms
 * 思路和SolutionA相同
 * @author YLine
 *
 * 2018年12月25日 上午10:37:47
 */
public class SolutionB implements Solution
{
    
    @Override
    public List<String> findRepeatedDnaSequences(String s)
    {
        if (s.length() <= 10)
            return new ArrayList<String>();
        ;
        int cur = 0, r = (1 << 18) - 1;
        BitSet st = new BitSet(1 << 20);
        Set rp = new HashSet();
        char[] ch = s.toCharArray();
        char[] mapping = new char[26];
        mapping['A' - 'A'] = 0;
        mapping['C' - 'A'] = 1;
        mapping['G' - 'A'] = 2;
        mapping['T' - 'A'] = 3;
        for (int i = 0; i < 10; i++)
        {
            cur = cur << 2 | mapping[ch[i] - 'A'];
        }
        st.set(cur);
        for (int i = 10; i < ch.length; i++)
        {
            cur = (cur & r) << 2 | mapping[ch[i] - 'A'];
            if (st.get(cur))
            {
                rp.add(s.substring(i - 9, i + 1));
            }
            else
            {
                st.set(cur);
            }
        }
        
        return new ArrayList<String>(rp);
    }
}
