package com.test;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    public int romanToInt(String s)
    {
        int result = 0;
        char temp;
        for (int i = 0; i < s.length(); i++)
        {
            temp = s.charAt(i);
            if (temp == 'M')
            {
                result += 1000;
            }
            else if (temp == 'D')
            {
                result += 500;
            }
            else if (temp == 'C')
            {
                if (i != (s.length() - 1) && (s.charAt(i + 1) == 'M' || s.charAt(i + 1) == 'D'))
                {
                    result -= 100;
                }
                else
                {
                    result += 100;
                }
            }
            else if (temp == 'L')
            {
                result += 50;
            }
            else if (temp == 'X')
            {
                if (i != (s.length() - 1) && (s.charAt(i + 1) == 'C' || s.charAt(i + 1) == 'L'))
                {
                    result -= 10;
                }
                else
                {
                    result += 10;
                }
            }
            else if (temp == 'V')
            {
                result += 5;
            }
            else if (temp == 'I')
            {
                if (i != (s.length() - 1) && (s.charAt(i + 1) == 'X' || s.charAt(i + 1) == 'V'))
                {
                    result -= 1;
                }
                else
                {
                    result += 1;
                }
            }
        }
        return result;
    }
    
}
