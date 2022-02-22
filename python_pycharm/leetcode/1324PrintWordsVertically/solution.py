import unittest


class Solution:
    # List[str]
    def printVertically(self, s: str) -> list:
        pass


class SolutionA(Solution):

    def printVertically(self, s: str) -> list:
        str_array = s.split()  # 分割成多个字符串
        if str_array is None or str_array.__len__() == 0:
            return []

        # 表示，str_array的长度，不过从后往前先填平了
        str_len_list = [0] * str_array.__len__()

        index = str_array.__len__() - 1
        max_len = str_array[index].__len__()
        str_len_list[index] = max_len
        index = index - 1
        while index >= 0:
            max_len = max(max_len, str_array[index].__len__())
            str_len_list[index] = max_len
            index = index - 1

        # 创建列表
        result_list = [''] * max_len

        for i in range(0, str_len_list.__len__()):
            row_str = str_array[i]

            for j in range(0, str_len_list[i]):
                if j < row_str.__len__():
                    result_list[j] = result_list[j] + row_str[j]
                else:
                    result_list[j] = result_list[j] + ' '

        return result_list


class Example(unittest.TestCase):

    def setUp(self) -> None:
        super().setUp()

    def test_solution_a(self):
        self.solution = SolutionA()
        self.__assert_equal()
        pass

    def __assert_equal(self):
        solution = self.solution

        print(solution.printVertically('HOW ARE YOU'))
        print(solution.printVertically('TO BE OR NOT TO BE'))
        print(solution.printVertically('CONTEST IS COMING'))

        # 实现具体的校验内容
        pass


"""
Given a string s. 
Return all the words vertically in the same order in which they appear in s.

Words are returned as a list of strings, complete with spaces when is necessary. 
(Trailing spaces are not allowed).

Each word would be put on only one column and that in one column 
there will be only one word.

Example 1:
Input: s = "HOW ARE YOU"
Output: ["HAY","ORO","WEU"]
Explanation: Each word is printed vertically. 
 "HAY"
 "ORO"
 "WEU"
 
Example 2:
Input: s = "TO BE OR NOT TO BE"
Output: ["TBONTB","OEROOE","   T"]
Explanation: Trailing spaces is not allowed. 
"TBONTB"
"OEROOE"
"   T"

Example 3:
Input: s = "CONTEST IS COMING"
Output: ["CIC","OSO","N M","T I","E N","S G","T"]

@author: yline
@time 2020/3/7 12:04
"""
