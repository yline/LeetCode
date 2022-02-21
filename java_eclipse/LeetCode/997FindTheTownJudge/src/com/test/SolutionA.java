package com.test;

/**
 * In a town, there are N people labelled from 1 to N.
 * There is a rumor that one of these people is secretly the town judge.
 * 
 * If the town judge exists, then:
 *  1, The town judge trusts nobody.
 *  2, Everybody (except for the town judge) trusts the town judge.
 *  3, There is exactly one person that satisfies properties 1 and 2.
 * 
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 * 
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 * 
 * @author YLine
 *
 * 2019年11月1日 下午12:38:24
 */
public class SolutionA
{
    public int findJudge(int N, int[][] trust)
    {
        boolean[] isTrusted = new boolean[N + 1];
        int[] matchNum = new int[N+1];
        
        for (int i = 0; i < trust.length; i++)
        {
            int a = trust[i][0];
            int b = trust[i][1];
            
            isTrusted[a] = true; // trust other
            if (!isTrusted[b])
            {
                matchNum[b]++;
            }
        }
        
        for (int i = 1; i < isTrusted.length; i++)
        {
            if (!isTrusted[i] && matchNum[i] == N - 1)
            {
                return i;
            }
        }
        
        return -1;
    }
}
