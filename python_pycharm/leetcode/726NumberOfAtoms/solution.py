import unittest
from queue import Queue

import list_node
from list_node import ListNode


class Solution:
    def countOfAtoms(self, formula: str) -> str:
        pass


class SolutionA(Solution):

    def countOfAtoms(self, formula: str) -> str:
        if formula.__len__() < 3:
            return formula

        index = 0
        lock_size = 0

        result_map = dict()
        map_dict = {0: result_map}

        while index < formula.__len__():

            if formula[index] == '(':  # 左括号
                index += 1
                lock_size += 1
                map_dict[lock_size] = dict()  # 出现左括号，则添加一个map，lock_size作为key

            elif formula[index] == ')':
                _parse = self.__parse_right_bracket(formula, index)
                index += _parse[0]
                _double = _parse[1]

                end_map = map_dict[lock_size]
                lock_size -= 1
                top_map = map_dict[lock_size]

                # 将end_map 内容，全部迁移到top_map中，并且乘以倍数
                for end_key in end_map:
                    if end_key in top_map:
                        top_map[end_key] += end_map[end_key] * _double
                    else:
                        top_map[end_key] = end_map[end_key] * _double
            else:
                current_map = map_dict[lock_size]  # 获取到当前的map

                _parse = self.__parse_atoms(formula, index)
                index += _parse[0]
                atoms = _parse[1]
                if atoms in current_map:
                    current_map[atoms] = current_map[atoms] + _parse[2]
                else:
                    current_map[atoms] = _parse[2]
            pass

        result = ''
        for key in sorted(result_map.keys()):
            result += key
            if result_map[key] != 1:
                result += str(result_map[key])

        return result

    def __parse_right_bracket(self, formula: str, index: int):
        move = 1  # 移动个数
        size = 1  # 倍数

        numbering = False

        # 解析元素
        index += 1
        while index != formula.__len__() and ('0' <= formula[index] <= '9'):
            if not numbering:  # 首次进入数字
                size = ord(formula[index]) - ord('0')
                move += 1
                index += 1
                numbering = True
            else:  # 非首次进入数字，需要算乘法了
                size = size * 10 + ord(formula[index]) - ord('0')
                move += 1
                index += 1
        return move, size

    def __parse_atoms(self, formula: str, index: int):
        """

        :param formula: 公式
        :param index: 下标
        :return: -> 元素（移动个数，元素，元素个数）
        """
        move = 1  # 移动个数
        atoms = formula[index]  # 元素
        size = 1  # 元素个数

        numbering = False

        # 解析元素
        index += 1
        while index != formula.__len__() and not ('A' <= formula[index] <= 'Z'):  # 未结束，非大写
            if 'a' <= formula[index] <= 'z':  # 大写后，接着小写
                atoms += formula[index]
                move += 1
                index += 1
            elif '0' <= formula[index] <= '9':  # 大写后，接着数字
                if not numbering:  # 首次进入数字
                    size = ord(formula[index]) - ord('0')
                    move += 1
                    index += 1
                    numbering = True
                else:  # 非首次进入数字，需要算乘法了
                    size = size * 10 + ord(formula[index]) - ord('0')
                    move += 1
                    index += 1
            else:  # 出现其他情况
                break
        return move, atoms, size


class Example(unittest.TestCase):

    def setUp(self) -> None:
        super().setUp()

    def test_solution_a(self):
        self.solution = SolutionA()
        self.__assert_equal()
        pass

    def __assert_equal(self):
        solution = self.solution

        # 测试，单单大写 + 数字，ok
        self.assertEqual('H2O', solution.countOfAtoms('H2O'))
        self.assertEqual('H2O2', solution.countOfAtoms('H2O2'))
        self.assertEqual('H2Mg14O2', solution.countOfAtoms('H2Mg14O2'))
        self.assertEqual('H2Mg4O2', solution.countOfAtoms('H2Mg4O2'))

        # 测试，带括号的情况
        self.assertEqual('H2MgO2', solution.countOfAtoms('Mg(OH)2'))
        self.assertEqual('K4N2O14S4', solution.countOfAtoms('K4(ON(SO3)2)2'))

        self.assertEqual('B99N33', solution.countOfAtoms("(NB3)33"))

        # 实现具体的校验内容
        pass


"""
Given a chemical formula (given as a string), 
return the count of each atom.
给化学公式，返回原子个数

An atomic element always starts with an uppercase character, 
then zero or more lowercase letters, representing the name.
原子用大写表示
0或小写，表示名称

1 or more digits representing the count of that element may follow 
if the count is greater than 1. If the count is 1, no digits will follow. 
For example, H2O and H2O2 are possible, but H1O2 is impossible.
原子数为1，省略；原子数不为1，则显示出来

Two formulas concatenated together produce another formula. 
For example, H2O2He3Mg4 is also a formula.
He 也是一个原子

A formula placed in parentheses, and a count (optionally added) is also a formula. 
For example, (H2O2) and (H2O2)3 are formulas.
(H2O2)3 也是符合规则

Given a formula, output the count of all elements as a string in the following form:

the first name (in sorted order), followed by its count (if that count is more than 1), 
followed by the second name (in sorted order), followed by its count 
(if that count is more than 1), and so on.

Example 1:
Input: 
formula = "H2O"
Output: "H2O"
Explanation: 
The count of elements are {'H': 2, 'O': 1}.

Example 2:
Input: 
formula = "Mg(OH)2"
Output: "H2MgO2"
Explanation: 
The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.

Example 3:
Input: 
formula = "K4(ON(SO3)2)2"  
-> K4、(O1、N1、(S1、O3)*2)*2 
-> K4、O2、N2、(S2、O6)*2
-> K4、O2、N2、S4、O12
-> K4、N2、S4、O14

Output: "K4N2O14S4"
Explanation: 
The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.

Note:

All atom names consist of lowercase letters, except for the first character which is uppercase.

The length of formula will be in the range [1, 1000].

formula will only consist of letters, digits, and round parentheses, 
and is a valid formula as defined in the problem.

思路：就按照规则，逐个解析过去。只是map要缓存起来

@author: yline
@time 2020/1/26 23:41
"""
