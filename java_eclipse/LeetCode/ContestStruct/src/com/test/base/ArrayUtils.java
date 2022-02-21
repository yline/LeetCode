package com.test.base;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

public class ArrayUtils
{
    public static void print(char[][] array)
    {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append('{');
        sBuilder.append('\n');
        for (int i = 0; i < array.length; i++)
        {
            sBuilder.append('{');
            for (int j = 0; j < array[0].length; j++)
            {
                if (j != 0)
                {
                    sBuilder.append(',');
                }
                sBuilder.append(array[i][j]);
            }
            sBuilder.append('}');
            sBuilder.append('\n');
        }
        sBuilder.append('}');
        sBuilder.append('\n');
        System.out.println(sBuilder.toString());
    }
    
    public static void print(int[][] array)
    {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append('{');
        sBuilder.append('\n');
        for (int i = 0; i < array.length; i++)
        {
            sBuilder.append('{');
            for (int j = 0; j < array[0].length; j++)
            {
                if (j != 0)
                {
                    sBuilder.append(',');
                }
                sBuilder.append(array[i][j]);
            }
            sBuilder.append('}');
            sBuilder.append('\n');
        }
        sBuilder.append('}');
        sBuilder.append('\n');
        System.out.println(sBuilder.toString());
    }
    
    public static void assertArrayEqualsWithoutOrder(int[] a, int[] b)
    {
        int[] A = new int[a.length];
        System.arraycopy(a, 0, A, 0, a.length);
        
        int[] B = new int[b.length];
        System.arraycopy(b, 0, B, 0, b.length);
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        assertArrayEquals(A, B);
    }
}
