import unittest


class Solution:
    # List[int]
    def diStringMatch(self, S: str) -> list:
        pass


class SolutionA(Solution):

    def diStringMatch(self, S: str) -> list:
        if str is None:
            return list()

        _size = S.__len__() + 1
        _array = [0] * _size

        index = 0
        val = 0
        while index < S.__len__():
            if S[index] == 'I':
                _array[index] = val
                val += 1
            index += 1

        _array[S.__len__()] = val
        val += 1

        index = S.__len__() - 1
        while index >= 0:
            if S[index] == 'D':
                _array[index] = val
                val += 1
            index -= 1

        return _array


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
        print(solution.diStringMatch('IDID'))  # [0, 4, 1, 3, 2]
        print(solution.diStringMatch('III'))  # [0, 1, 2, 3]
        print(solution.diStringMatch('DDI'))  # [3, 2, 0, 1]

        pass


"""
Given a string S that only contains "I" (increase) or "D" (decrease), 
let N = S.length.

Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:

If S[i] == "I", then A[i] < A[i+1]
If S[i] == "D", then A[i] > A[i+1]
 

Example 1:
Input: "IDID"
Output: [0,4,1,3,2]

Example 2:
Input: "III"
Output: [0,1,2,3]

Example 3:
Input: "DDI"
Output: [3,2,0,1]
 

Note:
1 <= S.length <= 10000
S only contains characters "I" or "D".

@author: yline
@time 2020/2/12 16:34
"""
