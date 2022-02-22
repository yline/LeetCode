import unittest


class Solution:
    # List[List[int]]  List[int]
    def findDiagonalOrder(self, matrix: list) -> list:
        pass


class SolutionA(Solution):

    def findDiagonalOrder(self, matrix: list) -> list:
        if matrix.__len__() == 0:
            return []

        if matrix.__len__() == 1:
            return matrix[0]

        _M = matrix.__len__()
        _N = matrix[0].__len__()

        _size = _M * _N
        result_list = [0] * _size

        flag = True
        i = 0
        j = 0
        for index in range(_size):
            result_list[index] = matrix[i][j]

            if flag:  # 右上方向 (i-1, j+1)
                if j + 1 == _N:
                    i = i + 1
                    flag = not flag
                elif i == 0:
                    j = j + 1
                    flag = not flag
                else:
                    i = i - 1
                    j = j + 1
            else:  # 左下方向 (i+1, j-1)
                if i + 1 == _M:
                    j = j + 1
                    flag = not flag
                elif j == 0:
                    i = i + 1
                    flag = not flag
                else:
                    i = i + 1
                    j = j - 1

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

        matrix_a = [
            [1, 2, 3],
            [4, 5, 6],
            [7, 8, 9]
        ]
        print(solution.findDiagonalOrder(matrix_a))
        # 实现具体的校验内容
        pass


"""
Given a matrix of M x N elements (M rows, N columns), 
return all elements of the matrix in diagonal order as shown in the below image.

Example:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output:  [1,2,4,7,5,3,6,8,9]

@author: yline
@time 2020/3/7 22:30
"""
