import unittest


class Solution:
    def longestDecomposition(self, text: str) -> int:
        pass


class SolutionA(Solution):

    def longestDecomposition(self, text: str) -> int:
        right_end = text.__len__() // 2
        return self.dfs_find(0, text.__len__() - 1, right_end, text)

    def dfs_find(self, left: int, right: int, right_end: int, text: str) -> int:
        if left > right:
            return 0

        find_right = right
        while True:
            index = self.find_equal(left, find_right, right_end, text)
            if index == -1:
                return 1

            if index == right_end and left == right:
                return 1

            size = right - index + 1
            if self.is_equal(left, index, size, text):
                return self.dfs_find(left + size, right - size, right_end, text) + 2

            # 更新查找边界
            find_right = index - 1

    def find_equal(self, left: int, right: int, right_end: int, text: str):
        index = right
        while index >= right_end:
            if text[left] == text[index]:
                return index
            index = index - 1
        return -1

    def is_equal(self, left: int, index: int, size: int, text: str):
        for i in range(1, size):
            if text[left + i] != text[index + i]:
                return False
        return True


class SolutionB(Solution):
    def longestDecomposition(self, text: str) -> int:
        N = len(text)
        if N == 0:
            return 0
        for i in range(0, N // 2):
            if text.endswith(text[:i + 1]):
                return 2 + self.longestDecomposition(text[i + 1:N - i - 1])

        return 1


class Example(unittest.TestCase):

    def setUp(self) -> None:
        super().setUp()

    def test_solution_a(self):
        self.solution = SolutionA()
        self.__assert_equal()
        pass

    def test_solution_b(self):
        self.solution = SolutionB()
        self.__assert_equal()
        pass

    def __assert_equal(self):
        solution = self.solution

        # 实现具体的校验内容
        self.assertEqual(7, solution.longestDecomposition('ghiabcdefhelloadamhelloabcdefghi'))
        self.assertEqual(1, solution.longestDecomposition('merchant'))
        self.assertEqual(11, solution.longestDecomposition('antaprezatepzapreanta'))
        self.assertEqual(3, solution.longestDecomposition('aaa'))
        self.assertEqual(4, solution.longestDecomposition('aaaa'))
        self.assertEqual(2, solution.longestDecomposition("elvtoelvto"))
        pass


"""
Return the largest possible k such that there exists a_1, a_2, ..., a_k such that:

Each a_i is a non-empty string;
Their concatenation a_1 + a_2 + ... + a_k is equal to text;
For all 1 <= i <= k,  a_i = a_{k+1 - i}.
 
Example 1:
Input: text = "ghiabcdefhelloadamhelloabcdefghi"
Output: 7
Explanation: We can split the string on "(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)".

Example 2:
Input: text = "merchant"
Output: 1
Explanation: We can split the string on "(merchant)".

Example 3:
Input: text = "antaprezatepzapreanta"
Output: 11
Explanation: We can split the string on "(a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)".

Example 4:
Input: text = "aaa"
Output: 3
Explanation: We can split the string on "(a)(a)(a)".

Constraints:

text consists only of lowercase English characters.
1 <= text.length <= 1000

@author: yline
@time 2020/3/19 12:22
"""
