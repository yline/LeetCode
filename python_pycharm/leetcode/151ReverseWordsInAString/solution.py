import unittest


class Solution:
    def reverseWords(self, s: str) -> str:
        pass


class SolutionA(Solution):

    def reverseWords(self, s: str) -> str:
        result_list = []

        _index = 0
        _left = 0
        _right = 0

        flag_start = False
        while _index < s.__len__():
            if not flag_start:
                if s[_index] != ' ':
                    flag_start = True
                    _left = _index
                    _index += 1
                else:
                    _index += 1
            else:
                if s[_index] != ' ':
                    _index += 1
                else:
                    flag_start = False
                    _right = _index
                    _index += 1
                    result_list.append(s[_left:_right])

        if flag_start:
            result_list.append(s[_left:])

        result = ''
        for index in range(result_list.__len__()):
            if index == 0:
                result = result_list[index] + result
            else:
                result = result_list[index] + ' ' + result
        return result


class SolutionB(Solution):
    def reverseWords(self, s: str) -> str:
        s = s.split()   # 直接实现了分割。

        s.reverse() # 反转
        leng = len(s)
        if leng == 0:
            return ''
        output = s[0]
        for i in range(1, leng):
            output += ' ' + s[i]
        return output


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
        self.assertEqual('blue is sky the', solution.reverseWords('the sky is blue'))
        self.assertEqual('world! hello', solution.reverseWords('  hello world!  '))
        self.assertEqual('example good a', solution.reverseWords('a good   example'))
        pass


"""
Given an input string, reverse the string word by word.

Example 1:
Input: "the sky is blue"
Output: "blue is sky the"

Example 2:
Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:
Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space 
in the reversed string.
 
Note:
A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. 
However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.

Follow up:
For C programmers, try to solve it in-place in O(1) extra space.

@author: yline
@time 2020/2/26 19:08
"""
