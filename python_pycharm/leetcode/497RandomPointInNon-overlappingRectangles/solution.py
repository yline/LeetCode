import random
import unittest


class Solution:
    # List[List[int]]
    def __init__(self, rects: list):
        pass

    # List[int]
    def pick(self) -> list:
        pass


class SolutionA(Solution):
    """
    内存过高
    """

    def __init__(self, rects: list):
        super().__init__(rects)
        data_list = list()

        for item_rect in rects:
            x = item_rect[0]
            while x <= item_rect[2]:
                y = item_rect[1]
                while y <= item_rect[3]:
                    data_list.append([x, y])
                    y += 1
                x += 1

        self.data_list = data_list
        self.count = data_list.__len__()

    def pick(self) -> list:
        index = random.randint(0, self.count - 1)
        return self.data_list[index]


class ItemValue:

    def __init__(self, item_rect, count) -> None:
        super().__init__()
        self.rect = item_rect
        self.count = count


class SolutionB(Solution):

    def __init__(self, rects: list):
        super().__init__(rects)
        _map = dict()

        key = 0
        count = 0
        for item_rect in rects:
            length = (item_rect[2] - item_rect[0] + 1) \
                     * (item_rect[3] - item_rect[1] + 1)
            count += length

            _map[key] = ItemValue(item_rect, count)
            key += 1

        self.count = count
        self.map = _map

    def pick(self) -> list:
        value = random.randint(0, self.count - 1)  # 0, count-1
        item_index = self.__index_of(self.map, value)

        # 下标
        if item_index == 0:
            _index = value
            _rect = self.map[item_index].rect
        else:
            _index = value - self.map[item_index - 1].count
            _rect = self.map[item_index].rect

        single = _rect[3] - _rect[1] + 1
        x = _rect[0] + _index // single
        y = _rect[1] + _index % single

        return [x, y]

    def __index_of(self, _map: dict, value: int):
        """
        依据，value值，判断
        :param _map: [key] -> [0, 1, 2, 3, 4] -> [2, 6, 8, 12, 6] -> [2, 8, 16, 28, 34]
        :param value: 随机值
        :return:
        """
        left = 0
        right = _map.__len__() - 1

        while left <= right:
            _mid = (left + right) >> 1

            if value < _map[_mid].count and (_mid == 0 or value >= _map[_mid - 1].count):
                return _mid
            elif value >= _map[_mid].count:
                left = _mid + 1
            else:
                right = _mid - 1
        return 0


class Example(unittest.TestCase):

    def setUp(self) -> None:
        super().setUp()

    def test_solution_a(self):
        self.solution = SolutionB([[-2, -2, -1, -1], [1, 0, 3, 0]])
        self.__assert_equal()
        pass

    def __assert_equal(self):
        solution = self.solution

        # 实现具体的校验内容
        for i in range(20):
            print(solution.pick())

        pass


"""
Given a list of non-overlapping axis-aligned rectangles rects, 
write a function pick which randomly and 
uniformily picks an integer point in the space covered by the rectangles.

给一个不会重叠的多个矩阵，随机选取其中的点

Note:


An integer point is a point that has integer coordinates. 
给的点是整数

A point on the perimeter of a rectangle is included in the space 

covered by the rectangles. 
ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] 

are the integer coordinates of the bottom-left corner, 
and [x2, y2] are the integer coordinates of the top-right corner.

length and width of each rectangle does not exceed 2000.

1 <= rects.length <= 100

pick return a point as an array of integer coordinates [p_x, p_y]

pick is called at most 10000 times.

@author: yline
@time 2020/2/12 12:08
"""
