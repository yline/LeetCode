import unittest

import list_node
from list_node import ListNode


class Solution:
    # List[str], List[List[int]]
    def palindromePairs(self, words: list) -> list:
        pass

    pass


class SolutionA(Solution):

    def palindromePairs(self, words: list) -> list:
        if words is None or words.__len__() == 0:
            return list()

        # 全部加入 dict
        cache = dict()
        for index in range(words.__len__()):
            cache[words[index]] = index

        result = list()
        # palindrome - ''
        if '' in cache:
            index = cache['']
            for second_index in range(words.__len__()):
                if index != second_index:
                    word = words[second_index]
                    if self.is_palindrome(word, 0, word.__len__()):
                        result.append([index, second_index])
                        result.append([second_index, index])
                pass

        # a - b
        for index in range(words.__len__()):
            word = words[index]
            new_word = word[::-1]
            if new_word in cache:
                second_index = cache[new_word]
                if index != second_index:
                    result.append([index, second_index])
                pass
            pass

        # a.half - b.half
        for index in range(words.__len__()):
            # 获取，word满足回文，的所有值
            word = words[index]

            for val in self.yield_palindrome(word):
                # 包含内容
                if val[0] in cache:
                    second_index = cache[val[0]]
                    # 不是一个值
                    if index != second_index:
                        if val[1] == 1:
                            result.append([index, second_index])
                        else:
                            result.append([second_index, index])
                    pass
                pass
            pass

        return result

    def yield_palindrome(self, word: str):
        """
        :param word:
        :return:
        """
        new_word = word[::-1]

        # 由 0 出发
        for index in range(word.__len__()):
            if index == 0:
                continue

            end_index = index
            end_other = word.__len__() - end_index
            if self.is_palindrome(word, 0, end_index):
                yield new_word[0:end_other], 0

        # 从 末尾 出发
        for index in range(word.__len__()):
            if index == 0:
                continue

            end_index = index
            end_other = word.__len__() - end_index
            if self.is_palindrome(word, end_index, word.__len__()):
                yield new_word[end_other:], 1

    def is_palindrome(self, word, start, end) -> bool:
        left = start
        right = end - 1
        while left < right:
            if word[left] != word[right]:
                return False
            left += 1
            right -= 1
        return True


class SolutionB(Solution):

    def palindromePairs(self, words: list) -> list:
        res = set()
        mirror = {w[::-1]: i for i, w in enumerate(words)}
        for i, w in enumerate(words):
            for k in range(len(w) + 1):
                prefix, suffix = w[:k], w[k:]
                if prefix in mirror and mirror[prefix] != i and suffix == suffix[::-1]:
                    res.add((i, mirror[prefix]))
                if suffix in mirror and mirror[suffix] != i and prefix == prefix[::-1]:
                    res.add((mirror[suffix], i))
        return [[i, j] for i, j in res]


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

        word_a = ['abcd', 'dcba', 'lls', 's', 'sssll']
        result_a = solution.palindromePairs(word_a)
        print(result_a)

        word_b = ['bat', 'tab', 'cat']
        result_b = solution.palindromePairs(word_b)
        print(result_b)

        # 实现具体的校验内容
        pass


"""
Given a list of unique words, 
find all pairs of distinct indices (i, j) in the given list, 

so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:

Input: ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]] 
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]

Example 2:

Input: ["bat","tab","cat"]
Output: [[0,1],[1,0]] 
Explanation: The palindromes are ["battab","tabbat"]

方案1：直接遍历
方案2：先利用单词，将所有的可能的内容，加入hash表

@author: yline
@time 2020/1/19 00:13
"""
