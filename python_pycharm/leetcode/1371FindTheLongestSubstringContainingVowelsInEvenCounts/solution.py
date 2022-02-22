import unittest


class Solution:
    def findTheLongestSubstring(self, s: str) -> int:
        pass


class SolutionA(Solution):

    def findTheLongestSubstring(self, s: str) -> int:
        status_array = [-2] * (1 << 5)  # 32种状态

        current = 0  # 第一种状态，默认为0
        status_array[0] = -1  # 第一种状态，默认就存在，位置就是 -1

        result = 0

        _map = {'a': 1, 'i': 2, 'e': 4, 'o': 8, 'u': 16}
        for i in range(s.__len__()):
            if s[i] in _map:
                current = current ^ _map[s[i]]

            if status_array[current] == -2:  # 当前状态，之前是不存在的。也就是，还没有符合要求的长度
                status_array[current] = i
            else:  # 状态已经存在，就直接算最长的长度即可
                result = max(result, i - status_array[current])

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
        self.assertEqual(13, solution.findTheLongestSubstring('eleetminicoworoep'))
        self.assertEqual(5, solution.findTheLongestSubstring('leetcodeisgreat'))
        self.assertEqual(6, solution.findTheLongestSubstring('bcbcbc'))
        pass


"""

Given the string s, 
return the size of the longest substring containing each vowel[元音] an even[偶数] number of times. 
That is, 'a', 'e', 'i', 'o', and 'u' must appear an even number of times.

Example 1:
Input: s = "eleetminicoworoep"
Output: 13
Explanation: The longest substring is "leetminicowor" 
which contains two each of the vowels: e, i and o and zero of the vowels: a and u.

Example 2:
Input: s = "leetcodeisgreat"
Output: 5
Explanation: The longest substring is "leetc" which contains two e's.

Example 3:
Input: s = "bcbcbc"
Output: 6
Explanation: In this case, the given string "bcbcbc" is the longest 
because all vowels: a, e, i, o and u appear zero times.

解题思路：

假设只有一个元素 e，则有两个状态。0个e[偶数] 和 1个e[基数], 而最长的长度就是  0和0的距离  和   1和1的距离  的最大值
假设只有两个元素 e,i, 则有四个状态
[0, 0], [0, 1], [1, 0], [1, 1]   最长的长度就是，这四个状态，之间的距离
同理推动到，5个元素，则有32个状态。问题就变成了：求每个状态之间的距离，的最大值 

@author: yline
@time 2020/5/5 10:22
"""
