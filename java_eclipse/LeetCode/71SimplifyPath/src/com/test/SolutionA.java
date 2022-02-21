package com.test;

import java.util.ArrayDeque;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * Or in other words, convert it to the canonical path.
 * 给定一个绝对路径，将其简化为一个，规范路径
 * 
 * In a UNIX-style file system, a period . refers to the current directory.
 * Furthermore, a double period .. moves the directory up a level.
 * For more information, see: Absolute path vs relative path in Linux/Unix
 * 
 * 在Unix类型的文件系统中
 * .  --> 当前目录
 * .. --> 上一个目录
 * 更多的信息，参考 Linux/Unix 的"绝对路径和相对路径"
 * 
 * Note that the returned canonical path must always begin with a slash /,
 * and there must be only a single slash / between two directory names.
 * The last directory name (if it exists) must not end with a trailing /.
 * 返回的规范路径，开头是"/"
 * 两个目录之间只有一个"/"
 * 最后一个目录，结束没有"/"
 * 
 * Also, the canonical path must be the shortest string representing the absolute path.
 * 并且，规范路径，也是最短的字符串
 * 
 * 案例：
 * Example 1:
 * Input: "/home/"
 * Output: "/home"
 * 
 * Example 2:
 * Input: "/../"
 * Output: "/"
 * 
 * Example 3:
 * Input: "/home//foo/"
 * Output: "/home/foo"
 * 
 * Example 4:
 * Input: "/a/./b/../../c/"
 * Output: "/c"
 * 
 * Example 5:
 * Input: "/a/../../b/../c//.//"
 * Output: "/c"
 * 
 * Example 6:
 * Input: "/a//b////c/d//././/.."
 * Output: "/a/b/c"
 * 
 * @author YLine
 *
 * 2019年7月15日 上午10:04:33
 */
public class SolutionA
{
    public String simplifyPath(String path)
    {
        ArrayDeque<String> queue = new ArrayDeque<>();
        dfs(queue, path, 0);
        
        if (queue.isEmpty())
        {
            return "/";
        }
        
        StringBuilder sBuilder = new StringBuilder();
        while (!queue.isEmpty())
        {
            sBuilder.append('/');
            sBuilder.append(queue.poll());
        }
        return sBuilder.toString();
    }
    
    private void dfs(ArrayDeque<String> queue, String path, int index)
    {
        // 开头的位置
        int start = -1;
        while (index < path.length())
        {
            if (path.charAt(index) != '/')
            {
                start = index;
                index++;
                break;
            }
            index++;
        }
        
        if (start != -1)
        {
            int end = path.length();
            while (index < path.length())
            {
                if (path.charAt(index) == '/')
                {
                    end = index;
                    break;
                }
                index++;
            }
            
            String content = path.substring(start, end);
            if (".".equals(content))
            {
                dfs(queue, path, index);
                return;
            }
            else if ("..".equals(content))
            {
                queue.pollLast();
                dfs(queue, path, index);
                return;
            }
            else
            {
                queue.addLast(content);
                dfs(queue, path, index);
                return;
            }
        }
    }
}
