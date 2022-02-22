import unittest


class Solution:
    def buddyStrings(self, A: str, B: str) -> bool:
        pass


class SolutionA(Solution):

    def buddyStrings(self, A: str, B: str) -> bool:
        """
        可能的情况有：
        1，刚刚好有两个不同，并且不同的字符交换后相等
        2，所有字符都相等，并且有某个字符出现了两次
        """
        if A.__len__() != B.__len__():
            return False

        _set = set()
        _double = False

        _diff_list = []
        _index = 0
        while _index < A.__len__():
            if A[_index] != B[_index]:
                _diff_list.append(_index)
                if _diff_list.__len__() > 2:
                    return False
            elif not _double:
                if _set.__contains__(A[_index]):
                    _double = True
                else:
                    _set.update(A[_index])
            _index += 1

        if _diff_list.__len__() == 0:
            # 2，所有字符都相等，并且有某个字符出现了两次
            return _double
        elif _diff_list.__len__() == 2:
            first_index = _diff_list[0]
            second_index = _diff_list[1]
            return A[first_index] == B[second_index] and A[second_index] == B[first_index]
        else:
            return False


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
        self.assertEqual(True, solution.buddyStrings("ab", "ba"))
        self.assertEqual(False, solution.buddyStrings("ab", "ab"))
        # self.assertEqual(True, solution.buddyStrings("aa", "aa"))
        # self.assertEqual(False, solution.buddyStrings("", "aa"))
        pass


"""
Given two strings A and B of lowercase letters, 
return true if and only if we can swap two letters in A so that the result equals B.


Example 1:
Input: A = "ab", B = "ba"
Output: true

Example 2:
Input: A = "ab", B = "ab"
Output: false

Example 3:
Input: A = "aa", B = "aa"
Output: true

Example 4:
Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true

Example 5:
Input: A = "", B = "aa"
Output: false

Note:
0 <= A.length <= 20000
0 <= B.length <= 20000
A and B consist only of lowercase letters.

@author: yline
@time 2020/2/19 19:26
"""
