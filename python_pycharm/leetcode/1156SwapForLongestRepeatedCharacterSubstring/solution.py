import unittest


class Solution:
    def maxRepOpt1(self, text: str) -> int:
        pass


class SolutionA(Solution):

    def maxRepOpt1(self, text: str) -> int:
        last_val = None
        count_array = [0] * 26

        ord_a = ord('a')
        for val in text:
            index = ord(val) - ord_a

            # 累计，非连续情况，出现的次数
            if last_val != val:
                count_array[index] = count_array[index] + 1
            last_val = val

        _max_result = 0

        _next = 0
        (_next, _size, index) = self.find_next(text, _next, ord_a)
        pre_pre_size = _size
        pre_pre_index = index
        if count_array[index] > 1:
            _max_result = max(_max_result, _size + 1)
        else:
            _max_result = max(_max_result, _size)

        # 已经结束了，代表只有一个字符，从头到尾
        if _next >= text.__len__():
            return _size

        (_next, _size, index) = self.find_next(text, _next, ord_a)
        pre_size = _size
        pre_index = index
        if count_array[index] > 1:
            _max_result = max(_max_result, _size + 1)
        else:
            _max_result = max(_max_result, _size)

        # 已经结束了，代表只有两个字符，从头到位
        if _next >= text.__len__():
            return max(pre_size, pre_pre_size)

        # 超过 三个 的情况
        while _next < text.__len__():
            (_next, _size, index) = self.find_next(text, _next, ord_a)

            if pre_size == 1 and pre_pre_index == index:    # 中间夹杂了一个
                if count_array[index] > 2:
                    _max_result = max(_max_result, pre_pre_size + _size + 1)
                else:
                    _max_result = max(_max_result, pre_pre_size + _size)
            else:
                if count_array[index] > 1:
                    _max_result = max(_max_result, _size + 1)
                else:
                    _max_result = max(_max_result, _size)

            pre_pre_size = pre_size
            pre_size = _size

            pre_pre_index = pre_index
            pre_index = index

        return _max_result

    def find_next(self, text: str, start: int, ord_a: int):
        val = text[start]
        temp = start + 1
        while temp < text.__len__():
            if text[temp] != val:
                return temp, temp - start, ord(val) - ord_a
            temp = temp + 1
        return temp, temp - start, ord(val) - ord_a


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
        self.assertEqual(3, solution.maxRepOpt1('ababa'))
        self.assertEqual(6, solution.maxRepOpt1('aaabaaa'))
        self.assertEqual(4, solution.maxRepOpt1('aaabbaaa'))
        self.assertEqual(5, solution.maxRepOpt1('aaaaa'))
        pass


"""

Given a string text, 
we are allowed to swap two of the characters in the string. 
Find the length of the longest substring with repeated characters.

Example 1:
Input: text = "ababa"
Output: 3
Explanation: We can swap the first 'b' with the last 'a', or the last 'b' with the first 'a'. 
Then, the longest repeated character substring is "aaa", which its length is 3.

Example 2:
Input: text = "aaabaaa"
Output: 6
Explanation: Swap 'b' with the last 'a' (or the first 'a'), 
and we get longest repeated character substring "aaaaaa", which its length is 6.

Example 3:
Input: text = "aaabbaaa"
Output: 4

Example 4:
Input: text = "aaaaa"
Output: 5
Explanation: No need to swap, 
longest repeated character substring is "aaaaa", length is 5.

Example 5:
Input: text = "abcdef"
Output: 1

Constraints:
1 <= text.length <= 20000
text consist of lowercase English characters only.

@author: yline
@time 2020/5/5 09:00
"""
