package com.test;

import com.test.base.Solution;

public class SolutionB implements Solution
{
    @Override
    public int mySqrt(int x)
    {
        if (x == 0)
        {
            return 0;
        }
        
        int left = 1;
        int right = x;
        while (true)
        {
            int mid = left + (right - left) / 2;
            if (mid > x / mid)
                right = mid;
            else
            {
                if ((mid + 1) > x / (mid + 1))
                    return mid;
                left = mid;
            }
        }
        // return 0;
    }
}
