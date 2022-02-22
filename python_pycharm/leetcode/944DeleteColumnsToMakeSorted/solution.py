import unittest

import list_node
from list_node import ListNode


class Solution:
    # List[str]
    def minDeletionSize(self, A: list) -> int:
        pass


class SolutionA(Solution):

    def minDeletionSize(self, A: list) -> int:
        if A is None or A.__len__() < 2:
            return 0

        result = 0
        # 列，的下表
        for column in range(A[0].__len__()):
            for row in range(A.__len__() - 1):
                if A[row][column] > A[row + 1][column]:
                    result += 1
                    break

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

        self.assertEqual(1, solution.minDeletionSize(["cba", "daf", "ghi"]))
        self.assertEqual(0, solution.minDeletionSize(["a", "b"]))
        self.assertEqual(3, solution.minDeletionSize(["zyx", "wvu", "tsr"]))

        # 实现具体的校验内容
        pass


"""
We are given an array A of N lowercase letter strings, all of the same length.

Now, we may choose any set of deletion indices, and for each string, 
we delete all the characters in those indices.

For example, if we have an array A = ["abcdef","uvwxyz"] and 
deletion indices {0, 2, 3}, then the final array after deletions is ["bef", "vyz"], 
and the remaining columns of A are ["b","v"], ["e","y"], and ["f","z"].  
(Formally, the c-th column is [A[0][c], A[1][c], ..., A[A.length-1][c]].)

Suppose we chose a set of deletion indices D such that after deletions, 
each remaining column in A is in non-decreasing sorted order.

Return the minimum possible value of D.length.

「non-decreasing sorted order」非递减排序，意思就是递增排序但是允许相等

@author: yline
@time 2020/1/26 23:28
"""
