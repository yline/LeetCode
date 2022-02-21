package com.test;

/**
 * 没有想到，居然不能使用二分法了。。。但感觉二分法的路，并没有堵死。可能是，3 3 3 3 3 3 1 3 这种情况，把路给堵死了吧
 * 
 * @author YLine
 *
 * 2020年5月14日 下午12:54:08
 */
public class SolutionA
{
    public int findMin(int[] nums)
    {
        if (nums.length == 1)
        {
            return nums[0];
        }
        
        int index = divide(nums, 0, nums.length - 1);
        return nums[index];
    }
    
    private int divide(int[] nums, int left, int right)
    {
        final int startIndex = left;
        final int endIndex = right;
        while (left <= right)
        {
            int mid = (left + right) >> 1;
            
            if (nums[mid] > nums[left] && nums[mid] > nums[right])
            {
                left = mid;
            }
            else if (nums[mid] < nums[left] && nums[mid] < nums[right])
            {
                right = mid;
            }
            else
            {
                for (int i = left; i < right; i++)
                {
                    if (nums[i] > nums[i + 1])
                    {
                        return i + 1;
                    }
                }
                return left;
                /*
                  
                  if (nums[left] == nums[right])
                  {
                     return mid;
                  }
                  else if (nums[left] == nums[mid])
                  {
                     left = mid;
                     
                     if (left + 1 <= endIndex)
                     {
                         if (nums[left] > nums[left + 1])
                         {
                             return left + 1;
                         }
                         else // if (left == startIndex)
                         {
                             return left;
                         }
                         
                     }
                  }
                  else // nums[right] == nums[mid]
                  {
                     right = mid;
                  }*/
            }
        }
        
        return left;
    }
}
