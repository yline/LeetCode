package com.test.single;

/**
 * 单模式字符串匹配
 * @author YLine
 *
 * 2019年3月26日 上午10:02:08
 */
public interface SingleModelSolution
{
    public static final int ERROR = -1;
    
    /**
     * 单模式字符串匹配
     * @param mainStr 主串
     * @param patternStr 模式串
     * @return -1 if not match exist
     */
    int matching(String mainStr, String patternStr);
}
