import unittest


class Solution:
    # List[int], List[bool]
    def prefixesDivBy5(self, A: list) -> list:
        pass


class SolutionA(Solution):

    def prefixesDivBy5(self, A: list) -> list:
        if A.__len__() == 0:
            return []

        result = [False] * A.__len__()
        value = A[0]
        result[0] = value % 5 == 0
        for i in range(1, A.__len__()):
            value = (value << 1) + A[i]
            result[i] = value % 5 == 0
        pass
        return result


class Example(unittest.TestCase):

    def setUp(self) -> None:
        super().setUp()

    def test_solution_a(self):
        self.solution = SolutionA()
        self.__assert_equal()
        pass

    def __assert_equal(self):
        solution = self.solution

        # 实现具体的校验内容
        print(solution.prefixesDivBy5([0, 1, 1]))
        pass


"""

Given an array A of 0s and 1s, 
consider N_i: the i-th subarray from A[0] to A[i] interpreted as a binary number 
(from most-significant-bit to least-significant-bit.)

Return a list of booleans answer, 
where answer[i] is true if and only if N_i is divisible by 5.

Example 1:
Input: [0,1,1]
Output: [true,false,false]

Explanation: 
The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.  
Only the first number is divisible by 5, so answer[0] is true.

Example 2:
Input: [1,1,1]
Output: [false,false,false]

Example 3:
Input: [0,1,1,1,1,1]
Output: [true,false,false,false,true,false]

Example 4:
Input: [1,1,1,0,1]
Output: [false,false,false,false,false]
 

Note:
1 <= A.length <= 30000
A[i] is 0 or 1

@author: yline
@time 2020/5/5 01:16
"""
