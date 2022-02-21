package com.test.base;

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
}
